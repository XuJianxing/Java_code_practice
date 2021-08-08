package foroffer.offer;
/*
输入两棵二叉树A，B，判断B是不是A的子结构。
（ps：我们约定空树不是任意一个树的子结构）
 */
public class _26HasSubtree {
    public boolean HasSubtree (TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root2 != null && root1 != null){  // 先判断root2非空再走。这样相当于root2空直接返回false
            if (root1.val == root2.val)
                result = DoesTree1HaveTree2(root1, root2);
            if (!result)
                result = HasSubtree(root1.left, root2);
            if (!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        // 递归时要先判断递归结束条件，然后再在return里设定递归进行的过程
        if (root2 == null) return true;  // 在到达结尾以后要及时返回true，不能先判断root1
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) &&
                DoesTree1HaveTree2(root1.right, root2.right);
    }
    //cyc:
    public boolean _HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        // 也就是先根结点判断，否则往左走，否则往右走。找到一条路即可。但是不知是否多走了
        return isSubtreeWithRoot(root1, root2) ||
                _HasSubtree(root1.left, root2) ||
                _HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
