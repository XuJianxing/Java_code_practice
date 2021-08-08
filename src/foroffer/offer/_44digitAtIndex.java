package foroffer.offer;
/*  数字序列中的某一位数字
数字以012345678910111213141516…的格式序列化到一个字符串中，求这个字符串的第index位。
比如第1001位数字是什么？1位数一共占序列10位位置，2位数占序列2*90位置，3位数占序列3*900位置，
所以1001位属于3位数的位置
 */
public class _44digitAtIndex {
    public int digitAtIndex(int index){
        if (index < 0) return -1;
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);  // 1位数有多少个
            if (index < numbers * digits)  // 如果在这个范围里，直接digitAtIndex()找
                return digitAtIndex(index, digits);
            // 1001-10, 991-180, 811%3==1,811/3==270，所以是3位数里100开始的第270个数的第下标1位。
            index -= digits * numbers;  // 不在的话，digits位数一共占多少位置，减去这些位置
            digits++;  // 找了一次以后，位数+1
        }
        // return -1;  // unreachable statement
    }
    // m位的数字总共有多少个
    private int countOfIntegers(int digits){
        if (digits == 1) return 10;
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;  // 算的仅是digits这个位数的占位置的长度，不包含前面的长度
    }
    // 当知道要找的那一位数字位于某m位数之中后，就可以用如下函数找出那一位数字
    private int digitAtIndex(int index, int digits){  // 因为传入的index是已经减去前位数长度的了
        int number = beginNumber(digits) + index / digits;  // 所以直接找这个位数长度的位置就可
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        return number % 10;  // 要找的是第index位的数字，所以定位到这个数之后找相应位置的数字
    }
    // 找到第一个m位数
    private int beginNumber(int digits){
        if (digits == 1) return 0;
        return (int)Math.pow(10, digits - 1);
    }
}
