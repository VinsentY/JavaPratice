package eleven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
	
	public static void murgeFile(String folder, String fileName) {
		File destFile = new File(folder, "destFile.txt");
		
		try(FileOutputStream fos = new FileOutputStream(destFile)) {
			//destFile.createNewFile();
			
			int index = 0;
			
			while(true) {
				StringBuffer sbf = new StringBuffer(fileName);
				
				if (index == 0) {					
					sbf.insert(fileName.indexOf("public") + 6, index + 1);
				} else {
					sbf.insert(fileName.indexOf("c") + 1, index + 1);
				}
				
				File eachFile = new File(folder, sbf.toString());
				
				if (!eachFile.exists()) {
					break;
				}
				
				FileInputStream fis = new FileInputStream(eachFile);
				byte[] eachContent = new byte[(int) eachFile.length()];
				fis.read(eachContent);
				fis.close();
				
				fos.write(eachContent);
				//fos.flush();
				index++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void splitFile(File srcFile, int eachSize) {
		if (srcFile.length() == 0) {
			throw new RuntimeException("File is Empty!");
		}
		
		byte[] fileContent = new byte[(int) srcFile.length()];
		
		try(FileInputStream fis = new FileInputStream(srcFile)) {			
			fis.read(fileContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int fileNumber;
        // 文件是否能被整除得到的子文件个数是不一样的
        // (假设文件长度是25，每份的大小是5，那么就应该是5个)
        // (假设文件长度是26，每份的大小是5，那么就应该是6个)
        if (0 == fileContent.length % eachSize)
            fileNumber = (int) (fileContent.length / eachSize);
        else
            fileNumber = (int) (fileContent.length / eachSize) + 1;
        
        String path = srcFile.getName();
        
		for(int i = 0; i < fileNumber; i++) {
			
			StringBuffer sbf = new StringBuffer(path);
			
			if (i == 0) {
				sbf.insert(path.indexOf("public") + 6, i + 1);
			} else {
				sbf.insert(path.indexOf("c") + 1, String.valueOf(i + 1));
			}
			
			File eachFile = new File(srcFile.getParent(), sbf.toString());
			
			byte[] eachContent;
			
			if (i != fileNumber - 1) {
				eachContent = Arrays.copyOfRange(fileContent, eachSize * i,  eachSize * ( i + 1));
			} else {
				eachContent = Arrays.copyOfRange(fileContent, eachSize * i,  fileContent.length);
			}
			
			try {
				FileOutputStream fos = new FileOutputStream(eachFile);
				fos.write(eachContent);
				fos.close();
				
				 System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		
	}
	
	public static void main(String[] args) {
		int eachSize = 100;
		File srcFile = new File("G:/folder/public.txt");
		splitFile(srcFile,eachSize);
		murgeFile("G:/folder", "public.txt");
				
	}
}
