package foroffer.offer;
/*  数据流中的中位数
用最大堆最小堆的方式实现：
 */
import java.util.PriorityQueue;

public class _41MiddleInDataflow {
    // 用优先队列当作堆（因为优先队列就是依据堆实现的）  左边用最大堆存
    private PriorityQueue<Integer> left_max = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> right_min = new PriorityQueue<>();  // 默认就是最小堆
    private int N = 0;  // 是为了记录这是第几个数。奇数or偶数
    public void Insert(Integer num) {
        if ((N&1)==0){
            // n为偶数时，当前数要插入右边的比左边数都大的最小堆。但是实际这个数不一定比左边都大。
            // 所以操作统一起来，都是先插左边再把左边最大值插右边
            left_max.add(num);
            right_min.add(left_max.poll());
        }
        else {  //同样考虑这个问题。操作也是统一起来。
            right_min.add(num);
            left_max.add(right_min.poll());
        }
        N++;
    }
    /*
    public Double GetMedian() {
        if ((N&1)==0 && left_max.size() > 0 && right_min.size() > 0)
            return (left_max.peek() + right_min.peek()) / 2.0;
        else if ((N&1)!=0 && right_min.size() > 0)
            return (double)right_min.peek();
        else
            return 0.0;
    }
    */
    public Double GetMedian(){
        if (N%2==0) return (left_max.peek() + right_min.peek()) / 2.0;
        else return (double)right_min.peek();
    }
}
