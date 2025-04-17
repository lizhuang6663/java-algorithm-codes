package 青训营.豆包;

import java.util.HashMap;
import java.util.Map;

// 签到（这道题有问题）
public class 最少字符串操作次数 {
    public static int solution(String S) {
        // 统计每个字符的出现次数
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : S.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int operations = 0;
        // 遍历每个字符的出现次数
        for (int count : frequency.values()) {
            // 如果某个字符出现超过 1 次，需要操作
            if (count > 1) {
                // 计算成对删除的操作次数
                operations += count / 2;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        System.out.println(solution("abab") == 2); // Expected output: 2
        System.out.println(solution("aaaa") == 2); // Expected output: 2
        System.out.println(solution("abcabc") == 3); // Expected output: 3
        // 这道题有问题，结果应该是27
        System.out.println(solution("aabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz") == 27);
    }
}

