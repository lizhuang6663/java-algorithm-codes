package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.List;


// 回溯：组合问题，n个数中选择k个数的组合问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/combinations/

// for 循环是横向遍历，递归是纵向遍历
public class P77组合 {
    // 定义两个全局变量，一个用来存放符合条件单一结果，一个用来存放符合条件结果的集合。
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    // 用来记录本层递归的中，集合从哪里开始遍历
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(n, k, 1);

        return res;
    }


    /**
     * @param n
     * @param k
     * @param startIndex for循环的开始位置
     */
    public void dfs(int n, int k, int startIndex) {
        if (path.size() == k) {
            // 注意这里：要new一个新的ArrayList，不要直接添加path，如果直接添加path，因为是传址的，后面会变空的
            res.add(new ArrayList<>(path));
            return;
        }

        // 优化前：
//        for (int i = startIndex; i <= n; i++) {
//            if (path.contains(i)) continue;
//
//            path.add(i);
//            dfs(n, k, i + 1); // 这里不能传 startIndex + 1
//
//            path.remove(path.size() - 1);
//        }



        // 剪枝优化：如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。

        // 剪枝操作优化：
        // 接下来看一下优化过程如下：
        //已经选择的元素个数：path.size();
        //还需要的元素个数为: k - path.size();
        //在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        //为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        //举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
        //从2开始搜索都是合理的，可以是组合[2, 3, 4]。
        //这里大家想不懂的话，建议也举一个例子，就知道是不是要+1了。

        // 一句话，这个剪枝优化是为了：
        // 如果n = 4，k = 4的话，那么第一层for循环的时候，从元素2开始的遍历都没有意义了。在第二层for循环，从元素3开始的遍历都没有意义了。
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            if (path.contains(i)) continue;

            path.add(i);
            dfs(n, k, i + 1); // 在这个题中,这里不能传 startIndex + 1

            path.remove(path.size() - 1);
        }

    }

}

