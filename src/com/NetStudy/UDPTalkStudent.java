package com.NetStudy;

/**
 * 模拟服务端 接收UDP数据报
 * 1. 使用 DatagramSocket 指定端口 创建接收端
 * 2. 准备容器 封装成 DatagramPacket 包裹
 * 3. 阻塞式接受包裹receive(DatagramPacket p)
 * 4. 分析数据
 *     byte[] getData()
 *            getLength()
 * 5. 释放资源
 */
public class UDPTalkStudent {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Talk Student ");
        // 自己是0，发送到1
        new Thread(new TalkSendUDP(9000, "localhost", 9001)).start();

        new Thread(new TalkReceiveUDP(9003)).start();
    }

}
