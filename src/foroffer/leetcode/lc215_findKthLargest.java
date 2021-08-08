import java.util.Arrays;

/** 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class lc215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int temp;
        for (int i = nums.length / 2; i >= 0; i--){
            shiftDown(nums, i, nums.length - 1);
        }
        for (int i = 0; i < k - 1; i++){
            temp = nums[0];
            nums[0] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
            shiftDown(nums, 0, nums.length - 2 - i);
        }
        return nums[0];
    }

    public void shiftDown(int[] nums, int index, int range_i){
        int left_son = index * 2 + 1;
        if (left_son > range_i) return;
        int right_son = left_son + 1;
        int max_i = left_son;
        if (right_son <= range_i && nums[right_son] > nums[left_son])
            max_i = right_son;
        if(nums[index] < nums[max_i]){
            int temp = nums[index];
            nums[index] = nums[max_i];
            nums[max_i] = temp;
            shiftDown(nums, max_i, range_i);
        }
    }

    public static void main(String[] args){
        lc215_findKthLargest lc = new lc215_findKthLargest();
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(lc.findKthLargest(arr, 2));
        arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(lc.findKthLargest(arr, 4));
        arr = new int[]{2,1};
        System.out.println(lc.findKthLargest(arr, 2));
    }
}
