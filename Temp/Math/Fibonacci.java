package yikai.s.Math;

/**
 * 功能：费波纳茨数列
 */

public class Fibonacci {
    public static long fibonacci(long n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return fibonacci(n - 1) +  fibonacci(n - 2);
        }
    }
}
