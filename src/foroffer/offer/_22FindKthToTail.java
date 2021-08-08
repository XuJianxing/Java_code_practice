package foroffer.offer;
/*
输出链表倒数第k个节点，如果k=0、头结点是空、长度小于k，则返回null。
 */
public class _22FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = 0;
        ListNode end = head;
        ListNode result = head;
        while(end != null){
            end = end.next;
            if(count<k){
                count++;
            }
            else
                result = result.next;
        }
        if (count<k) return null;
        return result;
    }
}
