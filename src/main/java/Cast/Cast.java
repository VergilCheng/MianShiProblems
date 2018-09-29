package Cast;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 测试各种类型转换，基本和引用
 */
public class Cast {
    /**
     * 基本类型转换
     */
    @Test
    public void test1() {
        byte b1 = 1;
        byte b2 = 2;
        //byte b3 = b1+b2;//报错，类型转换异常
        byte b3 = (byte)(b1+b2);
        System.out.println(b3);
        //原因:因为byte，short，char在赋值之前虽然还是原本的类型，但是
        // 参与计算的时候，都是转换为int再进行计算的，而且是数值进行
        //计算而不是变量计算，也就是说再编译期间已经替换为b3 = 3，但是3
        // 是int所以会报编译错误。
        //根本原因是因为计算机中存储数字是以32位的int来存储的。所以
        //计算的时候是int而不是byte。

    }
    @Test
    public void test2() {
        /*Scanner scan = new Scanner(System.in);
        *//*int n = scan.nextInt();
        System.out.println(n);
        *//*double n = scan.nextDouble();
        double upDay = Math.ceil(n/2);
        double upNum = upDay*(1+upDay)/2;
        double downDay = n-upDay;
        double downNum = downDay;
        System.out.print(upNum-downNum);*/
    }
    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("C:/Users/cheng/Desktop/用于流实验的文件夹/abc.txt");
        byte[] b = new byte[1024*8];
        int n = fis.read(b);
        System.out.println(b.length);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        double upDay = Math.ceil(n/2);
        double upNum = upDay*(1+upDay)/2;
        double downDay = n-upDay;
        double downNum = downDay;
        System.out.print((int)(upNum-downNum+1));
    }

}
