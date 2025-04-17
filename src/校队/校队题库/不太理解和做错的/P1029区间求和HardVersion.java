package 校队.校队题库.不太理解和做错的;

import 校队.校队题库.Read;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 时间超限
// 前缀和
public class P1029区间求和HardVersion {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        Read scanner = new Read(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scanner.nextInt();
        }

        long[] prefixSum = new long[n + 1]; // 前缀和
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = (arr[i] + prefixSum[i - 1]) % MOD;
        }

        long result = 0; // 总和
        for (int l = 0; l < n + 1; l++) {
            for (int r = l; r < n + 1; r++) {
                result += prefixSum[r] - prefixSum[l];
                if (result >= MOD) {
                    result %= MOD;
                }

            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
