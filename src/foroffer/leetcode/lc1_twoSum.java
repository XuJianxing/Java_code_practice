package foroffer.leetcode;
/**
 * 1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
并返回他们的数组下标。
 */

public class lc1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=1;
        for (i=0;i<nums.length;i++){
            int num = nums[i];
            for(j=i+1;j<nums.length;j++){
                if(num+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
