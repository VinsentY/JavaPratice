package nine;

import java.io.*;


class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String number;
	private boolean isSingle;
	
	public Person(String name, int age, String number, boolean isSingle) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
		this.isSingle = isSingle;
	}
	
	public void printData() {
		
		System.out.print(name + ": 是谁来自山川湖海，却囿于昼夜厨房与爱");
	}
	
}

public class Test {
	
	public static void main(String[] args) {
		File f  = new File("G://folder","destFile.lol");
		
		
		Person yikai = new Person("Yikai", 17, "8002117053", false);
				
		try (
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
			) {
			
			oos.writeObject(yikai);
			Person erKai = (Person) ois.readObject();
			
			erKai.printData();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
