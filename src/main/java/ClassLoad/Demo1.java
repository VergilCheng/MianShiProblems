package ClassLoad;

/**
 * Java类加载的过程细节：
 *  1.加载：将class字节码文件加载到内存中，并将这些静态数据转换成方法区中的运行时数据结构，在堆中生成一个
 *  该类的Class对象，作为方法区数据（如static变量）的访问入口，这个过程类加载器介入
 *  2.链接：将Java类的二进制代码合并到JVM运行状态之中的过程
 *      验证：确保加载的类信息符合JVM规范，没有安全方面的问题。
 *      准备：正式为类变量（static变量）分配内存并设置类变量的初始值阶段，这些内存都在方法区中进行分配，
 *            并赋默认值
 *      解析：虚拟机常量池的符号引用转变为直接引用
 *  3.初始化：
 *      1.初始化阶段是执行类构造器<cInit>()方法的过程。类构造器方法是由编译器自动收集类中的所有类（static）
 *      变量的赋值动作（所以编译器在编译的过程中一旦发现字符串字面量或者字面量相加的形式，就会告诉JVM放入
 *      常量池中）和静态初始化块中的语句合并产生的。
 *      2.当初始化一个类的时候，发现父类没有初始化，则需要对父类进行初始化。
 *      3.虚拟机会保证一个类的<cInit>()方法在多线程环境中运行中被正确加锁和同步
 *      4.当访问一个java类静态域的时候，只有真正声明这个域的类才会被初始化。
 *
 * 本案例探讨的时类初始化过程的细致细节。
 *
 */
public class Demo1 {

    public static String string ="123";
    public static int n = 100;
    public final static int a;

    public static void testSout() {
        System.out.println("静态方法运行！");
    }

    static{
        a=100;
        System.out.println("静态初始块Demo");
        System.out.println(a);
        System.out.println(n);
        n=300;
        //testSout();//在静态块中调用testSout才会执行该方法，侧面说明了类加载初始化过程是调用<cInit>
                    //类构造器方法的！！
    }
    public String str = "非静态常量";
    {
        System.out.println("非静态初始化块");
     }
    public Demo1() {
        System.out.println("构造方法Demo");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 如果我们什么都不写，不使用new关键字调用a的构造器方法，并且main方法什么都不写（注释掉实验1代码）那么
         * 只会输出静态初始块demo以及a和n的变量值。这是因为Demo1类中由main方法入口，所以在main方法执行前，会运行
         * Demo1类的<cInit>类构造器的方法过程，而这个方法会执行static变量赋值和static块中的代码。所以
         * 我们Demo1类中的static变量会被赋值，并执行static块中的方法，而静态方法不会运行。然后执行main
         * 方法，main方法又啥也没干，所以只会输出这些语句。
         *
         * 而A类也在Demo1.java文件中，并在main方法运行前生成了class文件，为何A的静态块和静态属性没有被赋值呢？
         * 这是因为main方法在Demo1类中，如果main方法什么都不写，那么main方法在执行前，只会初始化包含main方法
         * 类的静态变量和静态块。
         * 于是引出了类的主动引用概念与被动引用概念
         *
         * 类的主动引用（一定会发生类的初始化！）
         * 1.new一个对象
         * 2.调用类的静态(static)成员（除了static final常量）和静态方法
         * 3.使用反射包的方法对类进行反射调用
         * 4.当虚拟机机启动的时候，会先启动main方法所在的类，并对main方法所在的类进行初始化
         * 5.当初始化一个类，如果其父类没有被初始化，则会先初始化他的父类
         *
         * 类的被动引用（不会发生类的初始化）
         * 1.当访问静态域时，只有真正声明了这个域的类才会被初始化
         *      案例：A_child继承了A，并在static块中直接访问了A的static变量n,属于子类
         *           直接访问父类定义的static变量或者static域。这时候不会发生类初始化A_child
         *           而会直接初始化其父类A。
         * 2.通过数组定义类引用，不会发生此类的初始化
         * 3.引用常量不会发生此类的初始化（常量在编译过程中就被存入调用类的常量池中了！！）
         */

        //实验1
        //A a = new A();
        //System.out.println(a.n);
        //System.out.println("查看把a构造方法注释掉，是否能够加载生成A的class文件,答案是能够生成");

        //以下为主动引用与被动引用的实验
        System.out.println("Demo1的main方法！");
        //主动引用
        //new A();//1.
        //System.out.println(A.n);//2.
        //Class.forName("ClassLoad.A");//3.
        //被动引用
        System.out.println(A.MAX);//1.
        A[] as = new A[10];//2.
        //System.out.println(A_child.n);
    }
}


class A_child extends A{
    static {
        System.out.println(A_child.n);//子类调用父类的static变量
    }
}

class A extends A_Father{
    public static int n = 100;
    public String a = "123";

    {
        System.out.println(a);
    }
    static{
        System.out.println("静态初始块A");
        n=300;
    }
    public A() {
        System.out.println("构造方法A");
    }
}

class A_Father{
    public static final int MAX=100;
    static {
        System.out.println("静态初始化A_Father");
    }
}