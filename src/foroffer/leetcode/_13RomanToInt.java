package foroffer.leetcode;

public class _13RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I'){
                result += 1;
            }else if(s.charAt(i) == 'V'){
                result += 5;
            }else if(s.charAt(i) == 'X'){
                result += 10;
            }else if(s.charAt(i) == 'L'){
                result += 50;
            }else if(s.charAt(i) == 'C'){
                result += 100;
            }else if(s.charAt(i) == 'D'){
                result += 500;
            }else if(s.charAt(i) == 'M'){
                result += 1000;
            }
        }

        //处理成对数
        if(s.indexOf("IV") >= 0){
            result -= 2;
        }
        if(s.contains("IX")){
            result -= 2;
        }
        if(s.indexOf("XL") >= 0){
            result -= 20;
        }
        if(s.indexOf("XC") >= 0){
            result -= 20;
        }
        if(s.indexOf("CD") >= 0){
            result -= 200;
        }
        if(s.indexOf("CM") >= 0){
            result -= 200;
        }
        return result;
    }
}
