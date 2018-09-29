package ClassLoad;
import java.lang.String;
/**
 * 类加载过程中，加载过程的细致探讨
 * 测试ClassLoader
 */
public class Demo2 {
    public static void main(String[] args) {
        //获取系统类加载器/应用程序类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
        //获取系统类加载器的父类扩展类加载器——ExtClassLoader
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //扩展类加载器的父类，引导类加载器/启动类加载器(BootClassLoader)，是用源生代码实现的，所以java获取不到,输出null
        //一般用来加载java的核心类库
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        //目前程序的classpath是什么
        System.out.println(System.getProperty("java.class.path"));
        /**
         * 类加载器代理模式
         *
         * 1.代理模式：交给其他类加载器加载指定类，由自定义类加载器——应用程序类加载器——
         *             扩展类加载器——启动类加载器的顺序依次传递到启动类加载器来加载指定类。
         * 2.双亲委托机制（java默认委托机制）：
         *              代理模式一种，就是某个特定的类加载器在接收到加载类的请求时，
         *              首先将加载任务委托给父类加载器，依次追溯，直到最高的父类，如果父类能够
         *              成功完成类加载任务，就成功返回Class对象。如果父类加载器无法完成加载任务，
         *              才返回给子类加载器去加载。
         * 3.双亲委托机制是为了保证java核心类库的安全：
         *              假设我们用户自己定义了一个java.lang.String类，那么按照上述代理模式和双亲
         *              委派模式的加载，那么最终由启动类加载器来加载这个类，这时候启动类加载器发现
         *              自己的rt.jar包中存在这个String类，所以会加载java核心类库的String而不会加载
         *              我们自己定义的同名String。
         * 4.类加载除了用于类加载，还是安全的最基本保障！
         * 5.双亲委托机制是代理模式的一种：
         *              并不是所有的类加载器都采用双亲委托机制，tomcat服务器的类加载器也是使用
         *              代理模式，不过不同的是它在加载类的过程中会先让子类加载，如果子类加载不到
         *              则再代理给父类加载，这与一般的类加载的顺序是相反的。
         *
         */

    }
}
