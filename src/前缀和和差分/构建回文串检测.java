package 前缀和和差分;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//构建回文串检测
//代码随想录And力扣.力扣： https://leetcode.cn/problems/can-make-palindrome-from-substring/

// 前缀数组 + 位运算

public class 构建回文串检测 {

    //方法一：使用map超时
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            String str = s.substring(queries[i][0], queries[i][1] + 1);
            int count = 0;

            map.clear();

            // 把子序列中的每一个字母都放到map中，并计数
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            }

            // 遍历map，统计出现次数为奇数的字符有多少个
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) count++;
            }

            if (map.size() == 1) {
                list.add(true);
            } else { // 可以重新排列子串，并从中选择最多 k 项替换成任何小写英文字母。
                //子字符串长度为奇数
                if (str.length() % 2 != 0) {
                    list.add((count + 1) / 2 - 1 <= queries[i][2]);
                } else {
                    list.add((count + 1) / 2 <= queries[i][2]);
                }
            }
        }
        return list;
    }


    //方法二：前缀数组 + 位运算
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        // 前缀数组
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // 如果同一个字母出现了第二次，会把第一次的同一个字母覆盖掉
            count[i + 1] = count[i] ^ (1 << (s.charAt(i) - 'a'));
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1], k = queries[i][2];

            int bits = 0, x = count[r + 1] ^ count[l];//x就相当于截取的字符串

            // 统计1出现的次数（1的次数就是 子字符串中有多少个 字母出现的次数为奇数）
            while (x > 0) {
                x &= x - 1;
                bits++;
            }
            res.add(bits <= k * 2 + 1);
        }
        return res;
    }

}
