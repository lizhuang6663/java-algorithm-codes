package 代码随想录And力扣.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 贪心
// 力扣：https://leetcode.cn/problems/merge-intervals/description/

public class P56合并区间 {
    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];
//            return a[0] - b[0];
//        });
        // 也可以只排左边界，不管右边界
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {   // 如果左边界大于最大右边界
                // 加入区间 并且更新 start 和 end
                list.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            } else { // 更新最大右边界
                end = Math.max(end, intervals[i][1]);
            }
        }

        // 不要漏了最后一个区间
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }


    // 或者：力扣官方题解
//    public int[][] merge(int[][] intervals) {
//        if (intervals.length == 0) {
//            return new int[0][2];
//        }
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
//        List<int[]> merged = new ArrayList<int[]>();
//        for (
//                int i = 0;
//                i < intervals.length; ++i) {
//            int L = intervals[i][0], R = intervals[i][1];
//            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                merged.add(new int[]{L, R});
//            } else {
//                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }

    // 或者：
//    public int[][] merge(int[][] intervals) {
//        LinkedList<int[]> res = new LinkedList<>();
//        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
//        res.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] <= res.getLast()[1]) {
//                int start = res.getLast()[0];
//                int end = Math.max(intervals[i][1], res.getLast()[1]);
//                res.removeLast();
//                res.add(new int[]{start, end});
//            }
//            else {
//                res.add(intervals[i]);
//            }
//        }
//        return res.toArray(new int[res.size()][]);
//    }

}
