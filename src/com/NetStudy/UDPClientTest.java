package com.NetStudy;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 模拟发送端
 * 1. 使用 DatagramSocket 指定端口 创建发送端
 * 2. 准备数据 一定转成字节数组
 * 3. 封装成 DatagramPacket 包裹，需要指定目的地
 * 4. 发送包裹 send(DatagramPacket p)
 * 5. 释放资源
 */
public class UDPClientTest {
    public static void main(String[] args) throws Exception{
        System.out.println("sending... ");
        // 1.
        DatagramSocket client = new DatagramSocket(8888);
        // 2.
        /*
        // #输出方式1: 直接字符串String
        // String data = "hello world";
        // byte[] datas = data.getBytes();
         */
        /*
        // #输出方式2: 数据输出流DataOutputStream，输出到 ByteArrayOutputStream，（因为socket发送的是ByteArray）
        // 输出的时候用 BufferedOutputStream 包装一下
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);  // 对字节数组输出流包装成buffered形式
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeChar('a');
        dos.writeInt(10);
        dos.writeDouble(Math.random());
        dos.writeBoolean(true);
        dos.writeUTF("北京尚学堂");
        dos.flush();
        byte[] datas = baos.toByteArray();
         */
        /*
        // #输出方式3：对象流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeChar('a');
        oos.writeInt(10);
        oos.writeDouble(Math.random());
        oos.writeBoolean(true);
        oos.writeUTF("机会是给有准备的人的！");
        oos.writeObject( new SerializablePerson(18, true, "小明"));
        oos.flush();
        byte[] datas = baos.toByteArray();  // 不管包装了几层，都是写到baos里的
         */
        // 输出方式4：文件输入到字节数组流
        byte[] datas = fileToByteArray("images/ball.png");
        // 3.
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 9999));
        // 4.
        client.send(packet);
        // 5.
        client.close();
    }

    public static byte[] fileToByteArray(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] flush = new byte[1024 * 10];  // 缓冲
        int length;
        while ((length = fis.read(flush)) != -1){
            baos.write(flush);
        }
        baos.flush();
        fis.close();
        return baos.toByteArray();
    }
}

/* Person类实现Serializable接口后，Person对象才能被序列化 */
class SerializablePerson implements Serializable {
    // 添加序列化ID，它决定着是否能够成功反序列化
    private static final long serialVersionUID = 1L;
    private int age;
    private boolean isMan;
    private String name;
    public SerializablePerson (int age, boolean isMan, String name){
        super();
        this.age = age;
        this.isMan = isMan;
        this.name = name;
    }
    public String toString(){
        return "Person [age = " + age + ", isMan = " + isMan + ", name = " + name + "]";
    }
}
