package 代码随想录And力扣.图论;

import java.util.HashSet;
import java.util.Set;

// 并查集
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/longest-consecutive-sequence/description/

public class P128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : nums) {
            // 减小不必要的查找（减小重复查找过的元素）
            // 定位到每个连续序列的起点，从起点开始遍历每个连续序列，从而获得长度。
            if (!set.contains(num - 1)) { // 如果set里面存在 num - 1，我们就可以跳过
                int curNum = num;
                int tempLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum++;
                    tempLen++;
                }

                result = Math.max(result, tempLen);
            }
        }

        return result;
    }

}
