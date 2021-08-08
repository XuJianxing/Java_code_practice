package exams.xiaohongshu;
/*
给一个迷宫，有开始点有结束点，而且迷宫可以出界循环走。
 */
import java.util.ArrayList;
import java.util.Scanner;

public class test32 {
    static ArrayList<Integer> ret = new ArrayList<>();

    public static void pathcount(String[] path){
        int N = path.length;
        int M = path[0].length();
        String[][] arr = new String[N][M];
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                arr[i][j] = String.valueOf(path[i].charAt(j));
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(arr[i][j].equals("S")){
                    dfs(arr, new boolean[N][M], i, j, N, M,0);
                    if(ret.size() == 0){
                        System.out.println(-1);
                        return;
                    } else{
                        int min = Integer.MAX_VALUE;
                        for(int k=0; k<ret.size(); k++)
                            min = Math.min(min, ret.get(k));
                        System.out.println(min);
                        return;
                    }
                }
    }

    public static void dfs(String[][] migong, boolean[][] mark, int i, int j, int row, int col, int path){
        if(j == col) j = 0;
        if(i == row) i = 0;
        if(i == -1) i = 0;
        if(j == -1) j = 0;

        if(migong[i][j].equals("E")){
            ret.add(path);
            return;
        }
        if(migong[i][j].equals("#") || mark[i][j])
            return;
        mark[i][j] = true;
        dfs(migong, mark, i+1, j, row, col, path+1);
        dfs(migong, mark, i-1, j, row, col, path+1);
        dfs(migong, mark, i, j+1, row, col, path+1);
        dfs(migong, mark, i, j-1, row, col, path+1);
        mark[i][j] = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] path = new String[N];
        for(int i=0; i<N; i++)
            path[i] = scanner.next();
        pathcount(path);
    }
}
