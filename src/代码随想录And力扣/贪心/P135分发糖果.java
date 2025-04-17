package 代码随想录And力扣.贪心;

import java.util.Arrays;

// 贪心
// 力扣；https://leetcode.cn/problems/candy/description/
public class P135分发糖果 {
    // 确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼。

    // 先确定右边评分大于左边的情况（也就是从前向后遍历）
    // 局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
    //如果ratings[i] > ratings[i - 1] 那么[i]的糖 一定要比[i - 1]的糖多一个，所以贪心：candyVec[i] = candyVec[i - 1] + 1

    // 再确定左孩子大于右孩子的情况（从后向前遍历）
    //遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？
    // 因为 rating[5]与rating[4]的比较 要利用上 rating[5]与rating[6]的比较结果，所以 要从后向前遍历。
    // 如果从前向后遍历，rating[5]与rating[4]的比较 就不能用上 rating[5]与rating[6]的比较结果了
    // 又要贪心了，局部最优：取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，保证第i个小孩的糖果数量既大于左边的也大于右边的。全局最优：相邻的孩子中，评分高的孩子获得更多的糖果。

    // 总之，比如说几个孩子，挑选中间的三个孩子：... 10，40，30 ...，评分为40的孩子的糖果既要比左边评分为10的孩子的糖果多，也要比评分为30的孩子的糖果多
    // 分两个阶段:
    // 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
    // 2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candyVec = new int[n];

        candyVec[0] = 1;
        // 从左到右，判断右孩子比左孩子评分高的情况
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candyVec[i] = candyVec[i - 1] + 1;
            } else {
                candyVec[i] = 1;
            }
        }

        // 从右到左，判断左孩子比右孩子评分高的情况
        for (int i = n - 2; i >= 0; i--) {
            // 从之前的 candyVec[i] 和 candyVec[i+1]+1 选一个最大的出来
            if (ratings[i + 1] < ratings[i]) candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
        }

        // 返回 candyVec 数组的总和
        return Arrays.stream(candyVec).sum();
    }


}
