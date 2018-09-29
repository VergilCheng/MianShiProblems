package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Scanner;

/**
 * java反射
 */
public class Test01 {

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException,
                    InstantiationException, NoSuchMethodException, InvocationTargetException {

        /**
         * step1.jvm类加载过程，加载Foo.class文件并生成Class对象
         */
        Scanner in = new Scanner(System.in);
        System.out.println("请输入类名");
        String className = in.nextLine();
        //生成Foo类的Class类对象，可以通过cls对象操作Foo中的所有方法与属性
        Class cls = Class.forName(className);
        System.out.println(cls);
        System.out.println(cls.getName());

        /**
         * step2.根据cls对象来创建Foo对象
         *
         * 方法：newInstance()
         * 方法特点：
         * 1.动态创建对象
         * 2.可以创建任何对象，
         * 3.cls对应的类必须有无参构造器！！
         * 4.如果没有无参构造器则抛出异常！！
         *
         */
        Foo foo = (Foo) cls.newInstance();
        System.out.println(foo);
        /**
         * step3.根据cls对象来获取方法以及构造器信息
         *
         * getDeclaredMethods():返回类中声明的全部方法信息数组.
         * 可遍历其输出所有方法的信息。
         *
         */
        Method[] methods=cls.getDeclaredMethods();
        for (Method m:methods) {
            System.out.println(m.getName());
        }
        /**
         * getConstructors():获取所有构造器方法！
         */
        Constructor[] constructors = cls.getConstructors();

        for (Constructor c: constructors) {
            System.out.println(c);
        }
        /**
         * step4.动态执行方法
         */
        //动态找到一个方法
        System.out.println("输入方法名称");
        String name = in.nextLine();
        Method m = cls.getDeclaredMethod(name);//根据方法名称找到方法
        //动态执行无参数方法
        Object val = m.invoke(foo);//val为m方法的返回值或者sout

        //动态执行有参数方法
        Method m1 = cls.getDeclaredMethod("method1",String.class);//调用方法,声明方法形参类型

        Object val2 = m1.invoke(foo,"str");//方法形参值

        //动态执行有封装属性的方法
        Method m2 = cls.getDeclaredMethod("test1");
        m2.setAccessible(true);//打开私有化方法的权限，则其他类可以访问调用。但是会破坏封装
        Object val3 = m2.invoke(foo);
    }



}
