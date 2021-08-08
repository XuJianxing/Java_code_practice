package foroffer.offer;
/*
请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class _28isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return _isSymmetrical(pRoot, pRoot);  // 要先从根节点本身开始。有可能根节点是null
    }
    private boolean _isSymmetrical(TreeNode p1, TreeNode p2){
        if (p1 == null && p2 == null) return true;
        if (p1 == null || p2 == null) return false;
        if (p1.val != p2.val) return false;
        // 这个return的写法很关键！
        return _isSymmetrical(p1.left, p2.right) && _isSymmetrical(p1.right, p2.left);
    }
}
