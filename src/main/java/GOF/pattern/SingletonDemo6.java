package GOF.pattern;

import java.io.Serializable;

/**
 * 演示通过反序列化和反射来破解单例模式（除了枚举都可以被破解）
 *
 * 用懒汉式来演示
 */
public class SingletonDemo6 implements Serializable{
    //step1.将该类的属性设置为自己，不进行赋值
    private static SingletonDemo6 instance ;

    //step2.将该类构造器私有化，不允许外部new
    private SingletonDemo6(){

    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static synchronized SingletonDemo6 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo6();
            return instance;
        }
        return instance;
    }

}
