package foroffer.offer;
/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
层次遍历二叉树
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class _32_1PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> save = new ArrayList<>();
        save.add(root);
        int i=0;
        while (i<save.size()){
            if (save.get(i)==null){
                i++;
                continue;
            }
            result.add(save.get(i).val);
            save.add(save.get(i).left);
            save.add(save.get(i).right);
            i++;
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> save = new ArrayList<>();
        System.out.println(save.add(null));
        System.out.println(save.size());
    }


}
