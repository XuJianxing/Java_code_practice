package exams.xiecheng;
/*一行字符串
在这个表达式中括号表示将里面的字符串翻转
如果表达式括号不匹配，输出空字符串 ((ur)oi) -》 iour
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class test2 {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve2(String expr){
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> resultStack = new LinkedList<>();
        for(int i=0; i<expr.length(); i++){
            if(expr.charAt(i) != ')'){
                stack.push(expr.charAt(i));  // 先非）入栈1
            }else{
                while(stack.peek() != '('){
                    resultStack.offer(stack.pop());  // 遇到）则出栈1，入栈2
                }
                stack.pop();
                while(!resultStack.isEmpty()){
                    stack.push(resultStack.poll());  // 再把栈2放回栈1
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pollLast());  // 再按先后顺序存
        }
        for(int i=0; i<stringBuilder.length(); i++){
            if(stringBuilder.charAt(i) == ')' || stringBuilder.charAt(i) == '(')
                return "";
        }

        return stringBuilder.toString();
    }

    /******************************结束写代码******************************/
    public static void main(String[] args) {
        System.out.println(resolve2("((ur)oi)"));
        System.out.println(resolve2("(abc)(def)"));
        System.out.println(resolve2("abc(def(ghi))"));
    }
    /*
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
     */


}
