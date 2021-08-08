package exams.aiqiyi;
/*
首先给出一个长度为k=2^n（其中n为正整数）的序列A={a1，a2…a_{k-1},ak}，
我们定义一个值v，这个值是由如下计算方法得到的，
首先将A序列的第 i 位和第 i+1 位进行 OR 操作得到新数列A‘，
然后再对A’序列操作，将A’ 序列的第 i 位和第 i+1 位进行 XOR 操作得到A‘’，
对A‘’按照第一次操作方式进行OR操作，因为序列长度为2^n,所以显然进行n次操作之后就只剩下一个数字了，
此时这个数字就是v。

例如A={1，2，3，4}，第一次操作之后为{1|2=3，3|4=7}，第二次操作后，{3^7=4},所以v=4。

但是显然事情并没有那么简单，给出A序列后，还有m个操作，每个操作表示为“a b”，
表示将A[a]改为b，之后再对A序列求v值。（注意每一次对序列的修改的永久的，
即第i次修改是建立在前i-1次修改之上的）
 */
import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int length = (int)Math.pow(2,n);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            array[a] = b;
            System.out.println(calculate(array, n));
        }
    }
    private static int calculate(int[] array, int n){
        for (int i = 0; i < n; i++) {
            int lag = (int)Math.pow(2,i);
            for (int j = 0; j < n; j++) {
                array[j] = array[j] | array[j-1];
                array[j] = array[j] ^ array[j-1];
            }
        }
        return array[0];
    }
}
