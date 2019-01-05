package ninty;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Ninty {
	
	
	public static char[] read(File f) {
		
		char[] all = new char[(int)f.length()];
		
		try (FileReader fr = new FileReader(f)) {			
			fr.read(all);			
//			for (char b : all) {
//				System.out.print(b);
//			}
		} catch (IOException e){
			e.printStackTrace();			
		}
		return all;
	}
	
	public static char[] simpleEncryption(char[] all) {
		for(int i = 0; i < all.length; i++) {
			all[i]++;	//假装有加密算法
		}
		return all;
	}
	
	public static char[] simpleDecrypt(char[] all) {
		for(int i = 0; i < all.length; i++) {
			all[i]--;	//假装有加密算法
		}
		return all;
	}
	
	public static void write(File f, char[] str) {
		
		try (FileWriter fw = new FileWriter(f)) {
			//String str = "People come and left Never 365";
			fw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		File f = new File("G:/folder","destFile.txt");
		
		char[] security = simpleEncryption(read(f));
		write(f,security);
	
//		write(f, simpleDecrypt(read(f)));

	}

}
