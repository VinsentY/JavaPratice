package seven;

//�ڶ��ַ���:ʵ��Runnable�ӿڣ��͵�һ�ַ������ƣ�
public class Battle implements Runnable {
	
	private Friend one;
	private Friend two;
	
	public Battle(Friend one, Friend two) {
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
