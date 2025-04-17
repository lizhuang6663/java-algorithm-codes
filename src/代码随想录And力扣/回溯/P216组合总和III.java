package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// 回溯：组合问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/combination-sum-iii/

public class P216组合总和III {
    public static void main(String[] args) {
        List<List<Integer>> s = combinationSum3(3, 9);

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                System.out.print(s.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {

        dfs(k, n, 1);

        return result;
    }


    /**
     * @param k     还需要的值的个数
     * @param need  还需要值的大小
     * @param start 从数字几开始
     */
    public static void dfs(int k, int need, int start) {
        // 如果还需要值的个数为0，而且还需要值的大小已经为0了，就添加
        if (k == 0 && need == 0) {
            result.add(new ArrayList<>(path));
            return;

        } else if (k == 0 || need < start) {
            // 如果需要的值的个数为0，就退出；
            // 剪枝操作：如果 还需要值的大小 已经小于 从数字几开始 的值了，就说明后面绝对不可能出现正确的结果了，就退出
            return;
        }


        for (int i = start; i <= 9; i++) {
            path.add(i);

            // 注意参数不要填成 k-- 或者 --k，这样等从dfs return 出来的时候，k的值已经被改变了
            dfs(k - 1, need - i, i + 1);

            path.removeLast();
        }


    }

}
