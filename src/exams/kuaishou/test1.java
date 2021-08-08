package exams.kuaishou;
/*
判断是不是有效的ipv4或者ipv6地址或者neither
 */
import java.util.Arrays;
import java.util.Scanner;
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String[] ipv4 = ip.split("\\.");
        String[] ipv6 = ip.split(":");
        if (ipv4.length != 4 && ipv6.length != 8) System.out.println("Neither");
        else if (ipv4.length == 4){
            int flag = 0;
            for (int i = 0; i < 4; i++) {
                if (ipv4[i].startsWith("0")&&ipv4[i].length()>1) {
                    System.out.println("Neither");
                    break;
                }
                try {
                    int temp = Integer.valueOf(ipv4[i]);
                    if (temp >= 0 && temp <= 255) flag++;
                    else {System.out.println("Neither");break;}
                }catch (Exception e) {
                    System.out.println("Neither");break;
                }
            }
            if (flag == 4) System.out.println("IPv4");
            else System.out.println("Neither");//Neither
        }
        else {
            int flag = 0;
            for (int i = 0; i < 8; i++) {
                if (ipv6[i].length()>4) {
                    System.out.println("Neither");break;
                }
                else if (ipv6[i].length()<4){
                    try {
                        int temp = Integer.valueOf(ipv4[i]);
                        if (temp == 0) flag++;
                    }catch (Exception e){
                        System.out.println("Neither");break;
                    }
                }
                else flag++;
            }
            if (flag == 8)System.out.println("IPv6");
            else System.out.println("Neither");
        }
    }

//    public static void main(String[] args) {
//        System.out.println(Integer.valueOf("000"));
//    }
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String ip = sc.nextLine();
//    String[] ipv4 = ip.split("\\.");
//    String[] ipv6 = ip.split(":");
//    if (ipv4.length != 4 && ipv6.length != 8) System.out.println("Neither");
//    else if (ipv4.length == 4){
//        int flag = 0;
//        for (int i = 0; i < 4; i++) {
//            if (ipv4[i].startsWith("0")&&ipv4[i].length()>1) {
//                System.out.println("Neither");
//                break;
//            }
//            try {
//                int temp = Integer.valueOf(ipv4[i]);
//                if (temp >= 0 && temp <= 255) flag++;
//                else {System.out.println("Neither");break;}
//            }catch (Exception e) {
//                System.out.println("Neither");break;
//            }
//        }
//        if (flag == 4) System.out.println("IPv4");
//        else System.out.println("Neither");//Neither
//    }
//    else {
//        int flag = 0;
//        for (int i = 0; i < 8; i++) {
//            if (ipv6[i].length()>4) {
//                System.out.println("Neither");break;
//            }
//            else if (ipv6[i].length()<4){
//                try {
//                    int temp = Integer.valueOf(ipv4[i]);
//                    if (temp == 0) flag++;
//                }catch (Exception e){
//                    System.out.println("Neither");break;
//                }
//            }
//            else flag++;
//        }
//        if (flag == 8)System.out.println("IPv6");
//        else System.out.println("Neither");
//    }
//}
}