package JavaSe_Problems;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期与日历类
 */
public class Test04 {

    @Test
    public void test1() {

        Calendar c1 =
                new GregorianCalendar();
        Calendar c2 = Calendar.getInstance();
        //默认的Calendar里面封装是当前系统时间
        System.out.println(c1);
        System.out.println(c2);
        //将Calender转换为Date类型
        Date date = c1.getTime();
        SimpleDateFormat fmt =
                new SimpleDateFormat();
        System.out.println(fmt.format(date));

        //创建指定年月日的Calender
        Calendar cal =
                new GregorianCalendar(
                        2017, Calendar.MARCH, 6);
        //输出结果：
        date = cal.getTime();
        System.out.println(fmt.format(date));
    }
    @Test
    public void test2() {
        //默认的Calender是当前时间
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());
        //利用set方法修改时间分量：
        //修改年份分量
        cal.set(Calendar.YEAR, 2000);
        //修改月份分量
        cal.set(Calendar.MONTH,
                Calendar.AUGUST);
        //修改日期分量
        cal.set(Calendar.DATE, 1);
        //检查修改的结果：
        System.out.println(cal.getTime());

        //超量更改时间：32天是一个月多一天
        cal.set(Calendar.DATE, 32);
        System.out.println(cal.getTime());
    }
    @Test
    /**
     * 输出每个月最大的日期
     */
    public void test3() {
        Calendar cal=Calendar.getInstance();

        for(int i=Calendar.JANUARY;
            i<=Calendar.DECEMBER; i++){
            cal.set(Calendar.MONTH, i);
            cal.set(Calendar.DATE,1);
            int max=cal.getActualMaximum(
                    Calendar.DAY_OF_MONTH);
            System.out.println(max);
        }
    }
}
