package yikai.s.Math;

import java.util.Stack;

/**
 * 功能：使用Stack来实现括号匹配
 */

public class ParenthesisMatching {
    public static boolean match(String expression) {
        char[] exp = expression.toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            switch (exp[i]) {
                case '(':
                    s.push(exp[i]);
                    break;
                case ')':
                    if (s.isEmpty()) {
                        return false;
                    } else {
                        s.pop();
                    }
                default:

                    break;
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(ParenthesisMatching.match("((9+4) * 2) + 4"));
    }
}
