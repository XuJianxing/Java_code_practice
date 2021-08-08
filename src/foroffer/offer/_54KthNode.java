package foroffer.offer;
/*
二叉搜索树的第k个结点
 */
public class _54KthNode {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k){
            ret = root;
            return;  // 提前终止
        }
        inOrder(root.right, k);
    }
}
