package foroffer.leetcode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 *     你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *     你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class lc25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin = head;  // 判断是否有k个节点的开始节点
        // 判断是否有k个节点
        for (int i = 0; i < k; i++) {
            if (begin == null) return head;
            begin = begin.next;
        }
        // 够的话，栈内k个节点反转，用迭代法反转
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 递归反转从curr开始，因为curr现在是下一组要反转的开头
        ListNode next_tail = reverseKGroup(curr, k);
        // 递归结束后，下一层栈返回的是反转后的头节点，本层head反转后变为尾节点，将本层尾指向下层头
        head.next = next_tail;
        // 返回反转后的头
        return prev;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
