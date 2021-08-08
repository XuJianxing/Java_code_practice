package foroffer.leetcode;

import java.util.Stack;

/** 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class lc206_reverseList {
    /**
     * 1. 递归法
     * @param head
     * @return head
     */
    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList1(head.next);  // 栈退出时记录这层栈空间指向的节点
        head.next.next = head;  // 在栈返回前，在每层栈空间中让下一个节点指向自己
        head.next = null;  // 每层的头部节点指向空
        return p;
    }

    /**
     * 2. 前后指针辅助修改前后节点方向
     */
    public ListNode reverseList2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;  // 先走一步，保存住下一个节点
            curr.next = prev;  // 当前节点指向反转
            prev = curr;  // 更新两个指针
            curr = next;
        }
        return prev;

    }

    /**
     * 用栈
     */
    public ListNode reverseList3(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode p;
        ListNode q;
        // 除了head节点以外都放到栈里，留head是为了在出栈时让链表连下去
        // 但要处理head为空的情况
        if (head == null) return null;
        // 不留head要设一个根节点与第一个出栈的连起来，使得循环出栈操作能够继续
        while (head.next != null){
            stack.push(head);
            head = head.next;
        }
        // p q都是为了修改前后指针，让链表连起来
        p = head;
        while (!stack.empty()){
            q = stack.pop();
            p.next = q;
            q.next = null;
            p = q;
        }
        return head;
    }

    public static void main(String[] args){
        lc206_reverseList l = new lc206_reverseList();
        ListNode ln = new ListNode();
        ln = ln.generate();
        ln.print_nodes(ln);

        ln = l.reverseList2(ln);
        ln.print_nodes(ln);

        ln = l.reverseList3(ln);
        ln.print_nodes(ln);


    }
}
