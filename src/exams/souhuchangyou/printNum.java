package exams.souhuchangyou;

class printStuff{//打印数据的类
    public int num = 1;
    public char cha='A';
    public boolean flag = true;//flag作为打印线程等待的标志
}

class printChar extends Thread {//实现打印字符的线程类
    private printStuff c;
    public printChar(printStuff a){
        this.c = a;}
    @Override
    public void run(){
        while(c.cha<='Z'){
            synchronized(c){
                if(!c.flag){
                    System.out.print(c.cha + " ");
                    c.cha++;
                    c.flag = true;
                    c.notify();
                }
                else {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class printNum extends Thread {//实现打印数字的线程类
    private printStuff num;
    public printNum (printStuff n){
        this.num = n;
    }
    @Override
    public void run(){
        while(num.num<=52){
            synchronized(num){
                if(num.flag){
                    System.out.print(num.num);
                    num.num++;
                    System.out.print(num.num);
                    num.num++;
                    num.flag = false;
                    num.notify();
                }
                else
                    try{
                        num.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
            }
        }
    }
    public static void main(String[] args){
        printStuff ps = new printStuff();
        printNum t1=new printNum(ps);
        printChar t2=new printChar(ps);
        t1.start();
        t2.start();
    }
}
