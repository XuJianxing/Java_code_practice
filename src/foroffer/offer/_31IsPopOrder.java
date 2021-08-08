package foroffer.offer;
/*
输入两个整数序列，第一个序列表示栈的压入序列，判断第二个序列是否是该序列的弹出序列。
 */
import java.util.Stack;

public class _31IsPopOrder {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
