package JavaSe_Problems;

import org.junit.Test;

/**
 * String
 */
public class Test02 {

    public static final String a3;
    public static final String b3;

    static {
        a3="a";
        b3="b";
    }


    @Test
    public void test1() {
        //new方法和引号方法创造字符串
        String b = "abc";
        String c = "abc";
        String d = "a" + "bc";
        String a = new String("abc");//这种方式创建了两个对象，一个是new出来的，一个是构造器传入的参数"abc"
        System.out.println("a和b是否相同：" + (a == b));//不是同一个
        System.out.println("b和c是否相同：" + (b == c));//是同一个
        System.out.println("c和d是否相同：" + (d == c));//是同一个
        System.out.println("分割线**********************");

        String a1 = "a";
        String b1 = "b";
        String c1 = a1+b1;
        String d1 = "a"+"b";
        String e1 = a1+"b";
        System.out.println(c1==d1);//false,只有用"str1"+"str2"这种方式或者"str"这种方式创建的字符串才会放入常量池
        System.out.println(e1==d1);//false,这种引用，或者new的对象与引号的字符串之间用+连接不会放入连接池。
        System.out.println("分割线**********************");

        //分割线

        //用final修饰String
        final String a2 = "a";
        final String b2 = "b";
        String c2 = "ab";
        String d2 = a2+b2;
        System.out.println(c2 == d2);//true,final修饰并直接赋值的字符串，编译期间直接变成其值
        System.out.println("分割线*****************");

        //static静态变量，final修饰，static静态块赋值
        String c3 = "ab";
        String d3 = a3+b3;
        System.out.println(c3 == d3);//false,final修饰但是不直接赋值则不加入常量池。
        System.out.println("分割线*****************");

        //str.intern()方法,返回str在常量池中的字符串，如果没有则先创建一个str字符串，然后返回其在常量池中的引用
        String a4 = new String("abcd");
        String b4 = a4.intern();
        System.out.println(a4==b4);//false

    }
    @Test
    /**
     * lastIndexOf和IndexOf
     */
    public void test2() {
        String url = "http://tedu.cn/index.html";
        int i = url.indexOf("/",6);//从起始位置查找‘/’，包括起始位置。
        System.out.println(i);
        int j = url.lastIndexOf("/");//14
        int k = url.lastIndexOf("/",14);//包括起始位置。
        System.out.println(j);//14
        System.out.println(k);//14
    }
    @Test
    /**
     * StringBuilder类API
     */
    public void test3() {
        StringBuilder buf=
                new StringBuilder();
        buf.append("李洪鹤老师...");
        buf.insert(0, "那一年");
        buf.replace(4, 4+2, "某人");
        buf.delete(6, 6+2);
        String s = buf.toString();
        System.out.println(s);
    }
    /**
     * 正则表达式的API——matches
     */
    @Test
    public void test4() {
        //String reg=".+\\.jpe?g";
        String reg=".+\\.(jpe?g|png|gif)";
        //正则表达式： .+\.(jpe?g|png|gif)
        //Java 字符串: .+\\.(jpe?g|png|gif)
        String file = "她.png";
        System.out.println(reg);
        boolean b = file.matches(reg);
        System.out.println(b);
    }
    /**
     * split和replaceAll
     */
    @Test
    public void test5() {
        //split
        String str= "1, 李洪鹤, 110, lihh@tedu.cn, 北京海淀区";
        String[] data=str.split(",\\s*");
        // "1", "李洪鹤" ...
        System.out.println(data[1]);
        //replace
        String str1 = "那一年，我去你家，你说我去！";
        String reg = "我去";
        String s = str1.replaceAll(reg, "XXX");
        System.out.println(s);
    }

}


