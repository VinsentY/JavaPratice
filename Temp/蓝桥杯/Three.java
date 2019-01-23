package one;

import yikai.s.Link.Link;
import yikai.s.Math.AllFactor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static yikai.s.Math.AllFactor.printDecompose;

public class Three {

    public static void main(String[] args) {
        String str = "5650 4542 3554 473 946 4114 3871 9073 90 4329 " + 
                "2758 7949 6113 5659 5245 7432 3051 4434 6704 3594 " + 
                "9937 1173 6866 3397 4759 7557 3070 2287 1453 9899 " + 
                "1486 5722 3135 1170 4014 5510 5120 729 2880 9019 " + 
                "2049 698 4582 4346 4427 646 9742 7340 1230 7683 " + 
                "5693 7015 6887 7381 4172 4341 2909 2027 7355 5649 " + 
                "6701 6645 1671 5978 2704 9926 295 3125 3878 6785 " + 
                "2066 4247 4800 1578 6652 4616 1113 6205 3264 2915 " + 
                "3966 5291 2904 1285 2193 1428 2265 8730 9436 7074 " + 
                "689 5510 8243 6114 337 4096 8199 7313 3685 211";
        String[] arr = str.split(" ");
        List<Integer> list = new ArrayList<>();
        for(String s : arr) {
            list.add(Integer.valueOf(s));
        }

        int sumFive = 0;
        int temp = 0;
        for(int i = 0; i < list.size(); i++) {
            AllFactor.printDecompose(list.get(i));
            temp = getSumFive(list.get(i));
            sumFive += temp;
        }
        System.out.println("sumFive is " + sumFive);
    }

    private static int getSumFive(Integer integer) {
        int n = 0;
        while (integer % 5 ==0) {
            n++;
            integer /= 5;
        }
        return n;
    }
}
