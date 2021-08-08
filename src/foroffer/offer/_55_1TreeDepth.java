package foroffer.offer;
/* 二叉树的深度
 */
public class _55_1TreeDepth {
    private int depth = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        depth+=1;
        return getDepth(root,0);
    }
    private int getDepth(TreeNode root, int depth){
        if (root==null) return 0;
        this.depth += 1;
        System.out.println(this.depth);
        return Math.max(getDepth(root.left,0)+1,
                getDepth(root.right,0)+1);
    }

    // cyc:
    /*
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
     */
    public static void main(String[] args) {
        _55_1TreeDepth d = new _55_1TreeDepth();
        int de = d.TreeDepth(TreeNode.binaryTree());
        System.out.println(de);
    }
}
