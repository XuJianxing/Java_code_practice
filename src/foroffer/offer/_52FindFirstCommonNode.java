package foroffer.offer;
/* 两个链表的第一个公共结点
输入两个链表，找出它们的第一个公共结点。
 */
public class _52FindFirstCommonNode {
    // a+c+b == b+c+a
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        // 不用担心无公共节点的情况，因为l1和l2会同时走到变为null
        while (l1 != l2) {
            // 当前节点是空？说明到链表末尾了，那就遍历另一个链表，否则继续遍历。直到相同
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

}
