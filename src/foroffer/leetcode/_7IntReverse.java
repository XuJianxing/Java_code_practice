package foroffer.leetcode;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class _7IntReverse {
    public int reverse(int x) {
        int r=0;
        while(x!=0){
            if (r>Integer.MAX_VALUE/10 || r<Integer.MIN_VALUE/10)
                return 0;
            else{
                r = 10*r+x%10;
                x = x/10;
            }
        }
        return r;
    }
}
