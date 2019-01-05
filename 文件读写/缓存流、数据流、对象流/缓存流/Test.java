package two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//缓存流
public class Test {

	public static void main(String[] args) {
		File file = new File("G:/folder/test.txt");

		try (FileWriter fWriter = new FileWriter(file); 
			PrintWriter br = new PrintWriter(fWriter);) {
			
			br.println("NanChang");
			br.println("University");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)) {
			
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
