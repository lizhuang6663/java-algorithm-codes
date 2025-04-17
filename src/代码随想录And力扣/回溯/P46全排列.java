package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


// 回溯：全排列问题，使用了标记数组
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/permutations/description/

// dfs方法的一些特点：
// dfs需要一直递归到一个终止条件。
// 在使用路径数组path时我们可以发现，其实path数组就是一个栈的形式，每次都会有入栈和出栈。
// 递归当中其实就好比一个树，需要不断的剪枝和终止条件。
// 其实dfs掌握上面的核心特点，在做题的时候我们就能知道大概的思路。因为有些题就是在这个上面稍微做了一个简单的修改，我们只需要掌握核心科技，就不用担心不会做dfs类型的题啦。

public class P46全排列 {

    // 方法一：用 boolean[] 数组存某个位置是否可以用
    //创建返回的数组res和路径数组path
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    boolean[] used;
    public List<List<Integer>> permute1(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        used = new boolean[nums.length];

        permuteHelper(nums);
        return result;
    }

    public void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 防止重复的情况
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            used[i] = false;
            path.removeLast();
        }

    }





    // 方法二：通过判断path中是否存在数字，排除已经选择的数字
    List<List<Integer>> result2 = new ArrayList<List<Integer>>();
    List<Integer> path2 = new ArrayList<Integer>();

    public List<List<Integer>> permute2(int[] nums) {
        //获取nums数组的长度，作为下面的终止条件。
        int n = nums.length;

        dfs(n, nums);

        return result2;
    }

    //创建一个dfs方法，用来查找不同种的排列顺序。
    public void dfs(int n, int[] nums) {
        if (path2.size() == n) {        //设置终止条件
            //如果达到终止条件就证明path已经得到了一种排序，并把这个添加到res数组里面。
            result2.add(new ArrayList<Integer>(path2));

            //终止继续递归！
            return;
        }

        //设置for循环来对nums数组得遍历和让path数组对其进行添加新的不同元素
        for (int i = 0; i < n; i++) {
            //设置一个判断，path路径中已经包含了这个元素，则需要跳过此次循环，如果没有则继续向下递归。
            // 剪枝操作
            if (path2.contains(nums[i])) {
                continue;
            }

            path2.add(nums[i]);//为path数组提添加新的元素。

            dfs(n, nums); //继续递归

            // 回溯
            //先删除最后一个元素，重新继续组合新的排序。
            path2.remove(path2.size() - 1);
        }

    }






    // 方法三：从哪个位置开始
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


}
