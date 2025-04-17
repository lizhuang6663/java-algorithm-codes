package 代码随想录And力扣.贪心;

import java.util.ArrayList;
import java.util.List;

// 贪心
// 力扣：https://leetcode.cn/problems/partition-labels/description/
public class P763划分字母区间 {
    // 方法一：暴力dfs回溯
    // ...


    // 方法二：
    // 在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了。此时前面出现过所有字母，最远也就到这个边界了。
    //可以分为如下两步：
    //统计每一个字符最后出现的位置
    //从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();

        // 统计字符串中所有字符的结束位置
        int[] edges = new int[26];
        for (int i = 0; i < chars.length; i++) {
            edges[chars[i] - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0; // 记录每一段子字符串的开始
        int end = 0; // 记录每一段子字符串的终点
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, edges[chars[i] - 'a']);

            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

}
