package three;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Êý¾ÝÁ÷
public class Test {

	public static void main(String[] args) {
		
		File file = new File("G:/folder/test1.txt");
		
		
		try (FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);) {
			
			dos.writeUTF("NanChang");
			dos.writeBoolean(true);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);) {
			
			System.out.println(dis.readUTF());
			System.out.println(dis.readBoolean());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}
