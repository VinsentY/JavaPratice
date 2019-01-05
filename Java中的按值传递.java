package seven;

public class Seven {
	
	
	public static void changeString(StringBuilder string) {
		string.delete(0,string.length());
		string.append("You're Changed");
	}
	
	public static void cannotChange(String string) {
		string = "You're Changed";
	}
	
	public static void main(String[] args) {
		StringBuilder string = new StringBuilder("Yikai");
		changeString(string);
		System.out.println(string);
		
		String string1 = "You're Changed by the world";
		cannotChange(string1);	//可不是我说不会变就不会变得哦！
		System.out.println(string1);
		
	}
}
