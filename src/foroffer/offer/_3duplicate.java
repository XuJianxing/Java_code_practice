package foroffer.offer;

import java.util.Arrays;

/* 数组中重复的数字
在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class _3duplicate {
    /*
    要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
    对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {  // 万一这个位置满足了条件，交换到了正确位置，还要继续往后找
            // 如果不等就一直交换，直到交换到当前位置的值==当前值为下标的值
            while (nums[i] != i) {  // 这个 while+交换 的操作就相当于把每个遇到的数都换到 数值==下标 的位置
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 2, 5};
        int[] duplication = new int[6];
        _3duplicate dp = new _3duplicate();
        dp.duplicate(nums,6,duplication);
        System.out.println(Arrays.toString(duplication));
    }
}
