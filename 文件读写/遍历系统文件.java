package five;
  
import java.io.File;
import java.io.IOException;
  
public class five {
  
	public static void iterator(File f) {
		if (f.isDirectory()) {
			if (f.listFiles() != null) {
				for(File temp : f.listFiles()) {
					iterator(temp);
				}
			}		
		} else {
			if (f.getName().contains("Visual")) {
				System.out.println(f.getAbsolutePath());
			}
			
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	File f1 = new File("C:/Windows");
    	
    	iterator(f1);
  	
    }
}