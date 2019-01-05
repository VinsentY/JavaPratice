package seven;

import java.util.*;

//Friend��
class Friend {
	private String name;
	private String character;
	private int age;

	public Friend(String name, String character, int age) {
		super();
		this.name = name;
		this.character = character;
		this.age = age;
	}

	public void careEach(Friend l) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		 
		System.out.println(name + " Care " + l.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Four {

	public static void main(String[] args) {
		
		Friend kid = new Friend("Yikai", "Love Dream and You and Cloud", 17);
		Friend girl = new Friend("BoYa", "Know You and is like You", 17);
		
//		�̳��߳���
//    	CareThread kidCare = new CareThread(kid, girl);
//    	kidCare.start();
    	
//    	CareThread girlCare = new CareThread(girl, kid);
//    	girlCare.start();
		
//		ʵ��Runnable�ӿ�
//		new Thread(new Battle(kid,girl)).start();
//		new Thread(new Battle(girl,kid)).start();
       
		//�����෽ʽ
		Thread kidCare = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					kid.careEach(girl);
				}				
			}
		};
		
		kidCare.start();
		
		Thread girlCare = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					girl.careEach(kid);
				}
			}
		};
		
		girlCare.start();
    }
}