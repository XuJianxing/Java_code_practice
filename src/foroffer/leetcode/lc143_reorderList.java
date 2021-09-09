package foroffer.leetcode;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0->L1->L2...->Ln-1->Ln
 * 请将其重新排列后变为：
 * L0->Ln->L1->Ln-1->L2->Ln-2...
 */
public class lc143_reorderList {
    /**
     * 想法1. 先用容器按顺序存好每个节点，然后根据下标检索节点链接到新链表
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     *     这样我们的任务即可划分为三步：
     *     1. 找到原链表的中点
     *     2. 将原链表的右半端反转
     *     3. 将左链表与翻转后的右链表合并。
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        // mid变成尾节点
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 若fast只判断一个next若fast是倒数第二个节点会使得fast再走两次的时候空指针
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode nextTemp;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 先记住next使得链不断
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        // 将l2交叉合并到l1里
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            // 将ln接到l0后面
            l1_tmp = l1.next;
            l1.next = l2;
            l1 = l1_tmp;

            // 将l1接到ln后面
            l2_tmp = l2.next;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
