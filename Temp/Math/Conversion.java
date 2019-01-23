package yikai.s.Math;

import java.util.Stack;

/**
 * 功能：实现十进制和其他常用进制的相互转换
 */

public class Conversion {

    public static String binToInt(String input) {

        int result = 0;
        char[] arr = input.toCharArray();
        for (char c : arr) {
            result = 2 * result + Integer.valueOf(String.valueOf(c));
        }
        return String.valueOf(result);
    }

    public static String octToInt(String input) {
//        if (input.startsWith("0")) {
//            input = input.substring(1,input.length());
//        }

        int result = 0;
        char[] arr = input.toCharArray();
        for (char c : arr) {
            result = 8 * result + Integer.valueOf(String.valueOf(c));
        }
        return String.valueOf(result);
    }

    public static String hexToInt(String input) {

        if (input.startsWith("0x")) {
            input = input.substring(2, input.length());
        }

        int result = 0;
        char[] arr = input.toCharArray();
        for (char c : arr) {
            result = 16 * result + charToNum(c);
        }
        return String.valueOf(result);
    }

    public static String intToBin(int input) {
        int entry = 2;
        Stack<Integer> s = new Stack<>();
        int remainder = 0;
        while (input != 0) {
            remainder = input % entry;
            s.push(remainder);
            input /= entry;
        }
        StringBuffer sbf = new StringBuffer();
        while(!s.isEmpty()) {
            sbf.append(s.pop());
        }
        return sbf.toString();
    }

    public static String intToOct(int input) {
        int entry = 8;
        Stack<Integer> s = new Stack<>();
        int remainder = 0;
        while (input != 0) {
            remainder = input % entry;
            s.push(remainder);
            input /= entry;
        }
        StringBuffer sbf = new StringBuffer();
        sbf.append("0");
        while(!s.isEmpty()) {
            sbf.append(s.pop());
        }
        return sbf.toString();
    }

    public static String intToHex(int input) {
        int entry = 16;
        Stack<Character> s = new Stack<>();
        int remainder = 0;
        while (input != 0) {
            remainder = input % entry;
            s.push(Character.valueOf(numToChar(remainder)));
            input /= entry;
        }
        StringBuffer sbf = new StringBuffer();
        sbf.append("0x");
        while(!s.isEmpty()) {
            sbf.append(s.pop());
        }

        return sbf.toString();
    }

    private static char numToChar(int i) {
        char c = ' ';
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                c = String.valueOf(i).toCharArray()[0];
                break;
            case 10:
                c = 'A';
                break;
            case 11:
                c = 'B';
                break;
            case 12:
                c = 'C';
                break;
            case 13:
                c = 'D';
                break;
            case 14:
                c = 'E';
                break;
            case 15:
                c = 'F';
                break;
        }
        return c;
    }

    private static int charToNum(char c) {
        int i = 0;
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                i = Integer.valueOf(String.valueOf(c));
                break;
            case 'A':
            case 'a':
                i = 10;
                break;
            case 'B':
            case 'b':
                i = 11;
                break;
            case 'C':
            case 'c':
                i = 12;
                break;
            case 'D':
            case 'd':
                i = 13;
                break;
            case 'E':
            case 'e':
                i = 14;
                break;
            case 'F':
            case 'f':
                i = 15;
                break;

        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(intToHex(1500));
        System.out.println(hexToInt("0x5DC"));
    }

}
