
package function;



class A {
	int a;
	A(int a ) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return Integer.toString(a);
	}
}

public class Test<T> {
	
	
	
	public void swap(A a, A b) {
		//如何构建泛型实例
//		T temp;
//		try {
//			temp = (T) a.getClass().newInstance();
//		} catch (InstantiationException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//正确的交换方式
		//在泛型下无法访问其内部数据结构，故必须要知道数据的类型的情况下才能交换
		//不像C++中可以通过指针来实现swap
		int temp = a.a;
		a.a = b.a;
		b.a = temp;
		
		
		System.out.println("str1 = " + a);
		System.out.println("str2 = " + b);
	}
	
	public void change(String str) {
		str = "StudentPro";
	}
	
	public static void main(String[] args) {
		Test<A> test = new Test<>();
		
		int a = 9;
		int b = 10;
		String str1 = new String("Happy");
		String str2 = new String("Day");
		
		test.change(str2);
		System.out.println(str2);
		
		A a1 = new A(1);
		A a2 = new A(2);
		test.swap(a1, a2);
		
		// Java中的交换问题
		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		
		str1 = "VeryHappy";
		System.out.println(str1);
		System.out.println(str2);

	}
	
}

