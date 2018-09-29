package GOF.pattern;

/**
 * 通过对构造器重构，来防止反射打破单例模式
 *
 * 用懒汉式来演示
 */
public class SingletonDemo7 {
    //step1.将该类的属性设置为自己，不进行赋值
    private static SingletonDemo7 instance ;

    //step2.将该类构造器私有化，同时加逻辑判断，不能重复创建对象
    private SingletonDemo7(){
        if (instance!=null) {
            throw new RuntimeException("不能重复构造单例对象");
        }
    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static synchronized SingletonDemo7 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo7();
            return instance;
        }
        return instance;
    }

}
