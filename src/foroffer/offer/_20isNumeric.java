package foroffer.offer;

/**
 * 正则表达式
 * []  ： 字符集合
 * ()  ： 分组
 * ?   ： 重复 0 ~ 1 次
 * +   ： 重复 1 ~ n 次
 * *   ： 重复 0 ~ n 次
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 */
public class _20isNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
