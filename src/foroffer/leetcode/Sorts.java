package foroffer.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorts {

    public int[] asd;
    public Sorts(){}
    public Sorts(int[] asd){
        this.asd = asd;
    }

    private static void swap_in_list(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] to_sort = new int[]{9,8,1,2,7,6,4,5,3};
        bubbleSort(to_sort);
        System.out.println(Arrays.toString(to_sort));

        to_sort = new int[]{9,8,1,2,7,6,4,5,3};
        quickSort(to_sort, 0, to_sort.length - 1);
        System.out.println(Arrays.toString(to_sort));
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 优先队列
        swap_in_list(to_sort, 0, 1);
        System.out.println(Arrays.toString(to_sort));

    }

    public static void bubbleSort(int[] nums){
        /* 冒泡排序 */
        int temp;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] nums, int left, int right){
        /* 快排 */
        if(left < right){
            // x为锚点；i j是游标，循环结束的条件
            int i = left, j = right, x = nums[i];
            // 这个循环操作的目标是找到锚点值应该在的位置
            while (i < j){
                // 从右向左找到第一个小于x的数
                while (i < j && nums[j] >= x)  // 这里有等号，是为了如果有重复值，可以让循环结束，且结束后i==j
                    j--;
                // 将小于x的数放到x该在的位置的前面，位置i就可以
                if (i < j){
                    nums[i] = nums[j];  //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                    i++;
                }
                // 从左向右找到第一个大于x的数
                while (i < j && nums[i] < x)
                    i++;
                // 将大于x的数放到x该在的位置的后面，位置j就可以
                if (i < j){
                    nums[j] = nums[i];
                    j--;
                }
            }
            // 这时候i==j，而且x还没归位到该在的位置，将其归位
            nums[i] = x;
            // 之后再递归左右两边
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void heapSort(int[] nums){
        /* 堆排序
        * 步骤：
        * 对数组创建堆结构：大根堆：用于升序排序；小根堆：降序排序
        * 堆首和堆尾互换，堆尺寸缩小1
        * 调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
        * 重复以上两步
        * */
        // 1. 建堆，只需要从第一个非叶子节点开始就行。从底向上走
        int beginIndex = (nums.length - 2) / 2;
        for (int i = beginIndex; i >= 0; i--) {
            shiftDown(nums, i, nums.length);
        }
        // 2. 从尾到头堆排序
        for (int i = nums.length; i >= 0; i--) {
            swap_in_list(nums, 0, i);  // 交换堆顶与未排序的最后一位
            shiftDown(nums, 0, i - 1);  //重新建堆
        }

    }

    /**
     * 堆的调整，使改变堆顶之后最大堆重新成为最大堆
     * 传入参数len是为了控制只排前len个长度，不改变后面的，为了能够适应堆排序需要
     */
    private static void shiftDown(int[] arr, int index, int range_i){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if(li > range_i) return;       // 左子节点索引超出计算范围，直接返回。不判断右子是因为可能不含有右子
        if(ri <= range_i && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if(arr[cMax] > arr[index]){
            swap_in_list(arr, cMax, index);      // 如果父节点被子节点调换，
            // ----以上都是在交换最大值节点到父节点----
            // 如果则需要继续判断换下后的父节点是否符合堆的特性。
            // 哪里改变值了哪里继续改下去
            shiftDown(arr, cMax, range_i);
        }
    }


}
