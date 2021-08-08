package exams.xiecheng;
/* 链表排序
给定一个单向链表和一个整数m，将链表中小于等于m的节点移到大于m的节点之前，
要求两部分中的节点各自保持原有的先后顺序

输入数据包含两行，
第一行，整数m
第二行，空格分隔的整数序列
输出：逗号分隔的整数序列
 */
public class test1{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    static ListNode partition(ListNode head,int m) {
        ListNode tmp1 = new ListNode(-1);
        ListNode tmp2 = new ListNode(-1);
        ListNode l = tmp1;
        ListNode r = tmp2;
        ListNode p = head;
        while (p != null) {
            if (p.val <= m) {
                l.next = p;
                l = l.next;
            }
            else {
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        if (tmp1.next == null) {
            return head;
        } else {
            l.next = tmp2.next;
            r.next = null;
            return tmp1.next;
        }
    }
}