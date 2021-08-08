package exams.jingdong;

import java.util.stream.Stream;
import java.lang.Exception;
public class a {
    public static int x = 0;
    public static int re(){
        int i=10;
        try {
            i=i/0;  // no.1
            System.out.println("i=i/0;"+i);
            return i--;
        }catch (Exception e){
            i--;  // no.2
            //return (i--);
            System.out.println("catch i--"+i);
            return i--;  // no.3 返回了i，之后执行了i--
        }finally {
            i--;  // no.4
            System.out.println("finnaly i--"+i);
            return i--;  // no.5 返回了i，i--虽然做了操作但是没影响了
        }
    }
    public static void main(String[] args){
        System.out.println(re());
        // System.out.println(x);
        Stream.of("jd","jd.com","www.jd.com","www.jd.id")
                .mapToDouble(String::length)
                .filter(len -> len >3)
                .peek(System.out::println)
                .limit(2);
    }
}
