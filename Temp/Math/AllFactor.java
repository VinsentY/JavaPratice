package yikai.s.Math;

import yikai.s.Link.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：得到正整数的所有因子以及进行素因子分解
 */

public class AllFactor {

    //使用Map来存储质因数和其对应个数
    private static Map<Integer, Integer> decomposeList = new HashMap<>();

    //获取前100个素数
    private static List<Integer> primeList = PrimeNumber.getPrimeByNum(100);

    //得到这个数所有的因子
    public static List<Integer> getAllFactor(int num) {
        List<Integer> factorList = new ArrayList<>();
        if (!PrimeNumber.isPrime(num)) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    factorList.add(i);
                }
            }
        }
        return factorList;
    }

    //对这个数进行素因子分解
    public static void printDecompose(int num) {
        decomposeList.clear();

        int copyNum = num;

        while (!PrimeNumber.isPrime(num) && num != 1) {
            for (Integer prime : primeList) {
                if (num % prime == 0) {
                    decomposeList.put(prime, decomposeList.containsKey(prime) ? decomposeList.get(prime) + 1 : 1);
                    num /= prime;
                }
            }
        }

        decomposeList.put(num, decomposeList.containsKey(num) ? decomposeList.get(num) + 1 : 1);

        StringBuffer sbf = new StringBuffer();
        sbf.append(copyNum + " = ");
        for (Integer i : decomposeList.keySet()) {
            sbf.append(i + "^" + decomposeList.get(i) + " + ");
        }

        System.out.println(sbf.substring(0, sbf.length() - 3));
    }

    public static void main(String[] args) {

        List<Integer> list = getAllFactor(100);
        System.out.println(list);
    }

}
