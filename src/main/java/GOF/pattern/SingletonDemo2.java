package GOF.pattern;

/**
 * 单例模式懒汉式
 *
 * 特点:
 * 1.延迟加载（lazyload，在Spring配置文件中配置bean可以设置延迟加载，在框架注解扫描中也可以通过注解来设置）
 * 提高了资源利用率，在需要的时候创建，而不是类加载就进行创建
 * 2.效率低下，由于实例在需要的时候进行创建，在多线程中会存在线程安全问题，导致创建多个实例打破单例模式
 * 所以静态方法要用同步锁修饰，但是这样影响了并发性能。
 *
 * 与饿汉式比较：
 * 1.当创建一个对象非常消耗资源，可以牺牲一部分并发效率，采用懒汉式创建
 * 2.当对并发效率有显著要求，采用饿汉式
 *
 */
public class SingletonDemo2 {
    //step1.将该类的属性设置为自己，不进行赋值
    private static SingletonDemo2 instance ;

    //step2.将该类构造器私有化，不允许外部new
    private SingletonDemo2(){

    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static synchronized SingletonDemo2 getInstance(){
        if (instance == null) {
            instance = new SingletonDemo2();
            return instance;
        }
        return instance;
    }

}
