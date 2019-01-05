package nine;


class Rectangle implements Shapes {

	@Override
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
	
}

class Triangle implements Shapes {

	@Override
	public void draw() {
		System.out.println("Drawing a Triangle");
	}
	
}

public interface Shapes {
	
	public void draw();
	
	
	public static void main(String[] args) {
		Shapes shapes = new Rectangle();
		shapes.draw();

	}

}
