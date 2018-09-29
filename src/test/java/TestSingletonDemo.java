import GOF.pattern.*;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonDemo {

    /**
     * 测试GoF.pattern中的单例模式
     *
     * 单例模式设计的类中，该类对象只会调用一次构造方法，返回值返回对象引用
     * 从而保障了对象是单例的。
     *
     * 目前来看静态内部类方式是不错的方式
     */
    @Test
    public void test1() {

        //测试饿汉式
        SingletonDemo1 singletonDemo1 = SingletonDemo1.getInstance();
        SingletonDemo1 singletonDemo11 = SingletonDemo1.getInstance();
        System.out.println(singletonDemo1==singletonDemo11);
        //测试懒汉式
        SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();
        SingletonDemo2 singletonDemo21 = SingletonDemo2.getInstance();
        System.out.println(singletonDemo2==singletonDemo21);
        //测试静态内部列

        //测试枚举
        SingletonDemo5 singletonDemo5 = SingletonDemo5.Instace;
        SingletonDemo5 singletonDemo51 = SingletonDemo5.Instace;
        System.out.println(singletonDemo5==singletonDemo51);

    }
    /**
     * 测试反射破解单例模式
     */
    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
        //不通过反射返回单例
        SingletonDemo6 singletonDemo6 = SingletonDemo6.getInstance();
        SingletonDemo6 singletonDemo61 = SingletonDemo6.getInstance();
        System.out.println(singletonDemo6==singletonDemo61);
        //通过反射破解单例模式
        ClassLoader classLoader = TestSingletonDemo.class.getClassLoader();
        Class<SingletonDemo6> c = (Class<SingletonDemo6>) classLoader.loadClass("GOF.pattern.SingletonDemo6");
        Class<SingletonDemo6> c1 = (Class<SingletonDemo6>) Class.forName("GOF.pattern.SingletonDemo6");
        System.out.println("通过反射获得类对象与通过系统类加载器获得类对象是否相同"+(c==c1));
        Constructor<SingletonDemo6> constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        //通过Constructor类来实例化对象
        SingletonDemo6 singletonDemo611 = constructor.newInstance();
        SingletonDemo6 singletonDemo612 = constructor.newInstance();
        System.out.println(singletonDemo611==singletonDemo612);

    }

    /**
     * 测试SingletonDemo7对构造器添加逻辑判断，防止反射打破单例模式封装
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<SingletonDemo7> c = (Class<SingletonDemo7>) Class.forName("GOF.pattern.SingletonDemo7");
        Constructor<SingletonDemo7> constructor = c.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingletonDemo7 singletonDemo7 = constructor.newInstance();
        SingletonDemo7 singletonDemo71 = constructor.newInstance();
        System.out.println(singletonDemo7==singletonDemo71);
    }
    /**
     * 测试反序列化破解单例模式
     */
    @Test
    public void test4() throws IOException, ClassNotFoundException {
        //通过反序列化来打破单例模式

        //step1.先将对象序列化写出到文件a.txt中
        SingletonDemo6 singletonDemo6 = SingletonDemo6.getInstance();
        FileOutputStream fos =  new FileOutputStream("C:/testFileAndIO/a.txt");
        ObjectOutputStream obs = new ObjectOutputStream(fos);
        obs.writeObject(singletonDemo6);
        obs.close();
        fos.close();

        //step2.将a.txt文件反序列化读取为Object
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("C:/testFileAndIO/a.txt"));
        SingletonDemo6 singletonDemo61 = (SingletonDemo6) ois.readObject();
        System.out.println(singletonDemo6==singletonDemo61);


    }
    /**
     * 测试防止反序列话打破单例模式是否成功
     */
    @Test
    public void test5() throws IOException, ClassNotFoundException {
        //通过反序列化来打破单例模式

        //step1.先将对象序列化写出到文件a.txt中
        SingletonDemo8 singletonDemo8 = SingletonDemo8.getInstance();
        FileOutputStream fos =  new FileOutputStream("C:/testFileAndIO/a.txt");
        ObjectOutputStream obs = new ObjectOutputStream(fos);
        obs.writeObject(singletonDemo8);
        obs.close();
        fos.close();

        //step2.将a.txt文件反序列化读取为Object
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("C:/testFileAndIO/a.txt"));
        SingletonDemo8 singletonDemo81 = (SingletonDemo8) ois.readObject();
        System.out.println(singletonDemo8==singletonDemo81);

    }


}
