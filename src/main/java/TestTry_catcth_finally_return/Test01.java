package TestTry_catcth_finally_return;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试finally，try-catch，return的执行顺序
 */
public class Test01 {


    /**
     * 执行顺序
     * 一、没有异常
     * try-catch，try中return中的返回值赋值，finally，return结束方法
     * 二、有异常
     * try-catch，catch中的返回值赋值，finally，return结束方法
     * 三、finally中有return
     * 这种情况下执行顺序一上两者不会发生变化，但是finally中的return会覆盖try-catch中
     * 的return赋值。
     *
     * 所以建议return语句要写在try-catch中。
     *
     * @return
     */


    public static Foo test01() {
        File f = new File("C:/Users/cheng/Desktop/用于流实验的文件夹/test1.txt");
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(f);
            byte[] bytes = new byte[10];
            String str = "abc";
            bytes = str.getBytes();
            fis.write(bytes);
            return new Foo("try中的Foo");//1
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new Foo();//4
        } catch (IOException e) {
            e.printStackTrace();
            return new Foo("异常中的Foo");//3
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
           // return new Foo("finally中的Foo");//2
        }

    }

    public static void main(String[] args) {
        test01();
    }


}
class Foo {
    public Foo(){
        System.out.println("构造Foo");
    }
    public Foo(String string){
        System.out.println(string);
    }
}