package foroffer.offer;

import java.util.LinkedList;
import java.util.Queue;

/*
字符流中第一个不重复的字符
 */
public class _50_2FirstAppearingOnce {
    private int[] cnts = new int[256];
    private LinkedList<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        if (cnts[ch] == 0) queue.add(ch);  // 出现过就不加了
        cnts[ch]++;
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)  // 所以判断的时候要判断是不是
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
    public static void main(String[] args) {

    }
}
