package JavaSe_Problems;

import org.junit.Test;

import java.util.*;

/**
 * 测试集合类
 */
public class Test05 {

    @Test
    public void test1() {
        Person[] ary = new Person[3];
        ary[0] = new Person("Tom", 5);
        ary[1] = new Person("Jerry", 6);
        for(int i=0; i<ary.length; i++){
            System.out.print(ary[i]+" ");
        }
    }
    /**
     * 将集合替换为数组,如果集合中的数据是基本类型变量
     * 那么转换为数组的类型必须是包装类，不然出现类型转换
     * 的异常。
     *
     * 1.如果数组arr的长度没有list长，则arr内所有值为0，a中则是list的值
     * 2.如果数组arr的长度比list长，则arr与a的值为list全部填充完毕过后加一个null值，之后补0
     *
     */
    @Test
    public void test2() {

        Collection<Integer> col=
                new ArrayList<Integer>();
        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);
        col.add(5);
        col.add(6);
        col.add(7);
        col.add(8);
        //col.add(9);
        //col.add(10);
        //col.add(11);

        Integer[] ary = new Integer[10];
        for(int i=0; i<ary.length; i++){
            ary[i]=0;
        }
        Integer[] a=col.toArray(ary);

        for(Integer n:ary){
            System.out.print(n+"\t");
        }
        System.out.println();
        for(Integer n:a){
            System.out.print(n+"\t");
        }
    }
    @Test
    public void test3() {


        //"海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,海淀:156,香山:298,海淀:356"
        //1. 解析字符串得到每个地点和其PM2.5值
        //2. 创建散列表 map
        //3. 遍历输入数据
        //4. 如果有地点，取出比较在存入
        //5. 如果没有地点，直接存入

        String pm25 = "海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,"
                + "海淀:156,香山:298,海淀:356";
        //split方法可以对多种间隔符号进行分离
        String[] data = pm25.split("[,:]");
        //如果直接输出data则会输出内存地址。要么遍历输出，要么用Arrays.toString()
        System.out.println(Arrays.toString(data));
        Map<String, Integer> map =
                new LinkedHashMap<String, Integer>();
        for (int i = 0; i < data.length; i += 2) {

            String loc = data[i];
            String str = data[i + 1];
            //System.out.println(loc);

            int val = Integer.parseInt(str);
            if (map.containsKey(loc)) {
                int v = map.get(loc);
                if (val > v) {
                    map.put(loc, val);
                }
            } else {
                map.put(loc, val);
            }
        }

        //查询
        int val = map.get("海淀");
        System.out.println(val);
                //输出全部结果？
            }
        }





class Person{
    int age;
    String name;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "("+name+","+age+")";
    }




}
