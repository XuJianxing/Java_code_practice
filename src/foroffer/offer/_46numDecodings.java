package foroffer.offer;
/*  数字翻译成字符串
一个数字，0翻译成'a'，1翻译成'b'...25翻译成'z'。一个数字有多种翻译方法。
请计算一个数字有多少种翻译方法
 */
public class _46numDecodings {
    public int numDecodings(int num){
        String s = Integer.toString(num);
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return 1;
        return _numDecodings(s, 0);
    }
    private int _numDecodings(String s, int i){
        if (i>=s.length()-1) return 1;
        return _numDecodings(s,i+1) + judge(s, i) * _numDecodings(s,i+2);
    }
    private int judge(String s, int i){
        if (Integer.valueOf(s.substring(i, i+2)) > 9 && Integer.valueOf(s.substring(i, i+2)) < 26)
            return 1;
        else return 0;
    }

    // dp
    public int numDecoder(int num){
        String s = Integer.toString(num);
        int n = s.length();
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[n-1] = 1;
        if (num % 100 >= 10 && num % 100 <= 25) dp[n-2] = 2;
        else dp[n-2] = 1;
        for (int i=n-3;i>=0;i--){
            int temp = Integer.valueOf(s.substring(i,i+2));
            if (temp >= 10 && temp <= 25) dp[i] = dp[i+1] + dp[i+2];
            else dp[i] = dp[i+1];
        }
        System.out.println(dp[0]);
        return dp[0];
    }
    public static void main(String[] args){
        _46numDecodings sdf = new _46numDecodings();
        System.out.println(sdf.numDecodings(12258));
        sdf.numDecoder(12258);
    }

}
