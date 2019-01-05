package eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {
	
	public static void Hanoi(int n, char x, char y, char z) {
		if (n == 1)
			System.out.printf("%c-->%c\n", x, z);
		else {
			Hanoi(n - 1, x, z, y);
			System.out.printf("%c-->%c\n", x, z);
			Hanoi(n - 1, y, x, z);
		}
	}

	public static void main(String[] args) {
		
		Hanoi(3, 'X', 'Y', 'Z');
	}
}