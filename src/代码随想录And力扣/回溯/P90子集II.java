package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 回溯：子集问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/subsets-ii/description/

// 子集去重有两种写法：1.使用标记数组；2.不使用标记数组
// 全排列去重好像只能使用标记数组，因为全排列每一次的递归都是从0开始遍历的，而子集是从startIndex开始遍历的。

// 当然如果使用 Set 去重，照样可以完成。（用Set空间复杂度和时间复杂度都比较高）
// 用Set去重有一些陷阱：代码随想录And力扣： https://programmercarl.com/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E5%8E%BB%E9%87%8D%E9%97%AE%E9%A2%98%E7%9A%84%E5%8F%A6%E4%B8%80%E7%A7%8D%E5%86%99%E6%B3%95.html#_90-%E5%AD%90%E9%9B%86ii

public class P90子集II {
    // 方法一：使用标记数组
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    boolean[] isUsed;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //对数组nums先进行一个排序（因为这样更容易跳过相同的元素）
        Arrays.sort(nums);
        isUsed = new boolean[nums.length];

        dfs(nums, 0);

        return res;
    }


    public void dfs(int[] nums, int startIndex) {
        res.add(new ArrayList<Integer>(path));

        for (int i = startIndex; i < nums.length; i++) {

            // !isUsed[i-1] 退出的原因：前面已经使用过了这个字母了，当这次出现相同的字母时就可以跳过这次循环了，否则全部都是重复的结果
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            isUsed[i] = true;

            dfs(nums, i + 1);

            isUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }




    // 方法二：不使用标记数组（稍微有一点不太好理解）
//    List<List<Integer>> res = new ArrayList<List<Integer>>();
//    List<Integer> path = new ArrayList<Integer>();
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        //对数组nums先进行一个排序（因为这样更容易跳过相同的元素）
//        Arrays.sort(nums);
//
//        dfs(nums, 0);
//
//        return res;
//    }
//
//
//    public void dfs(int[] nums, int startIndex) {
//        //因为需要不同的子集，长度已经不再是添加的必要条件；
//        res.add(new ArrayList<Integer>(path));
//
//        //长度是一个终止条件！
//        if (path.size() == nums.length) {
//            return;
//        }
//
//        //每层递归需要缩减一个循环范围，避免重复。
//        for (int i = startIndex; i < nums.length; i++) {
//            // 用来判断相同元素，如果相同则跳过（这里主要是为了不出现[1,2] 和 [1,2] 两次的情况；
//            // 主要判断的时间是在 path.remove(path.size() - 1) 删除最后一个元素之后，为了不重复）
//            if (i > startIndex && nums[i - 1] == nums[i]) continue;
//
//            //入栈
//            path.add(nums[i]);
//
//            //继续递归
//            dfs(nums, i + 1);
//
//            //出栈
//            path.remove(path.size() - 1);
//        }
//    }

}