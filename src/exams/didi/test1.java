package exams.didi;
import java.io.*;
import java.util.*;
/*
最近很多城市都搞起了垃圾分类，已知有一个小区有n堆垃圾需要丢弃，这些垃圾都打包了，我们并不知道这是什么垃圾，要知道有些垃圾如果丢在一起是会影响环境的。这个小区一共只有两辆垃圾车，出于合理负载的考量，要求两辆车必须装载相同数量的垃圾。我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾。
我们为垃圾袋标了号，分别是1-n，有m个约束，每个约束表示为“a b”，意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。（每堆垃圾最多有两个约束条件）
请问两辆垃圾车一次最多可以带走多少堆垃圾呢？
 */
import java.util.Scanner;

public class test1 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int m = scanner.nextInt();
        int[][] not = new int[m][2];
        for (int i = 0; i < m; i++) {
            not[i][0] = scanner.nextInt();
            not[i][1] = scanner.nextInt();
        }
        System.out.println(n);
    }
}