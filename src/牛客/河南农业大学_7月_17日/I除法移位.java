package 牛客.河南农业大学_7月_17日;

import java.util.Scanner;

// 数组的索引细节处理
// 牛客：https://ac.nowcoder.com/acm/contest/86639/I

public class I除法移位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 应该循环的次数
        int minNum = Math.min(n, t);

        // 结果值
        int result = 0;

        // 可以获得的最大除数
        int max = arr[0];

        int index = n - 1;
        for (int i = 0; i < minNum; i++) {
            if (index == n - 1 && arr[n - 1] > arr[0]) {
                max = arr[index];
                result = n - index;
            } else if (arr[index] > max) {
                max = arr[index];
                result = n - index;
            }
            index--;
        }

        System.out.println(result);
    }
}

/*

5 10
5 3 4 1 2
0

5 10
1 3 5 2 4
3

2 1
1 3
1


 */