package exams.kuaishou;
/*数字按键的字母组合
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test2 {
    private static ArrayList<String> output = new ArrayList<>();
    private static HashMap<String, String> dicts = new HashMap<>();

    private static void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        }
        else {
            String digit = next_digits.substring(0, 1);
            String letters = dicts.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = dicts.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        dicts.put("2", "abc");
        dicts.put("3", "def");
        dicts.put("4", "ghi");
        dicts.put("5", "jkl");
        dicts.put("6", "mno");
        dicts.put("7", "pqrs");
        dicts.put("8", "tuv");
        dicts.put("9", "wxyz");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        if (number.length() != 0)
            backtrack("", number);
        System.out.println(output);
    }
}
