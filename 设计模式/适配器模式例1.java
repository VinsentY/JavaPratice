package eight;

import java.util.Arrays;

class CharacterPairSwapper  {
	//两两交换相邻字符
	static String swap(String string) {
		StringBuffer sbf = new StringBuffer(string);
		for(int i = 0; i < string.length() - 1; i += 2) {
			char c1 = string.charAt(i);
			char c2 = string.charAt(i + 1);
			sbf.setCharAt(i, c2);
			sbf.setCharAt(i + 1, c1);
			
		}
		
		return sbf.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(swap("YESOP"));
	}
}

abstract class Processor<T> {
	public String name() {
		return getClass().getSimpleName();	//I find it!
	}
	
	abstract T process(T input);
}

class SwapperAdapter extends Processor<String> {

	@Override
	String process(String input) {
		return CharacterPairSwapper.swap(input);
	}
	
}

public class Apply {
	//创建一个能够根据所传递的参数对象的不同而具有不同行为的方法
	//称为策略设计模式
	
	public static void process(Processor processor, Object object) {
		System.out.println("Using Processor"  + processor.name());
		System.out.println(processor.process(object));
	}
	
	public static String string = "Disagreement with beliefs is by definition incorrect";
	
	public static void main(String[] args) {
		process(new SwapperAdapter(), "YESOP");
	}
}





