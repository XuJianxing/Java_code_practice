package foroffer.offer;
// 输入一个整数数组，判断该数组是不是某二叉搜索树

public class _33VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) return false;
        return verify(sequence, 0, sequence.length-1);
    }
    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;  // 切分的位置。表示遍历到比根节点大的第一个位置
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;
        for (int i = cutIndex; i < last; i++)  // 如果后面有比根节点小的值，则false；
            if (sequence[i] < rootVal)
                return false;
            // 否则递归判断前后子树是否正确（控制前后指针）
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}
