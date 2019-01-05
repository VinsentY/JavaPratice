package eat;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class Char {
    private char[] arr = new char[10];
    public static Random random = new Random();
    public char[] next() {
	for(int i = 0; i<5; i++) {
	    arr[i] = (char)(random.nextInt(25) + 65);
	    System.out.println(arr[i] + " ");
	}
	return arr;
    }
}

class CharAdapater extends Char implements Readable {
    
    private int count;
    public CharAdapater(int count) {
	this.count = count;
    }
    
    
    @Override
    public int read(CharBuffer cb) throws IOException {
	if (count--==0) {
	    return -1;
	}
	String result = "";
	for(char ch : next()) {
	    result += ch;
	}

	cb.append(result);
	return result.length();
    }
    
}

public class Music {
    
    public static void main(String[] args) {
	Scanner scanner = new Scanner(new CharAdapater(1));
	
	while(scanner.hasNext()) {
	    System.out.print(scanner.next());
	}
    }
}