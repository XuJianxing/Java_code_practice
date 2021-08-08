package com.xjx1;

public class LearnStatic2 {
    int id;        //id
    String name;   //账户名
    String pwd;   //密码
    static String company; //公司名称
    static {
        System.out.println("执行类的初始化工作");
        company = "北京尚学堂";
        printCompany();
        System.out.println("static");
    }
    public LearnStatic2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void printCompany(){
        System.out.println(company);
    }
    public void testParameterTransfer01(LearnStatic2  ls2){
        ls2.company="高小八";
    }
    public void testParameterTransfer02(LearnStatic2  ls2){
        ls2 = new LearnStatic2(200,"高三");
    }

    public static void main(String[] args) {
//        com.xjx1.LearnStatic2  ls2 = new com.xjx1.LearnStatic2();
        LearnStatic2  ls2 = new LearnStatic2(100, "高");
        ls2.testParameterTransfer01(ls2);
        System.out.println(ls2.name);

        ls2.testParameterTransfer02(ls2);
        System.out.println(ls2.name);
    }
}
