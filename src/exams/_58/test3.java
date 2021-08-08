package exams._58;
/*
1 2步 爬楼梯
 */
import java.util.Scanner;
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 1;
        int b = 2;
        int result = 0;
        if (n <= 3) System.out.println(n);
        else {
            while (n > 2){
                n--;
                result = a + b;
                a = b;
                b = result;
            }
            System.out.println(result);
        }
    }
}
