package 代码随想录And力扣.回溯;

import java.util.*;

// 回溯：组合问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/combination-sum/description/

public class P39组合总和 {
    public static void main(String[] args) {
        List<List<Integer>> r = combinationSum(new int[]{7, 3, 2}, 18);
//        List<List<Integer>> r = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < r.get(i).size(); j++) {
                System.out.print(r.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        backTracking(candidates, target, 0);

        return result;
    }

    /**
     *
     * @param nums
     * @param need 还需要的值大小
     * @param startIndex 开始的索引
     */
    public static void backTracking(int[] nums, int need, int startIndex) {
        if (need < 0) return;

        if (need == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);

            // 注意传递的startIndex参数：从当前位置开始
            backTracking(nums, need - nums[i], i);

            path.removeLast();
        }
    }

}