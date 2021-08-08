package com.NetStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 多线程 模拟UDP发送端
 */
public class TalkSendUDP implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;  // reader读输入流。构造函数里要传进去一个Reader类
    private String toIP;
    private int toPort;
    public TalkSendUDP(int port, String toIP, int toPort){
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            // 1.
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true){
            String data;
            byte[] datas;
            try {
                // 2.
                data = reader.readLine();  // handle io exception
                datas = data.getBytes();  // 字符串转为字节数组
                // 3.
                DatagramPacket packet = new DatagramPacket(datas, datas.length,
                        new InetSocketAddress(toIP, toPort));
                // 4.
                client.send(packet);  // handle io exception

                if (data.equals("bye")) break;

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" send end");
        client.close();
    }
}
