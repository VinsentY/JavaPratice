package eleven;

public class TestThread {
	public static void main(String[] args) {
	     
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
              
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                      
                    try {
                        //减慢掉血的速度
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
    
            }
        };
        t1.start();
    
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
    
                    try {
                        //加快回血的速度
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
    
            }
        };
        t2.start();
              
    }
}
