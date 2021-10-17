package foroffer.offer;

/**
 * 二进制中1的个数
 */
public class _15_numberOf1 {
    // 法1：用数字1开始于num做与，然后一直左移，直到1为0
    int solution1(int num){
        int count = 0;
        int flag = 1;
        while (flag > 0){
            if ((num & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 法2：一个整数减一相当于最右边的1变成0，之后的0变成1.
    // 所以，如果一个整数与自身-1做与，相当于把最后一位1变0.所以只要一直做这个操作直到原数变0
    int solution2(int num){
        int count = 0;
        while (num != 0){
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
