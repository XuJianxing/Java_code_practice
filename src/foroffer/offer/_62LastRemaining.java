package foroffer.offer;
/* 圆圈中最后剩下的数字
0，1，。。。，n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
求圆圈里剩下的最后一个数字。

法1. 用链表模拟过程
法2. 求得递推公式
 */

import java.util.LinkedList;

public class _62LastRemaining {
    // 模拟法
    public int LastRemaining_Solution_1(int n, int m) {
        if(n < 1 || m < 1) return -1;  // 排除异常
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(i);
        int result_index = 0;
        while (list.size() > 1){
            result_index = (result_index + m - 1) % list.size();
            list.remove(result_index);
        }
        return list.getFirst();
    }
    // cyc:
    //约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。
    //因为是圆圈，所以最后需要对 n 取余。
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
    // offer:
    public int LastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;  // 上面的递归摊成循环了
        return last;
    }
}
