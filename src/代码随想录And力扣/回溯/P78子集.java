package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// 回溯：子集问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/subsets/description/

public class P78子集 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backTracking(nums, 0);

        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);

            backTracking(nums, i+1);

            path.removeLast();
        }
    }


}