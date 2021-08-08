package foroffer.offer;
/*
12. 矩阵中的路径
判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
每一步可以在矩阵中向上下左右移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class _12HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

}
// 没写完的自己想的代码。按str顺序挨个查找，没找到i--, 找到了i++，用i控制循环条件
    /*
    public boolean hashPath(char[] matrix, int rows, int cols, char[] str){
        int[] str_index = new int[matrix.length];  // 标记找过的内容
        for (int t:str_index) t=0;
        int i = 0, matrix_index = 0;
        while (i < str.length){
            matrix_index = find(matrix, str_index, str[i], i, cols, matrix_index);
            if (matrix_index != -1){
                str_index[matrix_index] = 1;
                i++;
            }
            else i--;
            if (i<0) break;
        }
        return i < 0;
    }
    // 矩阵，标记数组，要找的char，要找第几个字符，列数，当前出发位置
    // 返回-1说明没找到，否则找到了
    private int find(char[] matrix, int[] str_index, char tofind, int num, int cols, int pos){
        if (num == 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] == tofind) return i;
            }
            return -1;
        }
        else{
            if (pos+cols>=matrix.length){
                if ()
            }
            return -1;
        }
    }
    */