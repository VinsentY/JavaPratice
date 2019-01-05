package seven;

//第一种方法： 继承Thread类
public class CareThread extends Thread {
	
	private Friend one;
	private Friend two;
		
	public CareThread(Friend one, Friend two) {
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
