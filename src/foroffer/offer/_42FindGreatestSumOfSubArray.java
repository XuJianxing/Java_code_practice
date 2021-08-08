package foroffer.offer;
/* 连续子数组的最大和

 */
public class _42FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length <= 0) return 0;
        int sum = 0;
        int max = array[0];
        for (int i:array){
            sum = sum >= 0 ? sum + i : i;
            max = Math.max(sum, max);
        }
        return max;
    }
}
