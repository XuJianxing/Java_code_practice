package com.NetStudy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

//import static com.sun.tools.javac.jvm.ByteCodes.getstatic;

/**
 * 互联网三大基石：URL, HTTP, HTML
 *
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.sxt.cn:80/Java_jQuery_in_action/twelve-inetaddress.html");
        // 对象内的方法
        System.out.println( "协议：" + url.getProtocol());
        System.out.println( "域名IP：" + url.getHost());
        System.out.println( "端口：" + url.getPort());
        System.out.println( "getFile：" + url.getFile());
        System.out.println( "getPath：" + url.getPath());
        System.out.println( "参数：" + url.getQuery());
        System.out.println( "锚点：" + url.getRef());
        URLTest t = new URLTest();
        //Object
        //getstatic()
        ConcurrentHashMap m = new ConcurrentHashMap();

    }

}
