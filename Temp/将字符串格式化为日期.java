package one;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static javax.management.timer.Timer.ONE_DAY;

public class Two {
    public static void main(String[] args) {
        Date date = new Date();
        //将日期输出为字符串
        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
        //将字符串格式化为日期
        String str = "1901-1-1";
        String str1 = "2000-12-31";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
            Date date2 = sdf.parse(str1);
            System.out.println(date2);
            long days = (date2.getTime() - date1.getTime()) / ONE_DAY;
            System.out.println( (days - 5) / 7.0);

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
