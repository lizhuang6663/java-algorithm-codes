package 代码随想录And力扣.贪心;

import java.util.Arrays;

// 贪心:重叠区间问题
// 力扣：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class P452用最少数量的箭引爆气球 {
    // 不正确，比如：{1,10},{5,6},{10,11} 需要三个箭，但是按照下面的代码只需要1个箭
//    public  int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];
//            return a[0] - b[0];
//        });
//
////        Arrays.sort(points, (a, b) -> {
////            if (a[0] == b[0]) return a[1] - b[1];
////            return (a[1] - a[0]) - (b[1] - b[0]);
////        });
//
//        int ans = 0;
//        List<int[]> list = new ArrayList<>();
//
//        for (int[] point : points) {
//            int j = 0;
//            for (; j < list.size(); j++) {
//                // 可以被射到
//                if ((point[0] >= list.get(j)[0] && point[0] <= list.get(j)[1]) || (point[1] >= list.get(j)[0] && point[1] <= list.get(j)[1])) {
//                    break;
//                }
//            }
//
//            // 没有被射
//            if (j == list.size()) {
//                ans++;
//                list.add(point);
//            }
//        }
//
//        return ans;
//    }


    // 贪心：
    // 局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
    // 如果气球重叠了，重叠气球中右边边界的最小值 之前的区间一定需要一个弓箭。
    public int findMinArrowShots(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
        // 这样排序的话，在遇到：[[-2147483646,-2147483645],[2147483646,2147483647]] int类型会超界，排序结果会错误，只能用下面的排序方法
//        Arrays.sort(points, (a, b)->{
//            return a[0] - b[0];
//        });
        Arrays.sort(points, (a, b) -> {
            if (a[0] > b[0]) return 1;
            return -1;
        });
        // 或者：
//        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // 使用Integer内置比较方法，不会溢出

        int ans = 1; // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            // 1个弓箭可以穿过去（气球i和气球i-1挨着）
            if (points[i][0] <= points[i - 1][1]) {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else { // 超出范围了
                ans++;
            }
        }
        return ans;
    }

}
