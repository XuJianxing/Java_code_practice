package com.testio;
import java.io.*;

/* Person类实现Serializable接口后，Person对象才能被序列化 */
class SerializablePerson implements Serializable{
    // 添加序列化ID，它决定着是否能够成功反序列化
    private static final long serialVersionUID = 1L;
    private int age;
    private boolean isMan;
    private String name;
    public SerializablePerson (int age, boolean isMan, String name){
        super();
        this.age = age;
        this.isMan = isMan;
        this.name = name;
    }
    public String toString(){
        return "Person [age = " + age + ", isMan = " + isMan + ", name = " + name + "]";
    }
}
public class TestSerializable {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try{
            // 通过ObjectOutputStream将Person对象的数据写入到文件中，即序列化。
            SerializablePerson person = new SerializablePerson(18, true, "XuJianxing");
            // 序列化
            File f = new File("a/serial/output.txt");
            // 序列化：把对象序列化到文件里存储
            fos = new FileOutputStream(f, true);  // 默认不append
            oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.flush();  // #冲洗 洗净 指清空缓冲区
            // 反序列化
            fis = new FileInputStream(f);
            // 通过ObjectInputStream将文件中二进制数据反序列化成Person对象
            ois = new ObjectInputStream(fis);
            SerializablePerson p = (SerializablePerson) ois.readObject();  // 方法返回的是Object类型，要转型成
            System.out.println(p);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
