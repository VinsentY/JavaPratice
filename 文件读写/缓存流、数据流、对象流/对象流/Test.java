package ten;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class Person implements Serializable{
	private String name;
	private int id;
	private boolean isMale;
	
	
	
	public Person(int id) {
		super();
		this.id = id;
	}



	@Override
	public String toString() {
		return Integer.toString(id);
	}
	
	
	
}


//对象流
public class Test {

	public static void main(String[] args) {
		try(FileOutputStream fis = new FileOutputStream("G:/folder/test3.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fis);) {
			
			Person[] arr = new Person[10];
			
			for(int i = 0; i < 10; i++) {
				arr[i] = new Person(i);
			}
						
			for(int i = 0; i < 10; i++) {
				oos.writeObject(arr[i]);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("G:/folder/test3.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			for(int i = 0; i < 10; i++) {
				//乐观的编程主义者
				System.out.println(((Person)ois.readObject()).toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
