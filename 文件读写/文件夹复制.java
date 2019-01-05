
package eight;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Test {
	public static void copyFile(String srcFile, String destFile) {
		File sf = new File(srcFile);
		File df = new File(destFile);
		
		
		if(sf.isDirectory()) {
			if (sf.listFiles() != null) {
				for(File temp : sf.listFiles()) {
					copyFile(temp.getAbsolutePath(), df.getAbsolutePath() + "/" + temp.getName());
				}
			}
		} else {
			
			try (
					FileReader fr = new FileReader(sf);
					FileWriter fw = new FileWriter(df);
			) {
				char[] all = new char[(int) sf.length()];
				fr.read(all);
				
				fw.write(all);				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
    public static void main(String[] args) {
    	copyFile("G:/folder/1", "G:/folder/2");
    }
}