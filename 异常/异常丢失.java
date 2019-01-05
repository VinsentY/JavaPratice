package five;

import five.Switch.OrderException;
import five.Switch.SwitchException;

class Switch {
	boolean isOpen;

	public Switch(boolean isOpen) {
		super();
		this.isOpen = isOpen;
	}

	public void superLight() throws SwitchException {
		throw new SwitchException();
	}
	
	public void obeyOrder() throws OrderException {
		throw new OrderException();
	}
	
	public void open() {
		isOpen = true;
	}

	public void close() {
		isOpen = false;
		System.out.println("Successful Close!");
	}

	static class SwitchException extends Exception {

	}
	
	static class OrderException extends Exception {
		
	}
	
}

public class Test {

	public static void main(String[] args) {
		
		try {
			Switch switch1 = new Switch(true);
			try {
				switch1.superLight();
			} finally {
				try {
					switch1.obeyOrder();
				} catch (OrderException e) {
					e.printStackTrace();
				}
			}
		} catch (SwitchException e) {
			e.printStackTrace();
		} 

	}
}
