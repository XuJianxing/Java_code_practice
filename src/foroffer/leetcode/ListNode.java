package foroffer.leetcode;

// Definition for singly-linked list.
public class ListNode {
    static int val2;
    int val;
    ListNode next;
    ListNode() {}
    // ListNode(int x) { val = x; }  // 如果不想加this，那么形参必须不重名
    ListNode(int val) { this.val = val; val2 = val; val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode generate(){
        ListNode head = null;
        for (int i = 1; i < 10; i++) {
            ListNode ln = new ListNode(i, head);
            head = ln;
        }
        return head;
    }
    public void print_nodes(ListNode head){
        while (head != null){
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode l = new ListNode();
        System.out.println(l.val);
        System.out.println(ListNode.val2);
        System.out.println(l.val2);

        ListNode n = new ListNode(3);
        System.out.println(n.val);
        System.out.println(ListNode.val2);
        System.out.println(n.val2);

        ListNode m = new ListNode(2, n);
        System.out.println(m.val);
        System.out.println(m.next.val2);
    }
}
