package GOF.pattern;

/**
 * 静态内部类实现方式（也是一种懒加载方式）
 *
 * 特点：
 * 1.在加载SingletonDemo4的时候并不会对SingletonClassIntance进行
 * 初始化，保证了资源的有效利用，实现了延迟加载。
 * 2.只有在调用getInstance方法后才会对内部类进行加载和内部类属性初始化，而类初始化过程
 * 是线程安全的，所以静态内部类实现方式是一个不错的实现方式。
 * 3.instace是static final的，保证了内存中只会有一份实例存在并只能赋值一次，从而保证了线程的安全性。
 * 4.方法没有加锁，调用效率高。
 */
public class SingletonDemo4 {

    private static class SingletonClassInstance{
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    public static SingletonDemo4 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonDemo4(){

    }

}
