package foroffer.leetcode;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。>
 */
public class lc41_firstMissingPositive {
    /**
     * 方法1：原地哈希
     * 对于数组nums，我们只关心数的范围在[1, N]之间的数，因为如果都出现过，则返回N+1，如果有一个没出现，只能在这范围内
     * 用<负数>来标记已经出现过的数x对应于数组的下标x-1，之后再遍历一次找到第一个不是负数的位置的下标值+1就是第一个缺失的正数
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
    /**
     * 方法2：置换每个数字将他们放到该在的位置
     * 找到第一个不正确的位置（注意换的时候可能会死循环，注意跳出）
     */
    public int firstMissingPositive_2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 要注意不是只换一次，循环换到不满足条件为止
            // 如果它在1-n范围里，且不循环等，就必须换它放到该在的位置
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
