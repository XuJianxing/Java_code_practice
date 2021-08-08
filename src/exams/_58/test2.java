package exams._58;

/*
[M, N]中 X出现的次数
 */
import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int sum = 0;
        for (int i = M; i <= N; i++) {
            int temp = i;
            while (temp != 0){
                if (temp % 10 == X) sum++;
                temp /= 10;
            }
        }
        System.out.println(sum);
    }
}
