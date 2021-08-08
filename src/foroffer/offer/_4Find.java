package foroffer.offer;
/* 二维数组中的查找
给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 */
public class _4Find {
    /*
    二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
    所以从右上角开始找，就可以每次找去除一行或一列
     */
    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
