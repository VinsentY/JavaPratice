
package two;

import two.Tiger.Types;

interface CanSeeInZoo {
	public void touch();
}

abstract class Animal implements CanSeeInZoo {
	protected int leg;
	
	public Animal(int leg) {
		this.leg = leg;
	}
	
	public abstract void eat();
	public void walk() {
		System.out.println("It uses " + leg + " legs to walk");
	}
}

class Tiger extends Animal {

	enum Types { SOUTHERNCHINATIGER, JAGUAR, TIGGER};	//内部枚举类型
	Types types;
	
	public Tiger(int leg, Types types) {
		super(leg);
		this.types = types;
	}

	@Override
	public void eat() {
		switch (types) {
		case SOUTHERNCHINATIGER:
		case JAGUAR:
			System.out.println("I like eat meat!");
			break;
		case TIGGER:
			System.out.println("I'm friendly tiger and don't eat meat!");
		}
	}
	
	@Override
	public void walk() {
		System.out.println("Tigers walk with " + leg + " legs and everyone is afraid of them");
	}

	@Override
	public void touch() {
		switch (types) {
		case SOUTHERNCHINATIGER:
		case JAGUAR:
			System.out.println("You lose your fingers");
			break;
		case TIGGER:
			System.out.println("He jump so high!");
		}
	}
}

class Panda extends Animal {
	
	private final static boolean isCute = true;
	
	public Panda(int leg) {
		super(leg);
	}

	@Override
	public void eat() {
		System.out.println("Panda likes to eat Bamboo");
	}
	
	@Override
	public void walk() {
		super.walk();
		System.out.println("And it's very cute!");
	}

	@Override
	public void touch() {
		System.out.println("He have a round at the ground!");
	}
}

public class Two {
	
	public static void inZoo(CanSeeInZoo o) {
		o.touch();
	}
	
	public static void main(String[] args) {
		Animal secret = new Tiger(4, Types.JAGUAR);		//这样就可以访问到枚举类型啊！
		secret.eat();
		inZoo(secret);
	}
}
