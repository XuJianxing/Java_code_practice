package foroffer.offer;
/*
数字在排序数组中出现的次数
 */
public class _53GetNumberOfK {
    // cyc: 二分查找第一个k和第一个k+1
    public int GetNumberOfK_cyc(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
    // 或者二分查找第一个k和最后一个k：
    public int GetNumberOfK(int[] nums, int K){
        int count = 0;
        if (nums != null && nums.length > 0){
            int first = GetFirstK(nums, K, 0, nums.length-1);
            int last = GetLastK(nums, K, 0, nums.length-1);
            if (first > -1 && last > -1)
                count = last - first + 1;
        }
        return count;
    }
    private int GetFirstK(int[] data, int K, int start, int end){
        if (start > end) return -1;
        int middleIndex = (start+end)/2;
        int middleData = data[middleIndex];
        if (middleData == K){  // 如果找到K了，还要判断是不是第一个K
            if ((middleIndex > 0 && data[middleIndex-1] != K)
                    || middleIndex == 0)
                return middleIndex;  // 找到了返回，没找到继续
            else
                end = middleIndex - 1;
        }
        else if (middleData > K)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;
        return GetFirstK(data, K, start, end);
    }
    private int GetLastK(int[] data, int K, int start, int end){
        if (start > end) return -1;
        int middleIndex = (start+end)/2;
        int middleData = data[middleIndex];
        if (middleData == K){  // 如果找到K了，还要判断是不是 last K
            if ((middleIndex < data.length-1 && data[middleIndex+1] != K)
                    || middleIndex == data.length-1)
                return middleIndex;  // 找到了返回，没找到继续
            else start = middleIndex + 1;
        }
        else if (middleData > K)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;
        return GetLastK(data, K, start, end);
    }
}
