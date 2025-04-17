package 校队.校队题库.不太理解和做错的;

import 校队.校队题库.Read;


// 时间超限，回答错误：Wrong Answer 0读取到 -180053，应为 -181624。
public class P1013滑动窗口前缀和结合 {
    public static void main(String[] args) {
        Read scanner = new Read(System.in);
        int n = scanner.nextInt();
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scanner.nextInt();
        }

        // 前缀和
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int shang = 0, xia = 0, heng = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1 - (k1 - 1); i++) {
            shang = prefixSum[k1 + i - 1] - prefixSum[i - 1];

            for (int j = k1 + i - 1; j < n + 1 - (k2 - 1); j++) {

                heng = prefixSum[k2 + j - 1] - prefixSum[j - 1];

                for (int k = k2 + j - 1; k < n + 1 - (k1 - 1); k++) {
                    xia = prefixSum[k1 + k - 1] - prefixSum[k - 1];

                    max = Math.max(max, shang + xia - heng);
                }

            }

        }
        System.out.println(max);
    }
}


/*
解法：
由题意可得，区间顺序固定，所以我们可以先预处理出前缀和和后缀和，然后依次枚举前缀和后缀到达第 i 个点时长度为 k1 的区间的最大值，
再通过枚举每个长度为 k2 的区间，取该区间两边长度为 k1 的最大值。枚举得到每种情况，再贪心取较大值，最终可以得到答案。

 */

/*

10 2 3
1 5 6 2 4 5 6 7 8 9
11 - 11 + 17

 */
