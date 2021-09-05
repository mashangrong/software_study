package common;

import java.util.Stack;

/**
 * 输入：s = "3+2*2"
 * 输出：7
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        char preChar = '+';
        int num = 0;

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preChar) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                    default :
                        break;
                }
                preChar = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
