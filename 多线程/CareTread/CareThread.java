package seven;

//��һ�ַ����� �̳�Thread��
public class CareThread extends Thread {
	
	private Friend one;
	private Friend two;
		
	public CareThread(Friend one, Friend two) {
		super();
		this.one = one;
		this.two = two;
	}
	
	//������дrun����
	@Override
	public void run() {
		while(true) {
			one.careEach(two);
		}
	}
}
