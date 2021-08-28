package foroffer.leetcode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class lc53_maxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 考虑之前连续阶段的子序和对当前数字是否有有益，无益直接舍去
            pre = Math.max(pre + x, x);  // 找到中间阶段的每一个可能的大子序
            maxAns = Math.max(maxAns, pre);  // 记录到目前为止的最大子序和
        }
        return maxAns;
    }

    public int maxSubArray_2(int[] nums) {
        // 先想到的O(n^2)的解法
        // 对数组循环嵌套，求和，外层循环控制子数组长度，内层循环控制子数组求和
        // 第二个想法，从头开始挨个求和，找到最大值所在位置，再从此往前求和，找到最大值位置，两位置所包即子数组
        // 二想法不对，会忽略中间有贡献的数

        // 最优想法：对于整个数组，一段一段的看，只关注求和值>0的一段。
        // 如果求和值出现<=0，则舍弃当前段，从新开始求和。因为已经用max保存了最大值，不需要担心错过已遍历的部分
        // 考虑正数对结果是增益的，
        // 但是！负数不一定是有害的，因为数组全负无法判断！所以遍历的时候，考虑的是sum>0而不是每个i>0
        int sum=0,max=nums[0];  // max要初始化为数组第一个数，而不是自己设的数。因为从第一个开始遍历
        for (int i:nums){
            if(sum>0)
                sum += i;
            else
                sum = i;  // 这里，如果sum<=0了，则说明前段没用了，sum从现在开始重新考虑
            max = Math.max(max, sum);
        }
        return max;
    }
}
