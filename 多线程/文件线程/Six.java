package six;
  
import java.io.File;
import java.io.IOException;
  
public class Six {
  
	public static void iterator(File f) {
		if (f.isDirectory()) {
			if (f.listFiles() != null) {
				for(File temp : f.listFiles()) {
					iterator(temp);
				}
			}		
		} else {
			if (f.getName().contains("Visual")) {
//				System.out.println(f.getAbsolutePath());
				 new SearchThread("2018", f).start();
			}
			
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	File f1 = new File("C:/Windows");
    	
    	iterator(f1);
  	
    }
}