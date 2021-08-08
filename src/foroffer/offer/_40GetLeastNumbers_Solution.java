package foroffer.offer;
/*  最小的K个数
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _40GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        // 使用partition函数
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) return ret;
        findKthSmallest(input, k - 1);
        // findKthSmallest 会改变数组，使前k个数都是最小的k个数
        for (int i=0;i<k;i++)
            ret.add(input[i]);
        return ret;
    }
    private void findKthSmallest(int[] nums, int k){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int j = _10_5QuickSort.partition(nums, l, h);
            if (j == k) break;
            if (j > k) h = j - 1;
            else l = j + 1;
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        // 使用大小为k的最大堆
        if (k > input.length || k <= 0) return new ArrayList<>();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){ //大顶堆，容量11
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        for (int num:input){
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();  // 获取并移除此队列的头
        }
        return new ArrayList<>(maxHeap);
    }
    public static void main(String[] args){
        MathOperation test = (o1, o2) -> o1+o2;
    }
}
interface MathOperation {
    int operation(int a, int b);
}
