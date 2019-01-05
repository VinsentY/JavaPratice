package five;

public class Five {
  
    public static void main(String[] args) {
    	double before = System.currentTimeMillis();
    	String string = " ";
        for(int i = 0 ; i< 100000; i++) {
        	string += i; 
        }
        double after = System.currentTimeMillis();
        System.out.println("Running Time: " + (after - before));
        
        double before1 = System.currentTimeMillis();
    	StringBuilder string1 = new StringBuilder(" ");
        for(int i = 0 ; i< 100000; i++) {
        	string1.append(i);
        }
        double after1 = System.currentTimeMillis();
        System.out.println("Running Time: " + (after1 - before1));
          
    }
  
}
//
//Running Time: 7867.0
//Running Time: 2.0