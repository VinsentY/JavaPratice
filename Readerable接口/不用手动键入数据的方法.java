package Second;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;



//import java.awt.ItemSelectable;



public class Sequence {
    
    public static BufferedReader input = new BufferedReader(new StringReader("Yikai 17 Sunshine"));	//这样的作用是？
    
    public static void main(String[] args) {
	String str = "Yikai 17 Sunshine";
	Scanner in = new Scanner(str);
	System.out.println("请输入你的名字");
	String name = in.next();
	System.out.println("请输入你的年龄");
	int age = in.nextInt();
	System.out.println("请描述你自己");
	String describe = in.next();
	System.out.println(name + " " + age + " " + describe);
	
    }

}