package eleven;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class Eleven {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 2);	//先往前翻两个月
		c.set(Calendar.DATE,1);		//再设定日期为1
		c.add(Calendar.DATE, -3);	//再回溯3日
		System.out.println("下个月的倒数第三天：\t" + format(c.getTime()));	//format  parse
		
	}
	
	private static String format(Date time) {
        return sdf.format(time);
    }
}
