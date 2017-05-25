package com.zhengyao.util;


import com.zhengyao.statics.Static;
import com.zhengyao.thread.GetUserInfo;
import com.zhengyao.thread.GetUserUrl;
import com.zhengyao.thread.HandleTopic;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import sun.plugin2.os.windows.Windows;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ZhihuUtil {
    /*
    * 获取话题信息
    * */
    public static void getTopicID() throws ClientProtocolException, IOException, InterruptedException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://www.zhihu.com/topics");
        CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(get);
        // 得到String
        HttpEntity enity = response.getEntity();
        String body = EntityUtils.toString(enity, "UTF-8");
         //System.out.println(body);
        // 字符串处理 及入队
        String regex = "data-id=\"[0-9]{0,6}\"";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(body);
        while (m.find()) {
           // System.out.println(m.group());
            //System.out.println(m.start() + "->" + m.end());
            //String s = m.group();
            //System.out.println(s.substring(9, s.length() - 1));
            Static.topicID.add(m.group().substring(9, m.group().length() - 1));
        }
       // System.out.println("-------------------"+Static.topicID.size()+"size");
        response.close();
        EntityUtils.consume(enity);
    }

    public static void getAllSubTopic() throws InterruptedException, SQLException, IOException {

        //这里的线程不能设置太大 由于知乎的反爬机制，同一ip同一时间发过多请求只能响应部分请求
       // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,30,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(80));
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);// 设置最大连接数
        cm.setDefaultMaxPerRoute(200);// 对每个指定连接的服务器（指定的ip）可以创建并发20 socket进行访问
        CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler())// 设置请求超时后重试次数
                // 默认3次
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build()).setConnectionManager(cm).build();

        //System.out.println("--------------- " + Static.topicID.size() + "--------------- ");
        // 注意这里不能写 i < MyQueue.topicID.size() 因为下面拿一个这里始终要变
        int len = Static.topicID.size();
        for (int i = 0; i < len; i++) {
            String url = "https://www.zhihu.com/node/TopicsPlazzaListV2";
            HttpPost httppost = new HttpPost(url);
            httppost.releaseConnection();
            threadPoolExecutor.execute(new HandleTopic(httpClient, httppost, Static.topicID.poll()));
        }
        // 爬取完后进入下一步
        threadPoolExecutor.shutdown();
        threadShutDown(threadPoolExecutor,httpClient);
    }

    public static void getAllUserUrl() throws InterruptedException, SQLException, IOException {
        //这里的线程不能设置太大 由于知乎的反爬机制，同一ip同一时间发过多请求只能响应部分请求
       // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,30,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(10000));
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);// 设置最大连接数
        cm.setDefaultMaxPerRoute(200);// 对每个指定连接的服务器（指定的ip）可以创建并发20 socket进行访问
        // 上面的设置是我本机对服务器最大的连接数
        //建立client
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(new DefaultHttpRequestRetryHandler())// 设置请求超时后重试次数默认3次
                .setConnectionManager(cm).setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build()).build();
        //setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)  设置以后防止Invalid 'expires' attribute 错误


        System.out.println("Static.SecondtopicID.size()="+Static.SecondtopicID.size());
        // 注意这里还是不能用i<MyQueue.SecondtopicID.size()
        int len = Static.SecondtopicID.size();
        for (int i = 0; i < len; i++) {
            try {
                HttpPost httppost = new HttpPost(
                        "https://www.zhihu.com/topic/" + Static.SecondtopicID.take() + "/followers");
                //System.out.println(httppost.getURI());
                threadPoolExecutor.execute(new GetUserUrl(httpClient, httppost));
                httppost.releaseConnection();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        threadPoolExecutor.shutdown();
        //TimeUnit.SECONDS.sleep(10);
        threadShutDown(threadPoolExecutor,httpClient);
//        System.out.println("*******************");
//        System.out.println(Static.map);
//        System.out.println(Static.map.size());
    }
    public static void getAllUser() throws InterruptedException, SQLException, IOException
    {

        //ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,30,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(Static.userCapacity));
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);// 设置最大连接数
        cm.setDefaultMaxPerRoute(200);// 对每个指定连接的服务器（指定的ip）可以创建并发20 socket进行访问
        // 上面的设置是我本机对服务器最大的连接数
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(new DefaultHttpRequestRetryHandler())// 设置请求超时后重试次数默认3次
                .setConnectionManager(cm).setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build()).build();


        Iterator<Map.Entry<String,Integer>> iterator=Static.map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> map=iterator.next();
            String userurl = "https://www.zhihu.com/people/" +map.getKey();
            //System.out.println(userurl+">>>>>>>>>");
            HttpGet httpget = new HttpGet(userurl);
            threadPoolExecutor.execute(new GetUserInfo(httpClient, httpget));
            httpget.releaseConnection();
        }
        threadPoolExecutor.shutdown();
        threadShutDown(threadPoolExecutor,httpClient);
    }
 private static void threadShutDown(ExecutorService threadPoolExecutor,CloseableHttpClient httpClient)  {
     while (true) {
         if (threadPoolExecutor.isTerminated()) {
             try {
                 httpClient.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             System.out.println(Static.topicID.size());
             System.out.println(
                     "所有的子线程都结束了");
             break;
         }
     }
 }
}
