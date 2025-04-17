package 青训营.豆包;

// 斐波那契数列

// 假设我们有一对兔子（1对）：
// 第1个月：这对兔子还没有成熟，只是活着。
// 第2个月：兔子成熟，开始生小兔子。
// 第3个月及以后：每对成熟的兔子每月都会生出1对小兔子，而新生的兔子需要再过1个月才能成熟。
public class 兔群繁殖之谜 {
    public static long solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 使用两个变量来记录斐波那契数列的前两项
        long prev1 = 1; // f(n-2)
        long prev2 = 2; // f(n-1)
        long current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2; // f(n) = f(n-1) + f(n-2)
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(1) == 1L);
        System.out.println(solution(5) == 8L);
        System.out.println(solution(15) == 987L);
    }
}

