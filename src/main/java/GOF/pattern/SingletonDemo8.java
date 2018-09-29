package GOF.pattern;

import java.io.Serializable;

/**
 * 通过对构造器重构，来防止反射打破单例模式
 *
 * 通过添加一个私有化方法，防止反序列化打破单例模式
 *
 * 用懒汉式来演示
 */
public class SingletonDemo8 implements Serializable{
    //step1.将该类的属性设置为自己，不进行赋值
    private static SingletonDemo8 instance ;

    //step2.将该类构造器私有化，同时添加逻辑防止反射打破单例模式
    private SingletonDemo8(){
        if (instance!=null) {
            throw new RuntimeException("不能重复构造单例对象");
        }
    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static synchronized SingletonDemo8 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo8();
            return instance;
        }
        return instance;
    }

    //step4.添加readResolve方法，反序列化时，如果已经存在对象，则直接返回此方法指定的对象
    private Object readResolve() {
        return instance;
    }

}
