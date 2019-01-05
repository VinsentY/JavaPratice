package four;

//: interfaces/RandomWords.java
// Implementing an interface to conform to a method.
import java.nio.*;
import java.util.*;

public class RandomChar implements Readable {
	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();

	private int count;

	public RandomChar(int count) {
		this.count = count;
	}

	public int read(CharBuffer cb) {
		if (count == 0)
			return -1; // Indicates end of input
		
		switch (count) {
		case 3:
			cb.append(capitals[rand.nextInt(capitals.length)]);
			for (int i = 0; i < 4; i++) {
				cb.append(vowels[rand.nextInt(vowels.length)]);
				cb.append(lowers[rand.nextInt(lowers.length)]);
			}
			break;
		case 1:
		case 2:
			cb.append(capitals[rand.nextInt(capitals.length)]);
			for (int i = 0; i < 2; i++) {
				cb.append(lowers[rand.nextInt(lowers.length)]);
			}
			break;
		default:
			break;
		}
		
		cb.append(" ");
		
		count--;
		
		return 10; // Number of characters appended
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomChar(3));
		while (s.hasNext())
			System.out.println(s.next());
	}
} 
