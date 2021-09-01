package foroffer.leetcode;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class lc31_nextPermutation {
    /**
     * 也就是n个数的排列问题，两个数之间的区别就是两个位置的交换问题
     * 所以做法也就是找到两个满足条件的数的位置并交换
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 只考虑长度大于1
        // 且从后向前查找第一个相邻升序的位置i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后向前找第一个满足A[i] < A[j]的数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换两个数
            swap(nums, i, j);
        }
        // 因为i和i+1是第一个升序对，所以i+1到end肯定是降序，把后面的升序使得满足增量最小
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
