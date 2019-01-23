package yikai.s.Math;

/**
 * 功能：排列组合数学公式，以及n的阶乘
 */

public class PermutationCombination {

	public static int P(int a, int b) {
		if (a < b) {
			return 0;
		}
		int result = factorial(a) / factorial(a - b);
		return result;
	}
	
	public static int A(int a, int b) {
		return P(a, b);
	}
	
	public static int C(int a, int b) {
		int result = P(a, b) / P(b, b);
		return result;
	}
	
	
	public static int factorial(int n) {
		int sum = 1;
		for(int i = n; i > 0; i--) {
			sum *= i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(C(5, 2));
		
	}

}
