package com.NetStudy;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
public class UDPServerTest {
    public static void main(String[] args) throws Exception {
        System.out.println("receive: ");
        // 1.
        DatagramSocket server = new DatagramSocket(9999);
        // 2.
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, container.length);  // 接收方使用的构造方法
        // 3.
        server.receive(packet);
        // 4.
        byte[] datas = packet.getData();
        // #1:
        // String receive = new String(datas);
        /*
        // #2: 传来的是DataOutputStream，所以用DataInputStream接收
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        BufferedInputStream bis = new BufferedInputStream(bais);
        DataInputStream dis = new DataInputStream(bis);
        char c = dis.readChar();
        int i = dis.readInt();
        double d = dis.readDouble();
        boolean b = dis.readBoolean();
        String msg = dis.readUTF();
        System.out.println(c+"_"+i+"_"+d+"_"+b+"_"+msg);
         */
        /*
        // #3: 对象输入流 输入是ByteArray，加了一层buffered，然后再用ObjectInputStream解读对象
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        BufferedInputStream bis = new BufferedInputStream(bais);
        ObjectInputStream ois = new ObjectInputStream(bis);
        char c = ois.readChar();
        int i = ois.readInt();
        double d = ois.readDouble();
        boolean b = ois.readBoolean();
        Object msg = ois.readUTF();
        Object person = ois.readObject();
        // if (msg instanceof String) { }
        System.out.println(c+"_"+i+"_"+d+"_"+b+"_"+msg+"_"+person);
         */
        // #4: 文件传输 传来字节数组，转成文件
        byteArrayToFile_taught(datas, "images/copy.png");
        // 5.
        server.close();
    }

    public static void byteArrayToFile_my(byte[] src, String filePath) throws IOException{
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(src);
        fos.flush();
        fos.close();
    }

    public static void byteArrayToFile_taught(byte[] src, String filePath) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(src);
        FileOutputStream fos = new FileOutputStream(filePath);
        // 分段读取
        byte[] flush = new byte[5];  // 缓冲容器
        int len = -1;
        while ((len = bais.read(flush)) != -1){
            fos.write(flush);
        }
        fos.flush();
        fos.close();  // 文件流要手动关闭
    }
}
