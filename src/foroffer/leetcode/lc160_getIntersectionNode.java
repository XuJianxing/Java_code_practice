package foroffer.leetcode;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 思路1. 链表1存到hashset里，然后遍历链表2看有没有相同节点
 * 思路2. 双指针，两个指针指向AB头结点，然后分别遍历，其中一个指到尾节点之后，重新指到另一个头结点继续遍历，直到另一个也到尾
 */

public class lc160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
