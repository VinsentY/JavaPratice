package ten;

import java.io.*;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		File f = new File("G:/folder","destFile.txt");
		ArrayList<String> arr = new ArrayList<String>();
		try( FileReader sr = new FileReader(f);
			 BufferedReader br = new BufferedReader(sr);) {
			while(true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				arr.add(line);
			}		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File f1 = new File("G:/folder","destFile1.txt");
		
		try( FileWriter fw = new FileWriter(f1);
			 PrintWriter pw = new PrintWriter(fw);) {
			for(String temp : arr) {
				if(temp.contains("//")) {
					continue;
				}
				pw.println(temp);
			}			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		try (FileReader fr = new FileReader(f);
//			BufferedReader br = new BufferedReader(fr);
//			) {
//			while(true) {
//				String line = br.readLine();
//				//使用缓存流读取数据
//				if (line != null) {
//					System.out.println(line);
//				} else {
//					break;
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
