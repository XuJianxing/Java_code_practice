package foroffer.offer;

import java.util.Arrays;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _21ReorderArray {
    // 题目要求保证相对位置不变，所以前后指针的方法不宜
    // 新建一个同长度数组，保存传进来的array，然后按新建的数组改array
    static public void reOrderArray(int [] array) {
        int[] temparray = new int[array.length];
        int index = 0;
        System.arraycopy(array, 0, temparray, 0, array.length);
        for (int i=0;i<array.length;i++)
            if ((temparray[i] & 1) != 0){
                array[index] = temparray[i];
                index++;
            }
        for (int i=0;i<array.length;i++)
            if ((temparray[i] & 1) == 0){
                array[index] = temparray[i];
                index++;
            }
    }
    // 冒泡交换，但是只有前偶后奇的时候才能交换!!!
    static public void reOrderArray1(int[] array) {
        for (int i = 0; i < array.length;i++)
            for (int j = array.length - 1; j>i;j--)  // 每次都把所有偶数往后移一位，所以j>i可以少判断几次
                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //前偶后奇交换
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
        }
    }
    // 这种交换也会打乱顺序，{1,2,3,4,5}会换成{1,3,5,4,2}因为最后2和5换了
    static public void reOrderArray2(int [] array) {
        if (array.length < 2) return;
        int p=0, q=0;  //两个指针各指向"第一个偶数后面的第一个奇数"和第一个偶数
        while (p < array.length){
            while (q < array.length && (array[q] & 1) != 0){  // 用while找到第一个偶数
                q++;
            }
            p=q+1;  // 从q后面开始找
            while (p < array.length && (array[p] & 1) == 0){  // 找到q后面的第一个奇数
                p++;
            }
            if (p < array.length){
                int temp = array[p];
                array[p] = array[q];
                array[q] = temp;
            }
        }
    }
    // 前后指针方法，在前后指针相遇之前，分别找到偶数和奇数，并交换
    static public void reOrderArray3 (int[] array){
        int p=0, q=array.length-1;
        while (p < q){
            while (p < q && (array[p] & 1) != 0)  // 如果是奇数才会继续找的意思
                // 如果当前是偶数，且在pq范围内，才会+1。因此p和q的判断就可以限制循环一定结束。
                p++;
            while (q > p && (array[q] & 1) ==0)  // 判断 p < q 的条件可以使循环更快结束
                q--;
            if (p < q) {
                int temp = array[p];
                array[p] = array[q];
                array[q] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {2,2,2,2,4};
        int[] c = {1,3,5,7,9};
        int[] d = {2,3,4,5,6};
        reOrderArray1(d);
        System.out.println(Arrays.toString(d));
    }
}
