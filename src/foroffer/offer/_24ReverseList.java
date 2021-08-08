package foroffer.offer;
/*
输入链表头结点，反转该链表并输出反转后链表的头结点。
 */
public class _24ReverseList {
    // 递归
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;  // 递归终止条件。最后返回时的newHead就被赋值为最尾的head了
        ListNode next = head.next;
        head.next = null;         // 把第一个和所有的节点的next置为null。
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }
    // 迭代
    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;  // 要先记住它的下一个，才能处理它
            head.next = newList.next;   // 把它放到头结点的next的前面
            newList.next = head;        // 把它链到头结点后面
            head = next;                // 继续这个处理
        }
        return newList.next;
    }
}
