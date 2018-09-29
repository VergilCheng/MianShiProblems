package JavaSe_Problems;

/**
 * 静态加载，类加载相关知识测试
 */
public class Test01 {


    // 静态变量
    public static String staticField = "静态变量";
    public static final String a ;


    // 变量 public
    String field = "变量";
    String field2;
    // 静态初始化块
    static {
        a = "123";
        System.out.println(a);
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }
    //静态方法
    public static void test_01(){
        System.out.println("静态方法");
    }
    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }
    // 构造器
    public Test01() {
        System.out.println("构造器");
    }
    //普通方法
    public void sout() {
        System.out.println("普通方法sout（）");
    }

    //main方法入口
    public static void main(String[] args) {

        Test01 test01 = new Test01();//常量最先初始化，即使写在静态变量的后面，所以123先于静态变量输出

    }
}