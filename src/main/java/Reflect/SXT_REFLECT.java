package Reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 尚学堂对反射的补充知识
 *
 * 反射为什么会很慢为正常调用慢——setAccessible的作用：
 * setAccessible为启用和禁止访问安全检查的开关，如果值为true，则指示反射的对象在使用的时候应该取消Java
 * 语言的访问检查。值为false，则指示反射的对象应该实施Java语言访问检查。
 * 默认情况下为false，那么执行方法的时候都会进行访问检查，导致效率过慢，如果设置为true，则可以提高效率，
 * 但是破坏了封装。
 *
 *
 * 反射创建对象通过class对象的newInstance方法，而new方法创建对象则是直接调用构造器方法，所以new方法
 * 是快的。
 */
//@SuppressWarnings("all")//压制所有警告
public class SXT_REFLECT {

    /**
     * 1.获取Class对象的各种方法
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {

        //1.Class.forName(path):最常用，因为可以动态获取，而后两者获取class对象不是动态的
        String path = "Reflect.Foo";
        Class<?> clazz = Class.forName(path);
        System.out.println("第一种方法获得class对象：");
        System.out.println(clazz.hashCode());
        Class<?> clazz2 = Class.forName(path);
        System.out.println(clazz2.hashCode());//一个类的class对象应该只能获取一次，再次获取就是获取之前的class对象
        //2.对象.getClass()
        //3.类型.class
        System.out.println("第二种和第三种方式获得class对象：");
        Class strClass = path.getClass();
        Class strClass2 = String.class;
        System.out.println(strClass.equals(strClass2));
        Class intClass = int.class;
        System.out.println(intClass);
        //4.数组对象获取class对象是否一致
        int[] a = new int[10];
        int[] arr = new int[30];
        int[][] arr2 = new int[30][10];
        System.out.println("4."+(a.getClass()==arr.getClass()));
        System.out.println("5."+(arr.getClass().equals(arr2.getClass())));
    }

    /**
     * 2.通过反射api来操作class对象
     */
    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException {
        String path = "Reflect.Foo";
        Class<?> clazz = Class.forName(path);
        //1.获取类的名字
        System.out.println(clazz.getName());//获取包+类名
        System.out.println(clazz.getSimpleName());//获取类名
        //2.获取属性信息
        Field[] fields = clazz.getFields();//只能获得public的field
        for (Field f : fields) {
            System.out.println("public属性："+f);
        }
        Field[] fields1 = clazz.getDeclaredFields();//获取所有的filed
        for (Field f : fields1) {
            System.out.println("所有属性："+f);
        }
        //3.获取方法的信息
        Method[] methods = clazz.getDeclaredMethods();//获取所有方法
        for (Method m : methods) {
            System.out.println("所有方法："+m);
        }
        Method[] methods1 = clazz.getMethods();//获取public的方法
        for (Method m : methods1) {
            System.out.println("public方法："+m);
        }
        //4.获取指定方法名称的方法
        Method method = clazz.getDeclaredMethod("test2");//获取无参方法
        Method method1 = clazz.getMethod("method1",String.class);//获取有参数的方法
        //5.获取构造方法的信息
        Constructor[] constructors = clazz.getDeclaredConstructors();//获取所有构造器
        for (Constructor constructor:constructors) {
            System.out.println("构造方法"+constructor);
        }
        Constructor constructor = clazz.getConstructor(null);//获取无参构造器
        Constructor constructor1 = clazz.getConstructor(String.class);//获取String参数构造器
        System.out.println(constructor+"\t"+constructor1);
    }

    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //动态创建对象
        String path = "Reflect.Foo";
        Class<Foo> clazz = (Class<Foo>) Class.forName(path);
        Foo foo = clazz.newInstance();//其实是调用了user的无参数构造方法

        //调用有参数的构造器
        Constructor<Reflect.Foo> constructor = clazz.getDeclaredConstructor(String.class);
        Foo foo1 = constructor.newInstance("程铭哲");
        System.out.println(foo1);

        //通过反射调用普通方法
        Method method = clazz.getDeclaredMethod("test2");
        Integer integer = (Integer) method.invoke(foo1);
        System.out.println(integer);

        //通过反射操作属性
        Foo foo2 = clazz.newInstance();
        Field field = clazz.getDeclaredField("age");//获得属性对象Field
        //这里不能直接访问到foo的私有属性值，但是可以用一个方法获取方法的值
        field.setAccessible(true);//开启属性访问权限
        field.set(foo2,18);//通过反射直接写属性
        System.out.println(foo2.getAge());//通过反射直接读属性
    }
}
