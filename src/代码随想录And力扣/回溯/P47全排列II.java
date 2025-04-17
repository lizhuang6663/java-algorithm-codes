package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 回溯：全排列问题，使用了标记数组
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/permutations-ii/description/

public class P47全排列II {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] isUsed;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isUsed = new boolean[nums.length];
        Arrays.sort(nums);

        backStacking(nums);

        return result;
    }

    public void backStacking(int[] nums) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 为true说明这个数已经使用过了
            if (isUsed[i]) {
                continue;
            }

            // 为了去重：如[1,1,2]，这里去重是为了防止最后的结果出现 两次[1,1,2]
            // isUsed[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // isUsed[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 树枝去重和树层去重详情看代码随想录 中的全排列II
            // 树层去重，效率更高
            if (i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;

            isUsed[i] = true;
            path.add(nums[i]);

            backStacking(nums);

            isUsed[i] = false;
            path.removeLast();
        }

    }


}
