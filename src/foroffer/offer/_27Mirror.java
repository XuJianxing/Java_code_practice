package foroffer.offer;
/*
返回二叉树的镜像
 */
public class _27Mirror {
    public void Mirror(TreeNode root){
        if (root == null) return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    private void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
