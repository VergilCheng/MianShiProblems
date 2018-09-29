package JavaSe_Problems;

import org.junit.Test;

/**
 * 包装类
 */
public class Test03 {

    @Test
    public void test01() {
        Integer i=6;//自动包装
        //将Integer转换为 double类型数据
        double d = i.doubleValue();
        System.out.println(d); //6.0
        //读取整数类型
        int n = i.intValue();
        System.out.println(n);//6
        //Java5 以后提供了自动拆包
        int m = i;//编译后 i.intValue();
        System.out.println(m);//6

        Double x = 6.6;
        double y = x.doubleValue();
        int k = x.intValue();
        double z = x;//x.doubleValue();
        System.out.println(x);//6.6
        System.out.println(y);//6.6
        System.out.println(z);//6.6
        System.out.println(k);//6

        Number num = 6.0;
        System.out.println(num);//toString()——6.0
    }

}




