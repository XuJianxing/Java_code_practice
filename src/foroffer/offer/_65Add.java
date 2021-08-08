package foroffer.offer;
// 不用加减乘除做加法
public class _65Add {
    public int Add(int num1, int num2){
        int sum, carry;
        do {
            sum = num1 ^ num2;  // 不进位加
            carry = (num1 & num2) << 1;  // 一次进位
            num1 = sum;  // 模拟两个结果相加的过程，也就是继续这个循环
            num2 = carry;
        }while (num2 != 0);  // 直到没有进位
        return num1;
    }
}
