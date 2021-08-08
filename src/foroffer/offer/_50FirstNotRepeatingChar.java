package foroffer.offer;

import java.util.BitSet;

public class _50FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];  // 简易hash表
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
    public int FirstNotRepeatingChar_2(String str) {
        // 可以用两个bit存储是否出现了，出现1次，或更多次
        // 因为首先要出现一次，然后要判断仅一次还是多次，一次的是满足条件的，多次的是不满足的
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()){
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);
            else if ((bs1.get(c) && !bs2.get(c)))
                bs2.set(c);
        }
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
