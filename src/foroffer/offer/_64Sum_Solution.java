package foroffer.offer;
//求1+2+。。。+n不用乘除循环条件判断
public class _64Sum_Solution {
    static public int Sum_Solution(int n){
        int sum = n;
        boolean b = (n>0) && ((sum += Sum_Solution(n-1))  > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }
}
