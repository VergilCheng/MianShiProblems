package Calender;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

    public static void main(String[] args) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.YEAR,1993);
        Date date = calendar.getTime();
        String a = sdf.format(date);
        System.out.println(a);
        //Date d = sdf.parse("1993-11-27");
        //System.out.println(d);
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());

    }
}
