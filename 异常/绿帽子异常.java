package two;

class LoveException extends Exception {
	public LoveException() {
		super();
	}

	public LoveException(String msg) {
		super(msg);
	}
}

class Person {
	String name;
	Person lover;

	public Person(String name) {
		this.name = name;

	}

	void green() throws LoveException {

		if (lover.getLover() != this) {
			throw new LoveException(lover + " Green " + this + " !");
		} else {
			System.out.println("He live a happy life");
		}

	}

	void setLover(Person lover) {
		this.lover = lover;
	}

	Person getLover() {
		return lover;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class Two {

	public static void main(String[] args) {

		Person xiaoming = new Person("xiaoming");
		
		Person xiaohong = new Person("xiaohong");
		
		Person xiaowang = new Person("xiaowang");
		
		xiaoming.setLover(xiaohong);
		xiaohong.setLover(xiaowang);
		xiaowang.setLover(xiaohong);

		try {
			xiaowang.green();
		} catch (LoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}