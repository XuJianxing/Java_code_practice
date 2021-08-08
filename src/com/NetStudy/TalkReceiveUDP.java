package com.NetStudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 多线程 模拟UDP接收端
 */
public class TalkReceiveUDP implements Runnable{
    private DatagramSocket server;
    public TalkReceiveUDP(int port){
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true){
            // 2. 准备容器 封装成 DatagramPacket 包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, container.length);
            // 3. 阻塞式接受包裹receive(DatagramPacket p)
            try {
                server.receive(packet);  // handle io exception
                // 4. 分析数据 用packet.getData()获取
                byte[] datas = packet.getData();
                String data = new String(datas);
                System.out.println("received: " + data);

                if (data.equals("bye")) break;  // 收到bye就结束
                // 实测没break，不知为何

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" receive end");
        server.close();
    }
}
