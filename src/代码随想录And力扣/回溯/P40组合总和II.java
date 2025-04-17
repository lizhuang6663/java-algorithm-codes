package 代码随想录And力扣.回溯;

import java.util.*;

// 回溯：组合问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/combination-sum-ii/description/
// 每个元素在每个组合中只能使用一次 。
// 本题的难点在于区别2中：集合（数组candidates）有重复元素，但还不能有重复的组合。
// 比如说 [1,1,2,2]，这时候数组里面有重复元素，我们要选择和为3的组合，这时候会出现两次[1,2]，我们要去重（可以使用标记数组，也可以不使用）

public class P40组合总和II {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] isUsed; // 为了去重(加标志数组，用来辅助判断同层节点是否已经遍历

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        isUsed = new boolean[candidates.length];

        Arrays.sort(candidates); // 为了将重复的数字都放到一起，所以先进行排序

        backTracking(candidates, target, 0);

        return result;
    }


    /**
     * @param nums
     * @param need       还需要的值大小
     * @param startIndex 开始的索引
     */
    // 方法一：使用标记数组 isUsed
    public void backTracking(int[] nums, int need, int startIndex) {
//        if (need < 0) return;  // 剪枝操作在下面，如果在这里进行 剪枝操作，感觉占用内存可能会大一点

//        if (need == 0) {
//            // 判断是否重复，如果选用这种方法会超时，所以我们用 isUsed 数组
//            for (int i = 0; i < result.size(); i++) {
//                if (path.equals(result.get(i))) return;
//            }
//            result.add(new ArrayList<>(path));
//            return;
//        }

        if (need == 0) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = startIndex; i < nums.length; i++) {
            // 剪枝操作，直接退出
            if (need - nums[i] < 0) {
                return;
            }

            // 去重
            // 排序后，在这个组合中如果这个元素和上一个元素相同，而且上一个元素没有使用过，就跳过这次循环(上一个元素在之前的组合中已经用过了，所以在这次循环中会出现重复的情况)
            if (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            isUsed[i] = true;

            backTracking(nums, need - nums[i], i + 1);

            isUsed[i] = false;
            path.removeLast();
        }
    }



    // 方法二：不使用标记数组 isUsed
    public void backTracking2(int[] nums, int need, int startIndex) {
        if (need == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 剪枝操作，直接退出
            if (need - nums[i] < 0) {
                return;
            }

            // 去重
            if (i > startIndex && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);
            isUsed[i] = true;

            backTracking2(nums, need - nums[i], i + 1);

            isUsed[i] = false;
            path.removeLast();
        }


    }

}
