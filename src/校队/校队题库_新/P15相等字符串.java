package 校队.校队题库_新;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 前缀和
// 校队题库：http://154.37.212.21/p/P15

public class P15相等字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        scanner.close();

        int result = countEqual01Substrings( s);
        System.out.println(result);
    }

    // 前缀和转换：
    // 观察字符串 s，如果我们将 '0' 看成 -1，将 '1' 保持为 +1，那么我们寻找 0 和 1 数量相等的子串的问题就变成了找前缀和相同的子串问题。
    // 如果两个位置 i 和 j 的前缀和相等，即 prefix[i] == prefix[j]，那么从 i+1 到 j 的子串中 0 和 1 的数量是相等的。
    public static int countEqual01Substrings(String s) {
        // 使用 HashMap 来存储前缀和的出现次数（键表示前缀和的值，值表示该前缀和出现的次数）
        Map<Integer, Integer> prefixCount = new HashMap<>();
        // 初始时，前缀和 0 出现了一次（对应空前缀）（防止：输入2 10，但是输出0的情况）
        prefixCount.put(0, 1); // 值等于0出现了1次
        int prefixSum = 0;
        int result = 0;

        for (char ch : s.toCharArray()) {
            // 如果字符是 '0'，视为 -1；如果是 '1'，视为 +1
            if (ch == '0') {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }

            // 检查当前前缀和是否在 map 中
            if (prefixCount.containsKey(prefixSum)) {
                // 如果存在，则表示有与之相同前缀和的数量相等的子串
                result += prefixCount.get(prefixSum);
            }

            // 更新当前前缀和的计数
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}