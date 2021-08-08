package foroffer.offer;

import java.util.Random;


public class _10_5QuickSort {
    public static void main(String[] args){
        int[] data = {1,2,3};
    }

    // 一趟快排
    static int partition(int[] data, int start, int end) {
        if (data.length<=0) return 0;
        Random r = new Random();
        int index = r.nextInt(end-start)+start;  // 随机找初始index标的数
        // 将最后一个和标的位置交换
        // 为什么和最后交换：为了循环的时候从开头遍历比大小
        swap(data, index, end);

        int small = start - 1;  // 记录标的数最后的位置 下标
        for (index = start;index < end; ++index){
            if (data[index] < data[end]){  // 因为交换过，所以现在data[end]是标的数
                ++small;  // 每有一个数小于标的，则说明比它小的数+1，也就是记录了标的数的位置
                // 为什么要判断small!=index：因为small记录了小于标的数的个数
                if (small != index)
                    // 让index和small交换是保证小于标的的数都放到左边
                    //index记录了遍历当前位置，和small交换可以把小的数放前面，但是小的数没顺序
                    swap(data, index, small);
            }
        }
        ++small;  // 最后再+1是指出标的数最后的放置位置
        swap(data, small, end);
        return small;
    }

    void quicksort(int[] data, int start, int end){
        if (start != end){
            int index = partition(data, start, end);  // 走一趟快排, 找到中间坐标
            if (index > start)
                quicksort(data, start, index-1);  // 左边继续快排
            if (index < end)
                quicksort(data, index+1, end);  // 右边继续快排
        }
    }

    static void swap(int[] data, int a, int b){
        int temp;
        temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
