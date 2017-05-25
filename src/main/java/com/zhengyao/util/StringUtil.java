package com.zhengyao.util;

/**
 * Created by Administrator on 2017/5/23.
 */
public class StringUtil {
    public static int stringToNumber(String content, int beginIndex, int endIndex) {
        return Integer.parseInt((content.substring(beginIndex, endIndex).equals("") ? "0" :
                content.substring(beginIndex, endIndex)));
    }
    public static String subString(String content, int beginIndex, int endIndex){
        return content.substring(beginIndex,endIndex);
    }
}
