package com.NetStudy;

/**
 * 模拟师生交流
 * 1. 使用 DatagramSocket 指定端口 创建发送端
 * 2. 准备数据 一定转成字节数组
 * 3. 封装成 DatagramPacket 包裹，需要指定目的地
 * 4. 发送包裹 send(DatagramPacket p)
 * 5. 释放资源
 */
public class UDPTalkTeacher{
    public static void main(String[] args) throws Exception{
        System.out.println("UDP Talk Teacher ");
        // 自己是2，发送到3
        new Thread(new TalkSendUDP(9002, "localhost", 9003)).start();

        new Thread(new TalkReceiveUDP(9001)).start();
    }

}
