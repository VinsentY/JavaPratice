package six;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchThread extends Thread{
	
	private String str;
	private File f;
	
	
	
	public SearchThread(String str, File f) {
		super();
		this.str = str;
		this.f = f;
	}



	@Override
	public void run() {
		try (FileReader fr = new FileReader(f);) {
			char[] all = new char[(int) f.length()];
			fr.read(all);
			
			if (new String(all).contains(str)) {
				System.out.printf("找到子目标字符串%s,在文件:%s%n",str,f.getName());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
