package foroffer.offer;

/**
 * 剪绳子
 */
public class _14_maxProductAfterCutting {
    // 法1：动态规划：首先从上到下地分析问题，注意到f(n) = max(f(i) * f(n-i))
    // 然后因为从上到下不好求，所以从下到上从0开始依次求
    public int solution1(int length){
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        // n+1是因为把长度为n的绳子剪后乘积的最大值，多了个长度为0
        int[] products = new int[length + 1];
        // 这些的0123是指的在0123做乘数时的最大可能值，之后的循环还会更新这个值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        // 第一层是循环从4开始的绳子长度，对于每个长度都求最大乘积
        for (int i = 0; i <= length; i++){
            max = 0;
            // 这个循环里是为了求f(n) = max(f(i) * f(n-i))
            for (int j = 0; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (max < product){
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    // 法2：贪婪：首先根据算式得出一个结果：如果n>=5，尽量剪长度为3的绳子，剩下长度为4时，剪2*2的长度。
    // 这个结果是因为一个小段的长度增长是线性的，而如果把这一小段再切分，就可以用两小段的乘积得到比一整段长度更大的值
    public int solution2(int length){
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }
        // 这样计算省了if条件判断。timesOf2可能的值有0，1，2
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
