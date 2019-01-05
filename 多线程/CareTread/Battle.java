package seven;

//第二种方法:实现Runnable接口（和第一种方法类似）
public class Battle implements Runnable {
	
	private Friend one;
	private Friend two;
	
	public Battle(Friend one, Friend two) {
		super();
		this.one = one;
		this.two = two;
	}

	//必须重写run方法
	@Override
	public void run() {
		while(true) {
			one.careEach(two);
		}
	}

}
