package com.NetStudy;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress : 获取IP地址
 * 没有构造方法，只有静态方法
 *
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        // 转IPv4地址
        // str.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
        System.out.println(Arrays.toString(textToNumericFormatV4("192.168.3.4")));
        testPort();
    }

    public static void testPort(){
        // 包含端口
        InetSocketAddress add = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress add2 = new InetSocketAddress("localhost", 9090);
        System.out.println(add.getAddress());  // 获取InetAddress
        System.out.println(add2.getHostName());
        System.out.println(add2.getPort());
    }

    public static void testIP() throws UnknownHostException{
        // 使用getLocalHost方法创建InetAddress对象 本机
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());  // ip
        System.out.println(address.getHostName());

        // 根据域名得到InetAddress
        address = InetAddress.getByName("www.163.com");
        System.out.println(address.getHostAddress());  // ip
        System.out.println(address.getHostName());

        // IP -> 域名
        byte[] b = {59,110,14,7};

        address = InetAddress.getByName("192.168.195.133");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }

    public static byte[] textToNumericFormatV4(String src) {
        byte[] res = new byte[4];

        long tmpValue = 0;
        int currByte = 0;
        boolean newOctet = true;

        int len = src.length();
        if (len == 0 || len > 15) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            char c = src.charAt(i);
            if (c == '.') {
                if (newOctet || tmpValue < 0 || tmpValue > 0xff || currByte == 3) {
                    return null;
                }
                res[currByte++] = (byte) (tmpValue & 0xff);
                tmpValue = 0;
                newOctet = true;
            } else {
                int digit = Character.digit(c, 10);
                if (digit < 0) {
                    return null;
                }
                tmpValue *= 10;
                tmpValue += digit;
                newOctet = false;
            }
        }
        if (newOctet || tmpValue < 0 || tmpValue >= (1L << ((4 - currByte) * 8))) {
            return null;
        }
        switch (currByte) {
            case 0:
                res[0] = (byte) ((tmpValue >> 24) & 0xff);
            case 1:
                res[1] = (byte) ((tmpValue >> 16) & 0xff);
            case 2:
                res[2] = (byte) ((tmpValue >>  8) & 0xff);
            case 3:
                res[3] = (byte) ((tmpValue >>  0) & 0xff);
        }
        return res;
    }
}
