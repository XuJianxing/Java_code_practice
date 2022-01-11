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
        next.next = head;  // 把递归栈上一层的next指针指到这一层的head节点
        return newHead;  // 这个时候返回的newHead永远都是第一次递归返回的head节点不再变了
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

    // 1. 迭代反转链表，
    // 每次把当前now节点连接指向前一个节点prev，nextTemp缓存now原先指向的下一个节点，
    // 然后前一个节点prev变成现在的节点now、now变成下一个节点nextTemp以便继续迭代
    // null -> 1 -> 2        -> 3        -> 4 -> null
    //    p <- n -> nextTemp -> 3        -> 4 -> null
    // null <- p <- n        -> nextTemp -> 4 -> null
    private ListNode reverseList (ListNode head) {
        ListNode prev = null;  // 记录每次迭代时，剩下链表的头结点。
        ListNode now = head;  // 记录当前要做反转操作 指向的节点
        while (now != null){  // 记住下一个节点；把当前节点的指针往前指；往后滑动两个指针参数
            ListNode nextTemp = now.next;  // 当前节点下一个节点，用来传给prev，以使迭代进行下去，保证链不断
            now.next = prev;               // 后来的这个节点链到前面，使链表反转
            prev = now;                    // 前一个节点prev变成现在的节点now以便继续迭代
            now = nextTemp;                // now变成下一个节点nextTemp以便继续迭代
        }
        return prev;  // 返回的是prev，因为遍历到最后，now指null，prev指针改向之前的now了
    }

    // 2. 递归反转链表
    // 先判断递归结束条件，然后依次放入栈中，出栈的时候
    static private ListNode reverseList2 (ListNode head){
        // 第一个是判断链表非空，第二个是使尾节点先出栈，
        // 尾节点return出栈后，直接跳过后面代码不操作了，直接判断下一个节点了。因为第一个出栈的没法改指针，没有有用信息next
        if (head == null || head.next == null) return head;
        ListNode node = reverseList2(head.next);  // 传next使每次递归都在继续走

        // 第二个出栈（正数倒数第二个）节点的next指向最先出栈的节点，最先出栈的下一个节点本来是null，现在改成倒数第二个节点
        // 这是利用了反转之前，head.next指向顺序的后一个。把后一个的next改成指向当前，就反转指针了
        head.next.next = head;  // 有头节点的话，head是null，无头节点的话，它把前一个指向自己

        head.next = null;  // 设为null是为了使最后一个出栈节点的next为null，本来上句话就改了next的节点
        return node;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        _24ReverseList l = new _24ReverseList();
        l.ReverseList(a);
    }
}
