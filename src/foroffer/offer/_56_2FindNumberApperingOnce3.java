package foroffer.offer;
/*
一个数组里只有一个数字只出现一次，其他数字都出现三次。
 */
public class _56_2FindNumberApperingOnce3 {
    int FindNumberApperingOnce(int[] nums){
        if (nums == null || nums.length <= 0)
            return -1;
        int[] bitSum = new int[32];  // 自动初始化为0
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >=0 ; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++i){
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = new int[3];
        int[] a = new int[]{0,1};
        System.out.println(s[2]);
    }
}
