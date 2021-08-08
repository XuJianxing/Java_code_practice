package foroffer.offer;
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
import java.util.ArrayList;

public class _29printMatrix {
    static public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while (left<=right&&top<=bottom){
            for (int j=left;j<=right;j++)
                arr.add(matrix[top][j]);
            top++;
            for (int i=top;i<=bottom;i++)
                arr.add(matrix[i][right]);
            right--;
            if (top<=bottom)  // 注意不要重复添加
                for (int i=right;i>=left;i--)
                    arr.add(matrix[bottom][i]);
            bottom--;
            if (left<=right)  // 注意不要重复添加
                for (int j=bottom;j>=top;j--)
                    arr.add(matrix[j][left]);
            left++;
        }
        return arr;
    }
    public static void main(String[] args){
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{1},{2},{3},{4},{5}};
        int[][] matrix = {{1,2,3,4,5}};
        System.out.println(printMatrix(matrix));
    }
}
