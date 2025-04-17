package 校队.Nu5月5日_力扣第396场周赛;

import java.util.HashMap;
import java.util.Map;

// 字符串，思维
// 力扣：https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/

public class B_100275K周期字符串需要的最少操作次数 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int maxNum = 0;

        // 把word字符串每k个一组分割放入map中
        for (int i = 0; i < word.length(); i += k) {
            int endIndex = Math.min(word.length(), i+k);
            // 不要这样写，这样写，当i+k>word.length()的时候会报错：temp = word.substring(i, i + k);

            String temp = word.substring(i, endIndex);

            map.put(temp, map.getOrDefault(temp, 0) + 1);

            // 找出子串出现次数最多的个数
            maxNum = Math.max(maxNum, map.get(temp));
        }

        return word.length() / k - maxNum;
    }

}
