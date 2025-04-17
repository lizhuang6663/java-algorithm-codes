package 代码随想录And力扣.单调栈;

import java.util.Scanner;
import java.util.Stack;

// 栈：栈尾到栈顶递增
// 牛客，校队比赛：https://ac.nowcoder.com/acm/contest/73229/C
public class TieTie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Long> stack = new Stack<>();

        int res = 0;

        for (int i = 0; i < n; i++) {
            long w = scanner.nextLong(); // 宽没有用
            long h = scanner.nextLong();

            // 如果 stack.peek() == h 就不添加
            // 避免出现左右两边高，中间低的情况

            while (!stack.isEmpty() && stack.peek() > h) {
                res ++;
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < h) {
                stack.add(h);
            }
        }

        System.out.println(res + stack.size());
    }
}


// 方法二：（没看明白）
/*
public class P1029区间求和EasyVersion {
    public static void P24多路归并Ⅱ(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取矩形数量

        long[] w = new long[n + 1]; // 矩形的宽度数组
        long[] h = new long[n + 1]; // 矩形的高度数组
        long[] q = new long[n + 1]; // 存储矩形高度的数组，用于计算覆盖次数
        int top = 0; // 栈指针，指向存储矩形高度的数组的顶部位置

        // 读取每个矩形的宽度和高度
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextLong();
            h[i] = scanner.nextLong();
        }

        long ans = 0; // 记录没有被完全覆盖的矩形数量
        for (int i = 1; i <= n; i++) {
            int j;
            for ( j = top - 1; j >= 0; j--) {
                if (q[j] < h[i]) {
                    break;
                }
                if (q[j] == h[i]) {
                    ans++;
                }
            }
            top = j + 1;
            q[top++] = h[i];
        }

        System.out.println(n - ans); // 输出没有被完全覆盖的矩形数量
    }
}

 */