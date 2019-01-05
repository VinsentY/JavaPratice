package four;

import java.util.Arrays;

public class Four {
     
    public static void main(String[] args) {
    
        String string = "i always say what you love is somethings make you happy";
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.replace(0, 1,String.valueOf((Character.toUpperCase(string.charAt(0)))));	//炫不炫酷？
        
        System.out.println(stringBuilder.toString());
        
        char[] ch = "Vinsent".toCharArray();
        
        String string3 = new String(ch);
        
        //String string3 = new StringBuilder().append(ch).toString();	//是不是叼炸天？(然并*)
    
        System.out.println(string3);
        
         //灵活使用Java中类中自带的方法往往效率高，又安全。
        
        String name = "vinsent yikai";
        StringBuffer stringBuffer = new StringBuffer();
        
        int i = 0;
        while(i < name.length() ) {
        	if (i % 2 == 0) {
				stringBuffer.append(Character.toUpperCase(name.charAt(i)));
			} else {
				stringBuffer.append(name.charAt(i));
			}
        	i++;
        }
        
        System.out.println(stringBuffer.toString());
        //恭喜你，成功成为字符串操作大师
        
        
        String boom = "Boom";
        stringBuffer.delete(0, stringBuffer.length()).append(boom);
        stringBuffer.replace(boom.length() -1 , boom.length(), String.valueOf((Character.toUpperCase(boom.charAt(boom.length() -1)))));
        System.out.println(stringBuffer.toString());
        
        String s = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        
        int index = s.lastIndexOf("two");
        char[] arr = s.toCharArray();
        arr[index] = Character.toUpperCase(arr[index]);
        String ss = new String(arr);
        System.out.println(ss);
        
        //这种炫技的方式的代码可读性较差
        //String ss = new StringBuilder(s).replace(index, index + 1, String.valueOf(Character.toUpperCase(s.charAt(index)))).toString();
        
        String str1 = "the light";
        
        String start = "the";
        String end = "Ight";
         
        System.out.println(str1.startsWith("t"));//以...开始
        System.out.println(str1.endsWith(end));//以...结束
        
    }
}




