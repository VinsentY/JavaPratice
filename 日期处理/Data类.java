package nine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Test {
		
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
		
		Date birthDay;
		String string = "2000/8/3 16:00:00";
		birthDay = sdf.parse(string);	//按照格式将字符串直接转换为Date
				
		List<Date> dates = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			long random = (long) (Math.random() * birthDay.getTime());
			dates.add(new Date(random));
		}
		
		System.out.println("排序前容器： " + dates);
		
		Iterator<Date> it = dates.iterator();
			
		//为什么你们要取各种各样的函数名字？
		for(int i = 0; i < dates.size() - 1; i++) {
			for(int j = i + 1; j < dates.size(); j++ ) {
				if (dates.get(j).getTime() < dates.get(i).getTime()) {
					
					Date temp = new Date(dates.get(j).getTime());
					dates.get(j).setTime(dates.get(i).getTime());
					dates.get(i).setTime(temp.getTime());
				}
			}
		}
		
		System.out.println("排序后容器： " + dates);
		
	}

}
