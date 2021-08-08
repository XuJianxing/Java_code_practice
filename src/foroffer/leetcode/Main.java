import java.lang.Enum;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
class FreshJuice {
//    enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
    FreshJuiceSize size;
}

public class Main {
    public static void main(String[] args){
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuiceSize.MEDIUM;
        System.out.println(FreshJuiceSize.MEDIUM.ordinal()==0);
        // int l = args.length;
        // int m = args[0].length();
        // Set<Character> occ = new HashSet<>();

    }

}
