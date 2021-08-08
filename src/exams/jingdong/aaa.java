package exams.jingdong;

import java.util.ArrayList;
import java.util.List;

public class aaa {
    public static void main(String[] args){
        Animal animal = new Dog();
        System.out.println(animal.x);
        String s = "";
        System.out.println(s==null);
        int[] arr = new int[]{};
        System.out.println(arr==null);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        //-----
        String s1 = "";
        String s2 = null;
        String s3 = null;
        System.out.println(s1==null);
        System.out.println(s2.equals(s3));
    }

}
class Animal{
    int x=1;
    public Animal(){
        System.out.println("animal");
    }
}
class Dog extends Animal{
    int x=2;
    public Dog(){
        System.out.println("dog");
    }
}

