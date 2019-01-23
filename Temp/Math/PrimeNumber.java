package yikai.s.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：判断整数是否为素数以及得到对应范围内的素数表
 */

public class PrimeNumber {
	

	public static List<Integer> getPrimeByRange(int num) {
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < num; i++) {
			if (isPrime(i)) {
				primeList.add(i);
			}
		}
		
		return primeList;
	}

	public static List<Integer> getPrimeByNum(int num) {
		List<Integer> primeList = new ArrayList<>();
		int i = 2;
		int cnt = 0;
		while(cnt != num) {
			if (isPrime(i)) {
				primeList.add(i);
				cnt++;
			}
			i++;
		}
		
		return primeList;
		
	}
	
	public static boolean isPrime(int num) {
		
		if (num <= 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(getPrimeByNum(100));
	}

}
