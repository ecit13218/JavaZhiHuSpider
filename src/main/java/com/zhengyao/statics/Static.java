package com.zhengyao.statics;

import com.zhengyao.util.StringUtil;
import org.apache.http.cookie.Cookie;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/5/22.
 */
public class Static {
    //1主话题
    public static BlockingQueue<String> topicID = new ArrayBlockingQueue<String>(50);
    public static AtomicInteger UserCount=new AtomicInteger(0);
    public static int userCapacity=1000000;
    //子话题
    public static BlockingQueue<String> SecondtopicID = new ArrayBlockingQueue<String>(50000);
    public static ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<String, Integer>();
    public static String phoneUserAgent="Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_0 like Mac OS X; en-us) " +
            "AppleWebKit/532.9 (KHTML, like Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7";
    public static String userAgent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

}
