package three;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.css.PseudoClass;

class SafeBox {
	private String password;
	
	private boolean isOpen = false;
	
	public SafeBox(String password) {
		this.password = password;
	}
	
	boolean open(String trying) {
		
		if (trying.equals(password)) {
			isOpen = true;
		} 
//		else {
//			System.out.println("保险箱并没有打开");
//		}
		return isOpen;
	}
}



public class Cracker {
	
	int index = 0;
	
	StringBuilder stringBuilder = new StringBuilder();
	
	String password;
	
	boolean isfind = false;
		
	int[] arr;
	
	final int NUMBER;
		
	public Cracker(int number) {
		NUMBER = number;
		arr = new int[number];
	
	}

	public String find(SafeBox safeBox, int index) {
		
			
		if (index == NUMBER) {
					
			stringBuilder.delete(0, stringBuilder.length()); 
			for(int temp : arr) {
				stringBuilder.append(temp);
			}
			if (safeBox.open(stringBuilder.toString())) {
				password = stringBuilder.toString();
				isfind =  true;
			}
		} else {
			
			for(arr[index] = 0; arr[index] <= 9; arr[index]++) {
				if (isfind) {
					return stringBuilder.toString();
				}
				find(safeBox, index + 1);
			}
		}
		return " ";
		
	}
	
	public static void main(String[] args) {
		SafeBox safeBox = new SafeBox("5201314");
		Cracker cracker = new Cracker(7);
		String password =  cracker.find(safeBox, 0);
		if (password != " ") {
			System.out.println("You get a million dolloar!");
			System.out.println("And the password is " + password);
		}
						
	}
}
