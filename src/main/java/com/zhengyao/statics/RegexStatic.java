package com.zhengyao.statics;

/**
 * Created by Administrator on 2017/5/24.
 */
public class RegexStatic {
    public static String userInfoRegex = "<title>.*</title>|url=https://www.zhihu.com/people/.*|ellipsis\" title=\".*\">|data-gender=\".\"|location item\" title=.{0,30}\">" +
            "|business item\" title=.{0,30}\">|position item\" title=.{0,30}\">|education item\" title=.{0,30}\">|education-extra item\" title=.{0,30}'>" +
            "|description-input\">.*</textarea>|[0-9]* 个回答|[0-9]*</strong>赞同|[0-9]*</strong>感谢|提问\\n<span class=\"num\">[0-9]*</span>" +
            "|回答\\n<span class=\"num\">[0-9]*</span>|文章\\n<span class=\"num\">[0-9]*</span>|收藏\\n<span class=\"num\">[0-9]*</span>" +
            "|公共编辑\\n<span class=\"num\">[0-9]*</span>|关注了</span><br />\\n<strong>[0-9]*</strong>|关注者</span><br />\\n<strong>[0-9]*</strong>" +
            "|[0-9]*</strong> 人浏览";
    /*<title>.*</title>    //姓名
    url=https://www.zhihu.com/people/.* //主页地址
    data-gender="."  //性别
    ellipsis" title=".*">   //个人签名
    location item" title=.{0,30}">  //所在地
    business item" title=.{0,30}">  //所在行业
    position item" title=.{0,30}">  //市场推广
    education item" title=.{0,30}"> //大学
    education-extra item" title=.{0,30}'> //专业
    description-input">.*</textarea>//个人简介
     [0-9]* 个回答//被编辑推荐收录了多少个回答
    [0-9]*</strong>赞同 //赞同
    [0-9]*</strong>感谢  //感谢
    提问\n<span class="num">[0-9]*</span>  //提问(返回的就是0，应该是js重新去获取了)
    回答\n<span class="num">[0-9]*</span>  //回答
    文章\n<span class="num">[0-9]*</span>  //文章
    收藏\n<span class="num">[0-9]*</span>  //收藏
    公共编辑\n<span class="num">[0-9]*</span>//公共编辑
    关注了</span><br />\n<strong>[0-9]*</strong>//关注了多少人
    关注者</span><br />\n<strong>[0-9]*</strong>//多少粉丝
     [0-9]*</strong> 人浏览  //被多少人浏览*/
}
