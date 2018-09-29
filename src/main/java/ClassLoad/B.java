package ClassLoad;

public class B {
    public static int b = 100;
    static{
        System.out.println("静态初始类A");
        b=300;
    }
    public B() {
        System.out.println("构造方法B");
    }
}
