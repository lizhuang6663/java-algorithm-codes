package 代码随想录And力扣.回溯;

import java.util.*;


// 回溯：子集类问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/non-decreasing-subsequences/description/
// 在 90.子集II 中我们是通过排序，再加一个标记数组来达到去重的目的。而本题求自增子序列，是不能对原数组进行排序的，排完序的数组都是自增子序列了，所以不能使用之前的去重逻辑！
// 难点：怎么去重，这题和之前的题目去重的方法不一样

public class P491非递减子序列 {

    // 方法一：使用Set（注意Set声明的位置，之前的去重都是先排序，然后用一个全局变量来控制整条数据；这题是不能排序，所以只能用一个局部变量来控制局部）
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backTranking(nums, 0);

        return result;
    }

    public void backTranking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
            // 这里不要return
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {

            // 必须是非递减；去重
            if ((path.size() > 0 && nums[i] < path.getLast()) || set.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            set.add(nums[i]);

            backTranking(nums, i + 1);

            path.removeLast();
            // 这里不用改变set里面的值，因为每一个递归都会创建一个新的set，互不影响
        }

    }


    // 方法二：使用数组去重
//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//
//        backtracking(nums, 0);
//
//        return result;
//    }
//
//    private void backtracking(int[] nums, int start) {
//        if (path.size() > 1) {
//            result.add(new ArrayList<>(path));
//        }
//
//        int[] used = new int[201];
//        for (int i = start; i < nums.length; i++) {
//            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (used[nums[i] + 100] == 1)) {
//                continue;
//            }
//
//            used[nums[i] + 100] = 1;
//            path.add(nums[i]);
//
//            backtracking(nums, i + 1);
//
//            path.remove(path.size() - 1);
//        }
//    }

}
