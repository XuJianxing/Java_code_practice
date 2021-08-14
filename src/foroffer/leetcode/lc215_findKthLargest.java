package foroffer.leetcode;

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

    /**
     * 思路：用最大堆的排序过程
     */
    public int findKthLargest(int[] nums, int k) {
        int temp;
        // 构建最大堆结构，从最后一个非叶节点开始向下调整堆结构，且要从后向前处理
        for (int i = nums.length / 2; i >= 0; i--){
            shiftDown(nums, i, nums.length - 1);
        }
        // 进行堆排序的前k-1次之后，堆顶部就是第k最大
        for (int i = 0; i < k - 1; i++){
            temp = nums[0];
            nums[0] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
            shiftDown(nums, 0, nums.length - 2 - i);
        }
        return nums[0];
    }

    /**
     * 堆的向下调整过程，也就是 shift down，假设之前已经满足堆结构了，现在调整这个节点使保持堆结构
     * @param nums  传入的数组，可以是堆结构也可以不是
     * @param index  待处理的节点的索引
     * @param range_i  在这个范围内向下调整使这一部分满足堆结构
     */
    public void shiftDown(int[] nums, int index, int range_i){
        int left_son = index * 2 + 1;
        if (left_son > range_i) return;
        int right_son = left_son + 1;
        // 1. 找出最大值所在的index
        int max_i = left_son;
        if (right_son <= range_i && nums[right_son] > nums[left_son])
            max_i = right_son;
        // 2. 如果不满足堆结构，交换使之满足
        if(nums[index] < nums[max_i]){
            int temp = nums[index];
            nums[index] = nums[max_i];
            nums[max_i] = temp;
            // 3. 并继续向下调整
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
