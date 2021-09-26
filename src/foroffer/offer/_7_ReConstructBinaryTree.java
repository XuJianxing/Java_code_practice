package foroffer.offer;

import java.util.HashMap;

/**
 * 剑指offer 7. 重建二叉树
 * 给二叉树的前序遍历和中序遍历序列，重建该二叉树返回根节点
 */
public class _7_ReConstructBinaryTree {
    private HashMap<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);  // 按节点值作Map的key，下标作value存储
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}
