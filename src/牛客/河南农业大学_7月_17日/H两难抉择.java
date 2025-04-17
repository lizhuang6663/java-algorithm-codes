package 牛客.河南农业大学_7月_17日;

import java.util.Scanner;

// 签到题

public class H两难抉择 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long arr[] = new long[n];
        long sum = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        sum = Math.max(sum - max + max * n, sum - max + max + n);
        System.out.println(sum);
    }
}

/*

1
1

2
1 1

 */