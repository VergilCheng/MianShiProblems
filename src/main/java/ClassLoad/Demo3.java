package ClassLoad;

/**
 * 自定义类加载器测试
 */
public class Demo3 {

    public static void main(String[] args) throws ClassNotFoundException {

        String rootDir = "C:/Users/cheng/JavaFilesToTest/target/classes";

        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader(rootDir);
        FileSystemClassLoader loader = new FileSystemClassLoader(rootDir);
        Class<?> c = fileSystemClassLoader.loadClass("TestClassLoader.HelloWorld");
        Class<?> c1 = fileSystemClassLoader.loadClass("TestClassLoader.HelloWorld");

        Class<?> c2 = loader.loadClass("TestClassLoader.HelloWorld");
        Class<?> c3 = loader.loadClass("Reflect.Foo");

        Class<?> c4 = fileSystemClassLoader.loadClass("Reflect.Foo");
        Class<?> c5 = fileSystemClassLoader.loadClass("java.lang.String");
        System.out.println(c.getClassLoader()+"\t"+c1.getClassLoader()+"\t"+c2.getClassLoader()+
                "\t"+c3.getClassLoader()+"\t"+c4.getClassLoader()+"\t"+c5.getClassLoader());
        System.out.println(c.getName());

        System.out.println(c.hashCode());
        System.out.println(c1.hashCode());

        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());
        /**
         *  jvm认为同一个classloader加载同一个.class文件生成的Class对象是同一个对象，
         *  不同类加载加载同一类，也是生成不同的.class对象。
         *
         *  AppClassloader(应用类加载器)：加载同一个项目下自定义的类。
         *  我们发现,在此项目下调用自定义类加载器加载此项目下的类，那么自定义加载器会交给
         *  AppClassLoader来加载我们定义的类。所以c3和c5是同一个类加载器加载的，c3和c5相同。
         *
         *  自定义类加载器（继承系统类加载器）:可以加载不同项目下的类。
         *  但是我们如果在此项目下调用自定义类加载器加载别的项目中的类，那么自定义加载器交给
         *  AppClassLoader加载，但是它不能加载，因为他不能加载别的项目中的类，所以只能自定义
         *  类加载器自己去加载，由于我们构造了两个类加载器，一个loader一个fileSystemClassLoader
         *  所以他们加载同一份Class文件生成两个不同的Class对象
         *
         *  BootClassLoader：加载java核心类库
         *  c5的类加载器是bootClassLoader，由于是内核语言写出来的，所以java获取不到，返回null
         *
         */

    }

}
