package ten;

import java.util.Arrays;

public class Ten {
	
	public static int[] getNext(String ps) {

	    char[] p = ps.toCharArray();

	    int[] next = new int[p.length];

	    next[0] = -1;

	    int j = 0;

	    int k = -1;

	    while (j < p.length - 1) {

	       if (k == -1 || p[j] == p[k]) {

	           next[++j] = ++k;

	       } else {

	           k = next[k];

	       }

	    }

	    return next;

	}

	
	public static void main(String[] args) {
		String temp = "ABACDABABC";
		
		int[] next = getNext(temp);
		
		System.out.println(Arrays.toString(temp.toCharArray()));
		System.out.println(Arrays.toString(next));
	}
}
