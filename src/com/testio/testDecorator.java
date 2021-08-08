package com.testio;

/** test 装饰器模式， 4个组成部分：
 * 1. 抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2. 具体组件：需要装饰的对象  （继承了抽象组件）
 * 3. 抽象装饰类：包含了对抽象组件的引用，以及装饰者共有的方法
 * 4. 具体装饰类：被装饰的对象
 */
public class testDecorator {
    public static void main(String[] args) {
        // 测试扩音器：
        Person p = new Person();
        p.say();
        // 装饰扩音器：
        Amplifier am = new Amplifier(p);
        am.say();
        //----------
        Drink coffee = new Coffee();
        Drink sugar = new Sugar(coffee);  // 装饰者要装饰具体组件(coffee)
        System.out.println(sugar.info()+"-->"+sugar.cost());
        Drink milk = new Milk(coffee);  // 用Milk对coffee对象装饰了
        System.out.println(milk.info()+"-->"+milk.cost());
    }
}

// 装饰者模式，模拟咖啡：
// 1. 抽象组件
interface Drink{
    double cost();  // 费用
    String info();  // 说明
}
// 2. 具体组件
class Coffee implements Drink{
    private String name = "原味咖啡";
    public double cost(){
        return 10;
    }
    public String info(){
        return name;
    }
}
// 3. 抽象装饰类
abstract class Decorate implements Drink{
    // 对抽象组件的引用
    private Drink drink;
    public Decorate(Drink drink){
        this.drink = drink;
    }
    public double cost(){
        return this.drink.cost();
    }
    public String info(){
        return this.drink.info();
    }
}
// 4. 具体装饰类1:
class Milk extends Decorate{  // Drink是一个接口，不能extends，而抽象类Decorate应用了Drink
    public Milk(Drink drink){  // 传入Drink是用了泛型
        super(drink);  // ?
    }
    public double cost(){
        return super.cost()+10;
    }
    public String info(){
        return super.info()+"加入了牛奶";
    }
}
// 4. 具体装饰类2:
class Sugar extends Decorate{
    public Sugar(Drink drink){
        super(drink);  // ?
    }
    public double cost(){
        return super.cost()+5;
    }
    public String info(){
        return super.info()+"加入了蔗糖";
    }
}

/*
模拟扩音器对人声音的放大
 */
interface Say{
    void say();
}
class Person{
    private int voice = 10;
    public void say(){
        System.out.println("人的声音是："+this.getVoice());
    }
    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}
class Amplifier implements Say{
    private Person p;
    public Amplifier(Person p){
        this.p = p;  // 构造方法，在构造扩音器对象的时候传入Person类的对象
    }
    public void say(){
        System.out.println("带上扩音器之后的声音是："+p.getVoice()*10);
    }
}
