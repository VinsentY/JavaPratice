package eight;

import java.util.Arrays;

abstract class Processor<T> {
	public String name() {
		return getClass().getSimpleName();	//I find it!
	}
	
	abstract T process(T input);
}

class Upcase extends Processor<String> {

	@Override
	String process(String input) {
		return input.toUpperCase();
	}
}

class Downcase extends Processor<String> {

	@Override
	String process(String input) {
		return input.toLowerCase();
	}
}

class Splitter extends Processor<String> {

	@Override
	String process(String input) {
		return Arrays.toString(input.split(" "));
	}
}

class Waveform {
	
	private static long couter;
	private final long id = couter++;
	
	@Override
	public String toString() {
		return "Waveform  " + id;
	}
}

class Filter extends Processor<Waveform>{

	@Override
	Waveform process(Waveform input) {
		//假装我们已经处理了信号...
		return input;
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
//		process(new Upcase(), string);
//		process(new Splitter(), string);
//		process(new Downcase(), string);
		process(new Filter(), new Waveform());
	}
}






