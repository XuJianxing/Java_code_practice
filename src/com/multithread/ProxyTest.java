package com.multithread;

/**
 * 静态代理模式
 * 1. 真实角色
 * 2. 代理角色
 * 实现同一个接口，才能实现代理行为
 * （装饰器模式改变了原方法：对被装饰对象的方法改变了：代理模式没改变原方法）
 */
public class ProxyTest {
    public static void main(String[] args) {
        new WeddingCompany(new You()).marry();
        // new Thread(某线程对象).start();
    }
}

interface Marry{
    void marry();
}
class You implements Marry{
    // 这是真实角色
    @Override
    public void marry() {
        System.out.println("You happyMarry");
    }
}

// 代理角色
class WeddingCompany implements Marry{
    // 内部有个真实角色
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        before();
        this.target.marry();
        after();
    }

    private void before(){
        System.out.println("WeddingCompany before");
    }
    private void after(){
        System.out.println("WeddingCompany after");
    }
}