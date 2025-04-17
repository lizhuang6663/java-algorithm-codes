package 代码随想录And力扣.额外题目;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 数组
// 力扣：https://leetcode.cn/problems/unique-number-of-occurrences/

public class 数组_P1207独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            } else {
                set.add(entry.getValue());
            }
        }
        return true;
    }

    // 或者
//    public boolean uniqueOccurrences(int[] arr) {
//        int[] count = new int[2001];
//        for (int i = 0; i < arr.length; i++) {
//            count[arr[i] + 1000]++; // 防止负数作为下标
//        }
//        boolean[] flag = new boolean[1002]; // 标记相同频率是否重复出现
//        for (int i = 0; i <= 2000; i++) {
//            if (count[i] > 0) {
//                if (flag[count[i]] == false) {
//                    flag[count[i]] = true;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}