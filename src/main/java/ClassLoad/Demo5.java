package ClassLoad;

/**
 * 通过线程上下文类加载器改变默认的双亲委派机制加载
 *
 * 为何要这么做：
 * 1.双亲委派加载存在的问题：
 *      一般情况下，要保证所有一个类所关联的类都是由同一个类加载器加载的。
 *      比如：ClassA本身在ExtClassLoader下找到，那么它里面new出来的一些类只能靠Ext去寻找了（不会低一个级别）
 *      所以有的AppClassLoader虽然能找到，但是却找不到了。最典型的代表就是JDBC，Boot或者Ext寻找sun公司提供的
 *      接口（JDBC API）。但是JDBC的driver实现类是由Ext或者App去加载的。这种接口API+第三方实现类（SPI）的结
 *      构都会出现此问题。
 * 2.根本原因：SPI的接口API是JAVA核心类库的一部分，是由引导类加载器来加载的。而SPI则是由
 *      系统类加载器加载的，引导类加载器是无法找到SPI实现类的，因为它只能加载Java核心类库。
 * 3.通常当你需要动态加载资源的时候，你至少有三个ClassLoader可以选择
 *          1.系统类加载器或者应用类加载器（SystemClassLoader or ApplicationClassLoader）
 *          2.当前类加载器：类名.class.getClassLoader,获得的是一个应用类加载器
 *          3.当前线程类加载器
 * 4.线程类加载器是为了避免双亲委派加载链模式：
 *        每个线程都有一个关联的上下文类加载器，如果你是用new Thread()方式生成新的线程，新线程
 *        将继承其父类线程上下文类加载器。如果程序对线程上下文类加载器没有改动的话，那么所有线程
 *        都将使用系统类加载器作为上下文类加载器。我们可以使用改变线程类加载器的加载方式来避开
 *        双亲委派的加载模式。
 *
 */

import Calender.Test;

/**
 * 避免双亲委派加载模式的使用方式
 */
public class Demo5 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Demo5.class.getClassLoader();
        System.out.println(classLoader);

        //获取当前线程并获取其上下文类加载器
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);

        //将当前线程的上下文类加载器变化Ext类加载器
        Thread.currentThread().setContextClassLoader
                (ClassLoader.getSystemClassLoader().getParent());
        ClassLoader classLoader2 =  Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader2);

        //将当前线程的上下文类加载器变化自定义类加载器
        Thread.currentThread().setContextClassLoader
                (new FileSystemClassLoader("C:/Users/cheng/JavaFilesToTest/target/classes"));
        ClassLoader classLoader3 =  Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader3);
        Class<?> c = classLoader3.loadClass("TestClassLoader.HelloWorld");
        System.out.println(c.getClassLoader());

    }
}
