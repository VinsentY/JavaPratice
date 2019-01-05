package Eight;

public class Dragon {
	
	int hp;
	
	private Dragon() {}
	
//	private static Dragon bigDragon = new Dragon();
//	
//	static Dragon instance() {
//		return bigDragon;
//	}		饿汉式单例模式
//	
	private static Dragon smallDragon;
	
	static Dragon instance() {
		if(smallDragon == null) {
			smallDragon = new Dragon();
		}
		
		return smallDragon;
	}		//懒汉式单例模式
	
	public void fire() {
		System.out.println("Do you feel hot?");
	}
	
	public static void main(String[] args) {
			Dragon dragon = Dragon.instance();
			dragon.fire();
	}
}