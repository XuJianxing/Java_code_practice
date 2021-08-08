package com.NetStudy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 爬虫
 */
public class SpiderTest {
    public static void main(String[] args) throws Exception{
        // url需要写上协议 才能用
        URL url = new URL("https://www.sxt.cn/Java_jQuery_in_action/twelve-url.html");

        // 输入流
        InputStream is = url.openStream();
        // 输入字节流 读为字符
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        // buffer装饰一下
        BufferedReader br = new BufferedReader(isr);

        String temp = null;
        while ((temp=br.readLine()) != null){
            System.out.println(temp);
        }
        br.close();
    }
}
