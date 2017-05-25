package com.zhengyao.statics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/24.
 */
public class CookiesStatic {
    public static String[] cookies=new String[3];
    public static String[] xsrfToken=new String[3];
    static {
        cookies[0]="d_c0=\"AJACpHw99gqPThSQP9YR5Vhe2zTn6X7Je-o=|1481103590\"; " +
                "_zap=815b6baa-2f7e-461f-9173-074c3a3211de;" +
                " q_c1=011b7371dae246c78a26521eec0befe2|1494323486000|1488531596000; " +
                "r_cap_id=\"NDVkNjA2ZmQ1YTBlNDg4Njg3ZDJhYWU3MGRlMWY0MTI=|1494323486|dc2525523710b0caacb449341382e4ce3ee553ed\"; " +
                "cap_id=\"Y2JkOWIxYTM0OTgwNGU2ZTgwZjExYzE1YTI0M2Q5MDQ=|1494323486|d206a7d25c8ce526b15371fb583381540e588348\"; " +
                "_xsrf=e7e75965eeb6c290674b2b3fe1721812;" +
                " aliyungf_tc=AQAAAMSSsjiQUAgA/QUjfT/N9LAKDNpp; " +
                "acw_tc=AQAAAJDkHzvfbQgA/QUjfbWcIimaJvW5; __utma=51854390.1458273248.1495334741.1495334741.1495592887.2; " +
                "__utmb=51854390.0.10.1495592887; __utmc=51854390; " +
                "__utmz=51854390.1495093034.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); " +
                "__utmv=51854390.100-1|2=registration_date=20160114=1^3=entry_date=20160114=1; " +
                "z_c0=Mi4wQUJDS1A3ZUZUd2tBa0FLa2ZEMzJDaGNBQUFCaEFsVk5MQjQ1V1FCZU95a2RRR25zMTFuNkhrMXpSS0JOejJWNWxB|1495592887|f4aeed01c6aa561a2545a2e128562f8c04f0c94d;";//zhengyao
        cookies[1]="q_c1=d1350a9266904a2aad02d12f3ea2767e|1493780739000|1493780739000; " +
                "d_c0=\"AJBC8_gkswuPTlfEGuOkFwp5vJZYRXBcW7A=|1493780739\"; " +
                "_zap=795f7743-c94b-4390-8d5b-84a2f97d5c0b; _xsrf=d526430dbb6cd56e89688efb376afaa4; " +
                "aliyungf_tc=AQAAAJLZrHAyAgIABwlne1JZ8pmMLCaH; acw_tc=AQAAAIlM/R4mCQIABwlnezeTgTkWes5d;" +
                " r_cap_id=\"NGMzMTQ5OWRkMzNhNGE4MmJhZjFiNmUxNTgxMTEyNDM=|1495590361|469f5c60bd840ccbbaf2e5eaad65f006f4a7c74a\"; " +
                "cap_id=\"MTZiZDUxNWI2M2Y5NDIwMGJiNDIwY2EwNDkxNWIwNTY=|1495590361|69e4a0d7fd6e0d681e87714d1e0ff5db7e3e2e17\"; " +
                "__utma=51854390.1630818955.1495522510.1495522510.1495590346.2; __utmb=51854390.0.10.1495590346; __utmc=51854390; " +
                "__utmz=51854390.1495522510.1.1.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/people/sirforest/answers; " +
                "__utmv=51854390.000--|2=registration_date=20140516=1^3=entry_date=20170503=1;" +
                " l_n_c=1; z_c0=Mi4wQUVBQ1NFM2h3QXNBa0VMei1DU3pDeGNBQUFCaEFsVk40WEpNV1FEWDNJS1I1bTh1dU94U3kyYkRQSHpoNG90emJ3|1495590397|328769b1ac4bfa729defa4246af5f035eca8b6fd;";//goumai
        cookies[2]="q_c1=ab492c1a33644803a8d7faa4cc2e3320|1495589525000|1495589525000; " +
                "d_c0=\"AECCafIYzguPThPGuOVMhQDdomP2DdBQLs0=|1495589526\"; " +
                "_zap=88f0c714-5ea2-4c65-860e-c7181af17b23; " +
                "r_cap_id=\"MDkwNzhlYzMyZTJkNGNlNjlhYWYyNDIzZjEzM2EwNTA=|1495590347|7f4a91e35d07ad1a53b4e974d8f717b7df06d183\"; " +
                "cap_id=\"MGU3MDMxNzdhYzM3NDg5ZDk5Yjg5ODFjNzQ5M2NhNzU=|1495590347|31b8daa46d976c6726575f183ba29553c4512176\"; " +
                "__utmt=1; aliyungf_tc=AQAAANR11STpAA0ABwlne5ipM59gz/Ib; acw_tc=AQAAAPAhpwBmFQ0ABwlne0v2t3bXuZQj; " +
                "_xsrf=66c2ca11f415a4ef316eaf351ed37e31; " +
                "l_n_c=1; __utma=51854390.878550592.1495589515.1495589515.1495589515.1; " +
                "__utmb=51854390.17.9.1495589632834; " +
                "__utmc=51854390; __utmz=51854390.1495589515.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); " +
                "__utmv=51854390.100--|2=registration_date=20161016=1^3=entry_date=20161016=1; " +
                "z_c0=Mi4wQUdDQVNySXJzd29BUUlKcDhoak9DeGNBQUFCaEFsVk4wM05NV1FDZGN4WnB3V291YjlWSkswX0hXclpFd01QMGxB|1495590622|884e320133da52428ff306aa68b599729e220d94";//luochangp
        xsrfToken[0]="e7e75965eeb6c290674b2b3fe1721812";
        xsrfToken[1]="d526430dbb6cd56e89688efb376afaa4";
        xsrfToken[2]="66c2ca11f415a4ef316eaf351ed37e31";
    }
    public static String[] getCookie(){
        Random random=new Random();
        int index=random.nextInt(3);
        //System.out.println("cookie index="+index);
        return new String[]{cookies[index],xsrfToken[index]};
    }
}
