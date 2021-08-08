package foroffer.offer;
/* 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class _51InversePairs {
    // 归并排序中统计个数
    public int InversePairs(int [] array) {
        //List<Integer> all = Collections.synchronizedList(al);
        if (array == null || array.length <= 0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++)
            copy[i] = array[i];
        // 转型时，(int)优先级较高，应该把后面的所有括起来
        int count = (int)(InversePairsCore(array, copy, 0, array.length-1)%1000000007);
        return count;
    }
    private long InversePairsCore(int[] array, int[] copy, int start, int end){
        if (start == end){
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        // 这里传进去的array是有序的copy数组。上一次的无序的array数组变成了需要被重新赋值的copy数组
        long left = InversePairsCore(copy, array, start, start + length);
        long right = InversePairsCore(copy, array, start+length+1, end);
        // i初始化为前半段最后一个数字的下标
        int i = start + length;
        // j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;  // 从后往前copy到copy数组里
        long count = 0;  // int可以往上转型long
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {  // 是逆序对，所以大数copy到copy里，并计算count
                copy[indexCopy--] = array[i--];
                count += j - start - length;
            } else
                copy[indexCopy--] = array[j--];
        }  // while里是合并的过程，也就是按序赋值到copy数组里，这样copy数组就有序了
        // 然后把剩下的放进去
        for (;i >= start; --i)
            copy[indexCopy--] = array[i];
        for (;j >= start + length +1; --j)
            copy[indexCopy--] = array[j];
        return left + right + count;
    }

    public static void main(String[] args) {
        String s = new String("asdasd");
        System.out.println(s.contains("as"));
        System.out.print(s.indexOf("da"));
    }
    // cyc方法:
    private long cnt = 0;
    private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

    public int InversePairs_cyc(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1;  // nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }
}
