package 代码随想录And力扣.贪心;

import java.util.Arrays;

// 贪心
// 力扣：https://leetcode.cn/problems/non-overlapping-intervals/description/
public class P435无重叠区间 {

    // 方法一：按照左边界排序，直接求需要删除的区间的最小值。按左边排序，不管右边顺序。相交的时候取最小的右边。
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int remove = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (pre > intervals[i][0]) {
                pre = Math.min(pre, intervals[i][1]);
                remove++;
            } else {
                pre = intervals[i][1];
            }
        }
        return remove;
    }

    // 方法二：根据右边边界排序，求出不需要删除的区间个数
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[1] - interval2[1];
//            }
//        });
//
//        int n = intervals.length;
//        int right = intervals[0][1];
//        int ans = 1;
//        for (int i = 1; i < n; ++i) {
//            if (intervals[i][0] >= right) {
//                ++ans;
//                right = intervals[i][1];
//            }
//        }
//        return n - ans;
//    }


}
