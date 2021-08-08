package com.commonclass;

// 当需要定义一组常量时，使用枚举类型

public class TestEnum {
    private enum Season{ WINTER, SPRING, SUMMER, AUTUMN}
    public static void main(String[] args){
        System.out.println(Season.valueOf("WINTER"));
        System.out.println(Season.values()[1]);

        for (Week k:Week.values())
            System.out.println(k);
    }
    public enum Week {Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday}
}
