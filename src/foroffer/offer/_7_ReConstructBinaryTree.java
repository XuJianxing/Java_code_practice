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

    /**
     * 没用map存中序每个节点下标的做法
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int preLength = pre.length;
        int inLength = in.length;

        return reConstructCore(pre, in, 0, preLength-1, 0, inLength-1);
    }

    /**
     * 没用map存中序每个节点下标的做法
     */
    public TreeNode reConstructCore(int[] pre, int[] in,
                                           int preStart, int preEnd,
                                           int inStart, int inEnd) {

        int rootValue = pre[preStart]; // 前序遍历的第一个是根节点
        TreeNode r = new TreeNode(rootValue);
        // 在中序遍历中找到他的根节点所在的位置，用它来划分节点簇
        int inRootIdx = inStart;
        while (inRootIdx < inEnd && in[inRootIdx] != rootValue)
            inRootIdx++;

        // 左右子树的长度为
        int leftLength = inRootIdx - inStart;
        int rightLength = inEnd - inRootIdx;
        if(leftLength > 0)
            r.left = reConstructCore(pre, in, preStart+1, preStart+leftLength, inStart, inRootIdx-1);

        if(rightLength > 0)
            r.right = reConstructCore(pre, in, preStart+leftLength+1, preEnd, inRootIdx+1, inEnd);

        return r;

    }
}
