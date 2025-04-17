package 牛客.牛客小白月赛101;

import java.util.Scanner;
import java.util.Stack;


// 栈：字符串
// 牛客：https://ac.nowcoder.com/acm/contest/90072/B

public class Btb的字符串问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == 'f' && s.charAt(i) == 'c') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == 't' && s.charAt(i) == 'b') {
                    stack.pop();
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }

        System.out.println(stack.size());
    }
}
