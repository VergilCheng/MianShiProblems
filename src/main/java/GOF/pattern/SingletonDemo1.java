package GOF.pattern;

/**
 * 单例模式：饿汉式
 *
 * 特点：
 * 1.线程安全：因为饿汉式类的创建是在类加载过程中进行的，而类加载过程<cInit>是线程安全的
 * 所以饿汉式是线程安全的。
 * 2.返回Instacnce方法没有同步，调用效率高。
 * 3.由于在类加载过程中立即初始化，所以没有延时加载的优势。
 *
 */
public class SingletonDemo1 {
    //step1.将该类的属性设置为自己，并赋值一个对象,属性是static，保证
    //只有一份，而且这个对象在JVM类加载初始化的过程中就进行创建了。不管
    //以后会不会使用，但是他就一直存在。所以后面有了延时加载，来避免
    //在类初始化的过程中就进行加载。
    private static SingletonDemo1 instance = new SingletonDemo1();



    //step2.将该类构造器私有化，不允许外部new
    private SingletonDemo1(){

    }
    //step3.构造一个静态方法，用来返回对象(因为不能通过new来创建实例，所以只能通过类方法来创建)
    public static SingletonDemo1 getInstance(){
        return instance;
    }


}
