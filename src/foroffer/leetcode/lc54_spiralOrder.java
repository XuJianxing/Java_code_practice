package foroffer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class lc54_spiralOrder {
    /**
     * 对于每层，从左上方开始以顺时针的顺序遍历所有元素。假设当前层的左上角位于 (top,left)，右下角位于(bottom,right)，
     * 按照如下顺序遍历当前层的元素。
     * 遍历完当前层的元素之后，将 left 和 top 分别增加 1，将 right 和 bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        // 循环终止条件
        while (left <= right && top <= bottom) {
            // 遍历从左到右
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            // 遍历从右上到右下
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            // 如果下左还有内容
            if (left < right && top < bottom) {
                // 遍历下
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                // 遍历左
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
