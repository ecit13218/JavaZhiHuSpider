package com.zhengyao.thread;

import com.zhengyao.dao.ZhihuUserDao;
import com.zhengyao.entity.ZhiHuUser;
import com.zhengyao.statics.CookiesStatic;
import com.zhengyao.statics.RegexStatic;
import com.zhengyao.statics.Static;
import com.zhengyao.util.SpringContextUtil;
import com.zhengyao.util.StringUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/23.
 */
public class GetUserInfo extends Thread {
    private final CloseableHttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;
    private ZhihuUserDao zhihuUserDao = (ZhihuUserDao) SpringContextUtil.getBean("zhihuUserDao");

    public GetUserInfo(CloseableHttpClient httpClient, HttpGet httpget) {
        this.httpClient = httpClient;
        this.context = HttpClientContext.create();
        this.httpget = httpget;

    }

    @Override
    public void run() {
        try {
            //必须要手机发包才能访问
            String cookie = CookiesStatic.getCookie()[0];
            httpget.setHeader("Cookie", cookie);
            httpget.setHeader("User-Agent", Static.phoneUserAgent);
            CloseableHttpResponse response = httpClient.execute(
                    httpget, context);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String body = EntityUtils.toString(entity, "UTF-8");
                //System.out.println(body);
                ZhiHuUser user = setUserInfo(body);
                if(user.getName().equals("知乎")){
                    System.out.println(cookie);}else{
                System.out.println(user);
                System.out.println("_________________________________________________");
                zhihuUserDao.insert(user);}
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ZhiHuUser setUserInfo(String body) {
        //正则匹配
        Pattern p = Pattern.compile(RegexStatic.userInfoRegex);
        Matcher m = p.matcher(body);
        ZhiHuUser user = new ZhiHuUser();
        while (m.find()) {
            // System.out.println(m.group());
            //  System.out.println("--------------------------------");
            makeUser(m.group(), user);
        }
        //System.out.println(user);
        return user;
    }

    private void makeUser(String content, ZhiHuUser user) {
        if (content.startsWith("<title>")) {
            // System.out.println("name is ="+content);
            if (content.length() > 20)
                user.setName(content.substring(8, content.length() - 13));
            else
                user.setName("知乎");
        }
        if (content.startsWith("url"))
            user.setUserUrl(content.substring(4, content.length() - 2));
        if (content.startsWith("ellipsis"))
            user.setSignature(content.substring(17, content.length() - 2));
        if (content.startsWith("location"))
            user.setLocation(content.substring(22, content.length() - 2));
        if (content.startsWith("business"))
            user.setBussiness(content.substring(22, content.length() - 2));
        if (content.startsWith("position"))
            user.setPostion(content.substring(22, content.length() - 2));
        if (content.startsWith("education item"))
            user.setEducation(content.substring(23, content.length() - 2));
        if (content.startsWith("education-extra"))
            user.setEducationExtra(content.substring(29, content.length() - 2));
        if (content.startsWith("description"))
            user.setProfiles(content.substring(19, content.length() - 11));
        if (content.startsWith("data-gender"))
            user.setSex(((content.substring(13, content.length() - 1)).equals("她")) ? 0 : 1);
        if (content.endsWith("赞同"))
            user.setSuppose(StringUtil.stringToNumber(content, 0, content.length() - 11));
        if (content.endsWith("感谢"))
            user.setThanks(StringUtil.stringToNumber(content, 0, content.length() - 11));
        if (content.startsWith("提问"))
            user.setQuestion(StringUtil.stringToNumber(content, 21, content.length() - 7));
        if (content.startsWith("回答"))
            user.setAnswer(StringUtil.stringToNumber(content, 21, content.length() - 7));
        if (content.startsWith("文章"))
            user.setArticle(StringUtil.stringToNumber(content, 21, content.length() - 7));
        if (content.startsWith("公共编辑"))
            user.setPublicEdit(StringUtil.stringToNumber(content, 23, content.length() - 7));
        if (content.startsWith("关注了"))
            user.setFollowing(StringUtil.stringToNumber(content, 25, content.length() - 9));
        if (content.startsWith("关注者"))
            user.setFollowers(StringUtil.stringToNumber(content, 25, content.length() - 9));
        if (content.endsWith("人浏览"))
            user.setBewatched(StringUtil.stringToNumber(content, 0, content.length() - 13));
    }
}