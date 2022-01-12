package foroffer.offer;

/* 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class _39MoreThanHalfNum_Solution {
    // 投票法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // 用了快排里的partition方法，找第middle位置的数
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length <= 0) return 0;
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = _10_5QuickSort.partition(array, start, end);
        while (index != middle){
            if (index > middle){
                end = index - 1;
            }
            else {
                start = index + 1;
            }
            index = _10_5QuickSort.partition(array, start, end);
        }
        int result = array[middle];  // 要检查一下，下标为middle位置的数是否真的出现超过一半次数。
        /*
        if (!checkMoreThanHalf()) return 0;
         */
        return result;
    }
    // 记录当前数出现的次数
    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array.length <= 0) return 0;
        int result = array[0];
        int times = 1;
        for (int i=1;i<array.length;i++){
            if (times == 0){
                result = array[i];
                times = 1;
            }
            else if (array[i] == result) times++;
            else times--;
        }
        if (!checkMoreThanHalf(array, result)) return 0;
        return result;
    }
    private boolean checkMoreThanHalf(int[] array, int number){
        int times = 0;
        for (int i:array)
            if (i == number)
                times++;
        boolean isMoreThanHalf = true;
        if (times*2 <= array.length)
            isMoreThanHalf = false;
        return isMoreThanHalf;
    }

}
