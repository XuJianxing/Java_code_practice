package foroffer.offer;
/*  1~n整数中1出现的次数
输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 */
public class _43NumberOf1Between1AndN_Solution {
    // cyc:
    public int NumberOf1Between1AndN_Solution(int n){
        int count = 0;
        for (int i = 1;i <= n;i *= 10){
            int a = n / i;
            int b = n % i;
            count += (a+8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }
    // leetcode:
    public int NumberOf1Between1AndN_Solution_2(int n){
        int count = 0;
        for (int i = 1; i <= n; i *= 10){
             int divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
            // 这样会有错，因为除的时候会舍弃小数
            // count += (n / 10) + Math.min(Math.max(n % (i * 10) - i + 1, 0), i);
        }
        return count;
    }
    public static void main(String[] args){
        int n = 2356;
        int i = 10;
        System.out.println(n/(i*10)*i);
        System.out.println(n/10);
    }
}
