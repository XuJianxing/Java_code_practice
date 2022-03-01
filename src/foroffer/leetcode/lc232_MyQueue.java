package foroffer.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class lc232_MyQueue {
    Stack<Integer> stack_a;
    Stack<Integer> stack_b;

    public lc232_MyQueue() {
        this.stack_a = new Stack<>();
        this.stack_b = new Stack<>();
    }

    public void push(int x) {
        this.stack_a.push(x);
    }

    public int pop() {
        if (this.stack_b.empty()){
            if (this.stack_a.empty())
                return -1;
            while (!this.stack_a.empty())
                this.stack_b.push(this.stack_a.pop());
        }
        return this.stack_b.pop();
    }

    public int peek() {
        if (this.stack_b.empty()){
            if (this.stack_a.empty())
                return -1;
            while (!this.stack_a.empty())
                this.stack_b.push(this.stack_a.pop());
        }
        return this.stack_b.peek();
    }

    public boolean empty() {
        return this.stack_a.empty() && this.stack_b.empty();
    }
}
