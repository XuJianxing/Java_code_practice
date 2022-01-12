package foroffer.offer;
/*  二叉树中和为某一值的路径
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */
import java.util.ArrayList;

public class _34FindPath {
    private ArrayList<ArrayList<Integer>> resultPath = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return resultPath;
        findPath(root, target, new ArrayList<>());
        return resultPath;
    }
    private void findPath(TreeNode root, int target, ArrayList<Integer> path){
        if (root == null) return;
        target -= root.val;
        path.add(root.val);
        // 如果是叶节点，且和等于target
        if (0 == target && root.left == null && root.right == null)
            resultPath.add(new ArrayList<>(path)); // 很关键，把新建的path放进去。现在的path是用来判断的
        if (root.left != null)
            findPath(root.left, target, path);
        if (root.right != null)
            findPath(root.right, target, path);
        path.remove(path.size()-1);
    }
}
