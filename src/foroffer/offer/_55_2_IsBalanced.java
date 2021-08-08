package foroffer.offer;
/*
是不是平衡二叉树
 */
public class _55_2_IsBalanced {
    private boolean isBalanced = true;
    private int height(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        // 后续遍历二叉树
        int left = height(root.left);
        int right = height(root.right);  // 叶节点高度记为0
        if (Math.abs(left - right) > 1)  // 根据左右子节点的深度判断该节点是不是平衡的
            isBalanced = false;
        return 1 + Math.max(left, right);  // 往上走要记录子树高度+1
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

}
