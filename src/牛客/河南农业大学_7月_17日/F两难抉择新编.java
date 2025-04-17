package 牛客.河南农业大学_7月_17日;

import java.util.Scanner;

// 异或，暴力模拟：先将数列里所有数都进行异或处理，然后暴力模拟1到n/i的所有数即可，最后比较操作1和操作2大小，输出最大值即可
// 牛客：https://ac.nowcoder.com/acm/contest/86639/F

public class F两难抉择新编 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n + 1];

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            sum ^= arr[i];
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n / i; j++) {
                result = Math.max(result, sum ^ arr[i] ^ (arr[i] + j));
                result = Math.max(result, sum ^ arr[i] ^ ((long) arr[i] * j));
            }
        }

        System.out.println(result);
    }
}

/*

5
5 3 4 1 2
29

 */