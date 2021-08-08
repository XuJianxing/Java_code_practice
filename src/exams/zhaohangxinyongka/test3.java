package exams.zhaohangxinyongka;
/*
字符串0-9,？组成一个数字。?可以是0-9，允许有前导0
求数字模13余数为5的个数。
 */
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        long result = 0L;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i)=='?') count++;
        int num;
        int[] counts = new int[count];
        for (int i = count-1; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                counts[i] = j;
                num = 0;
                int index=0;
                for (int k = 0; k < s.length(); k++) {
                    num *= 10;
                    if (s.charAt(k) == '?')
                        num += counts[index++];
                    else num += s.charAt(k);
                }
                System.out.println(num);
                if (num % 13 == 5) result++;
            }
            counts[i] += 1;
        }
        System.out.println(result%(1000000007));
    }
}
/*
s="???"
_MO = pow(10,9)+7
result = [0 for _ in range(13)]
for i in range(len(s)):
if i == 0:
if s[i] == '?':
for j in range(10):
result[j] = 1
else:
result[int(s[i])] = 1
else:
temp = [0 for _ in range(13)]
bias = pow(10,i)%13
if s[i] == '?':
for j in range(10):
for k in range(13):
temp[(k+j*bias)%13] += result[k]
else:
j = int(s[i])
for k in range(13):
temp[(k+j*bias)%13] += result[k]
result = [temp[i]%_MO for i in range(13)]
 */

