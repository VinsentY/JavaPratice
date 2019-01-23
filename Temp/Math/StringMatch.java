package yikai.s.Math;

/**
 * 功能：字符串匹配的算法（KMP算法）
 */

public class StringMatch {
	
	public static int match(String pattern, String text) {
		
		int i = 0;
		int j = 0;
		for(i = 0; i < text.length() -  pattern.length() + 1; i++) {
			for(j = 0; j < pattern.length(); j++) {
				if (pattern.charAt(i + j) != text.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length()) {
				return i;
			}
		}
		return -1;
		
	}
	
	public static int[] buildNext(String pattern) {
		int length = pattern.length();
		int[] next = new int[length];
		int t = next[0] = -1;
		int j = 0;
		while(j < length - 1) {
			if (t == -1 || pattern.charAt(j) == pattern.charAt(t)) {
//				next[++j] = ++t;
				j++;
				t++;
				if (pattern.charAt(j) != pattern.charAt(t)) {
					next[j] = t;
				} else {
					next[j] = next[t];
				}
				
			} else {
				t = next[t];
			}
		}
		return next;
	}
	
	public static int KMP(String pattern, String text) {
		int i = 0;
		int j = 0;
		int[] next = buildNext(pattern);
		while( i < text.length() && j < pattern.length()) {
			if (j == -1 || text.charAt(i) ==  pattern.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return i - j;
	}
	
	public static void main(String[] args) {


		System.out.println(KMP("Hello1", "Hello1 World!"));
	}

}
