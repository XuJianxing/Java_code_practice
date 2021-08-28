package foroffer.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class lc21_mergeTwoLists {

    /**
     * 递归法：递归到链表终结点，返回时依次链接上（或者正向思路：假设后面节点有序，则将后面节点链接到前面的节点）
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法：注意要设置头结点和当前游标指针、注意循环结束后没有完全合并完，要再手动合一次
     * 设头结点是为了代码简洁，这样可以直接进入循环，而不用先手动分别判断一次
     * 循环判断两节点非空时，链到当前节点后面，最后再把剩余链表连上
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
