package 校队.Codeforces.Num4月27日_2023ICPC江西省大赛_正式比赛;

import 校队.Codeforces.Read;

// 错误，不会
public class BWonderfulArray {
    public static void main(String[] args) throws Exception {
        Read scanner = new Read();
        int k = scanner.nextInt();

        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();

        int[] b = new int[n + 1];
        b[0] = x;
        for (int i = 1; i < n + 1; i++) {
            b[i] = b[i - 1] + a[(i - 1) % k];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] % m <= b[i + 1] % m) ans++;
        }
        System.out.println(ans);
    }
}
