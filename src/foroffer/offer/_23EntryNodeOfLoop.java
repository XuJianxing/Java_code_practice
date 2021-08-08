package foroffer.offer;

import java.util.HashMap;
import java.util.HashSet;
/*
如果一个链表中包含环，如何找出环的入口节点？
 */
public class _23EntryNodeOfLoop {

    static public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            if (fast != null && fast.next != null)
                fast = fast.next.next;
            else
                return null;  // 走的快的直接
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        //c.next = b;
        System.out.println(EntryNodeOfLoop(a).val);
        HashMap<ListNode, Integer> hm = new HashMap<>();
        HashSet<ListNode> hs = new HashSet<>();

        System.out.println(hs.add(a));
        System.out.println(hs.add(a));

        System.out.println(hm.put(a,1));
        System.out.println(hm.put(a, 1));

    }

}
