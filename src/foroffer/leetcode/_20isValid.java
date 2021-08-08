package foroffer.leetcode;
/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

 */
public class _20isValid {
    public boolean isValid(String s) {
        int l = s.length();
        int index = 0;
        if(l%2!=0)
            return false;
        char[] ch = new char[l];
        for (int i=0;i<l;i++){
            char t = s.charAt(i);
            if(t=='(' | t=='[' | t=='{'){
                ch[index] = t;
                index++;
            }else if(t==')' | t==']' | t=='}'){
                if (index==0)
                    return false;
                if ((ch[index-1]=='(' & t==')') | (ch[index-1]=='[' & t==']') | ch[index-1]=='{' & t=='}')
                    index -= 1;
            }
        }
        return index==0;
    }
}
