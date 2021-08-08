package exams.jingdong;
import java.util.Scanner;
public class didi_test1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String str = in.nextLine();
        System.out.println(str);
        String[] strs = str.split(" ");
        String[] chars = new String[n-1];
        int[] ints = new int[n];
        for (int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
            if ((i&1)==0) ints[i/2] = Integer.valueOf(strs[i]);
            else chars[i/2] = strs[i];
        }

        for (int i=1;i<n-1;i++){
            for (int j=0;j<n-i;j++) {
                if (j==0) {
                    if (chars[j].equals("+") && (chars[j+1].equals("+") || chars[j+1].equals("-")) ||
                            chars[j].equals("*")) {
                        int temp = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = temp;
                    }
                }
                else if (j==n-2){
                    if (chars[j].equals("*")){
                        int temp = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = temp;
                    }
                }
                else {

                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(ints[i]);
            if (i<n-1)System.out.print(chars[i]);
        }
    }
}
