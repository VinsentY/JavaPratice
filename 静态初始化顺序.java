
package rely;

class Bowl {
	public Bowl(int marker) {
		System.out.println("Bowl(" + marker + "Construtor )");
	}
	
	void f1(int marker) {
		System.out.println("f1(" + marker + ")");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1);
	public Table() {
		System.out.println("Table() Construtor");
	}
	
	void f2(int marker) {
		System.out.println("f2(" + marker + ")");
	}
	
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	public Cupboard() {
		System.out.println("Cupboard() Construtor");
	}
	
	void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}
	static Bowl bowl = new Bowl(5);
}

public class Test {
	public static void main(String args[]) {
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}