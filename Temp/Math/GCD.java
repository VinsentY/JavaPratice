package yikai.s.Math;

import java.util.Scanner;

/**
 * 功能：欧里基德求最大公因子，同时也可以得到对应的最小公倍数
 */

public class GCD {

	//得到最大公因子
	public static long gcd(long a, long b) {
		long c = 0;
		if (a == 0 || b == 0) {
			return a == 0 ? b : a;
		}
		if(a > b) {
			c = a % b;
			return gcd(b, c);
		} else {
			c = b % a;
			return gcd(a, c);
		}
	}

	//得到最小公倍数
	public static long lcm(long a, long b) {
		return a * b / gcd(a,b);
	}
	
	
	
	public static void main(String[] args) {
		
		long a = 15;
		long b = 31;

//		System.out.prlongln("GCD(" + a + " , " + b + ") = "  + gcd(a, b));
        System.out.println("LCM(" + a + " , " + b + ") = "  + lcm(a, b));


//		System.out.prlongln("Please Input Bezout:");
//		Scanner in = new Scanner(System.in);
//		String bezout = in.nextLine();

//		long a = Integer.valueOf(bezout.substring(0, bezout.indexOf("a")).trim());
//		long b = Integer.valueOf(bezout.substring(bezout.indexOf("+") + 1, bezout.indexOf("b")).trim());
//		long d = Integer.valueOf(bezout.substring(bezout.indexOf("=") + 1, bezout.length()).trim());
//
//		if (d % gcd(a, b) == 0) {
//			System.out.prlongln("it has solution!");
//		} else {
//			System.out.prlongln("it has NO solution!");
//		}
		
		
	}

}
