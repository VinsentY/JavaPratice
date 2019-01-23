package one;

import yikai.s.Math.GCD;

import static yikai.s.Math.GCD.gcd;


public class One {

    public static void main(String[] args) {
        long n = 1;
        long a = 1;
        long lcm = 1;
        long newLcm = 0;
        for(long i = 1; i <= 19; i++) {
            n *= 2;
            newLcm = GCD.lcm(lcm, n);
            a = newLcm/lcm * a + newLcm/(n);
            lcm = newLcm;
            System.out.println("第" + i + "次,分子" + a + "分母:" + lcm);
        }
        long t = gcd(a,lcm);
        a /= t;
        lcm /= t;
        System.out.println("分子" + a + "分母:" + lcm);

    }


}


