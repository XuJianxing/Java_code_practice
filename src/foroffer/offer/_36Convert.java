package foroffer.offer;
/*二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _36Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }
    private TreeNode pre = null;
    private TreeNode head = null;
    private void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);  // 中序遍历二叉搜索树
        node.left = pre;
        if (pre != null)  pre.right = node;  // pre是双向链表的前一个节点，判断非空是考虑左边界
        pre = node;
        if (head == null)  head = node;  // 为空才赋值，这是让head赋值为中序遍历的第一个节点，只赋值一次
        inOrder(node.right);  // 继续中序遍历（左中右，在到左的最深处时开始转链表）
    }

}
