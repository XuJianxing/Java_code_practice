package foroffer.offer;
/*
两个递增排序链表，合并链表并依然有序
 */
public class _25MergeList {
    // 递归
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    // 迭代
    public ListNode Merge2(ListNode list1, ListNode list2) {
        // see leetcode N21e
        return null;
    }
}
