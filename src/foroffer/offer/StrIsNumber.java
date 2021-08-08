package foroffer.offer;
/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class StrIsNumber {
    static public boolean isNumeric(char[] str) {
        boolean e = false;
        int floatcount = 0;
        int pluscount = 0;
        for (int i=0;i<str.length;i++){
            if (i==0 && (str[i] == '.' || str[i] == 'e' || str[i] == 'E')) return false;
            if (str[i] != 'e' & str[i] !='E' & str[i] !='.' & str[i] != '+' & str[i] != '-'
                    & !(str[i]>='0' && str[i]<='9'))
                return false;
            if (str[i] == '.') floatcount++;
            else if (i!=0 &(str[i] == '+' || str[i] == '-')) pluscount++;
            else if (str[i] == 'e' || str[i] == 'E'){
                if (e) return false;
                else {
                    floatcount=1;
                    pluscount=-1;
                    e=true;
                }
            }
            if (floatcount>1 || pluscount>0) return false;
            if ((i==str.length-1) && (str[i] == 'e' || str[i] == 'E' || str[i] == '+' || str[i] == '-'))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        char[] str = "123.45e5+6".toCharArray();  // 代码有点问题，会漏这种情况认为是true
        System.out.println(isNumeric(str));
    }
}
