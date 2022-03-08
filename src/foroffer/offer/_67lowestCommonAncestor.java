package foroffer.offer;
/**
 * 树中的最低公共祖先
 */

public class _67lowestCommonAncestor {
    // 如果是二叉查找树：
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    // 方法2： 从根节点开始遍历，依次判断大小，直到找到根节点到p的路径和到q的路径，分别保存起来，然后遍历两个list第一个分叉点就是
    // 方法3：不需要用递归，就是二叉查找树的查找过程，从根节点开始查找，判断节点值大小，然后往下找，直到找到第一个pq值中间值的节点
    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        // p和q不一定谁大谁小
        int max, min;
        if (p.val > q.val){
            max = p.val;
            min = q.val;
        }
        else {
            max = q.val;
            min = p.val;
        }
        while (root != null){
            if (min <= root.val && root.val <= max)
                return root;
            if (root.val < min)
                root = root.right;
            else
                root = root.left;
        }
        return null;
    }
}

/**
 * 根据临界条件，实际上可以发现这道题已经被简化为查找以root为根结点的树上是否有p结点或者q结点，如果有就返回p结点或q结点，否则返回null。
 * 这样一来其实就很简单了，从左右子树分别进行递归，即查找左右子树上是否有p结点或者q结点，就一共有4种情况：
 * 第一种情况：左子树和右子树均找没有p结点或者q结点；（这里特别需要注意，虽然题目上说了p结点和q结点必定都存在，
 *     但是递归的时候必须把所有情况都考虑进去，因为题目给的条件是针对于整棵树，而递归会到局部，不一定都满足整体条件）
 * 第二种情况：左子树上能找到，但是右子树上找不到，此时就应当直接返回左子树的查找结果；
 * 第三种情况：右子树上能找到，但是左子树上找不到，此时就应当直接返回右子树的查找结果；
 * 第四种情况：左右子树上均能找到，说明此时的p结点和q结点分居root结点两侧，此时就应当直接返回root结点了。
 */
class lowest{
    // 普通二叉树：在左右子树中查找是否存在 p 或者 q，
    // 如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件：左右子树中查找p或q，如果p或q在这个树中，则返回这个树的根节点
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // return left == null ? right : right == null ? left : root;
        if (left == null && right == null) return null;  // 都没找到返回null
        if (left != null && right == null) return left;  // 如果只在左边就返回左边
        if (left == null) return right;  // 如果只在右边就返回右边
        return root;  // 如果都不是null则说明左右子树都找到了p或q，则返回根节点作为公共祖先
    }
}
