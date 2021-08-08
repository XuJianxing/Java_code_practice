package exams.wangyihuyu;

import java.util.*;

public class ShushiNums1 {
    static int[] result = new int[10];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        ArrayList<ArrayList<Integer>> num_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strs = scanner.nextLine().split(" ");
            String a = strs[0];
            String b = strs[1];
            int[] res=new int[10];
            HashMap<Character, Integer> cal_num = cal_nums(a, b);
            Set<Character> keys = cal_num.keySet();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (char key : keys)
                res[key - '0'] += cal_num.get(key);
            for(int j=1;j<res.length;j++) {
                tmp.add(res[j]);
                result[j] += res[j];
            }
            num_list.add(tmp);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < num_list.get(i).size(); j++)
                System.out.print(num_list.get(i).get(j)+"");
            System.out.println();
        }
        int output = 1;
        int count = result[1];
        for(int j=2;j<result.length;j++) {
            if(count < result[j]) {
                count = result[j];
                output = j;
            }
        }
        System.out.println(output);
    }
    private static HashMap<Character,Integer> cal_nums(String a,String b) {
        HashMap<Character,Integer> hashmap = new HashMap<>();
        count_nums(a, hashmap);
        count_nums(b, hashmap);
        int res = Integer.valueOf(a) * Integer.valueOf(b);
        int i = 0;
        while(i<b.length()) {
            int  num2=b.charAt(i++)-'0';
            int tmp = Integer.valueOf(a)*num2;
            count_nums(String.valueOf(tmp), hashmap);
        }
        count_nums(String.valueOf(res), hashmap);
        return hashmap;
    }
    private static void count_nums(String a, HashMap<Character,Integer> hashmap) {
        for(int i=0;i<a.length();i++) {
            char k = a.charAt(i);
            if(k != '0') {
                if(hashmap.containsKey(k))
                    hashmap.put(k, hashmap.get(k)+1);
                else
                    hashmap.put(k, 1);
            }
        }
    }
}