package 代码随想录And力扣.贪心;


// 贪心
// 力扣：https://leetcode.cn/problems/gas-station/description/

public class P134加油站 {

    // 方法一：暴力两层for循环，时间超限
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            int now = 0;
//
//            int n = cost.length;
//            int j;
//            for (j = i; j < cost.length * 2; j++) {
//                if (now + gas[j % n] < cost[j % n]) break;
//                now = now + gas[j % n] - cost[j % n];
//            }
//
//            if (now >= 0 && j == cost.length * 2) return i;
//        }
//        return -1;
//    }

    // 或者：时间超限
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < cost.length; i++) {
//            int rest = gas[i] - cost[i]; // 记录剩余油量
//            int index = (i + 1) % cost.length;
//
//            while (rest > 0 && index != i) { // 模拟以i为起点行驶一圈（如果有rest==0，那么答案就不唯一了）
//                rest += gas[index] - cost[index];
//                index = (index + 1) % cost.length;
//            }
//            // 如果以i为起点跑一圈，剩余油量>=0，返回该起始位置
//            if (rest >= 0 && index == i) return i;
//        }
//        return -1;
//    }


    // 方法二：从全局角度选取最优解的模拟操作
    //直接从全局进行贪心选择，情况如下：
    //情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
    //情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
    //情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int sum = 0;
//        int min = 0;
//        for (int i = 0; i < gas.length; i++) {
//            sum += (gas[i] - cost[i]);
//            min = Math.min(sum, min);
//        }
//
//        if (sum < 0) return -1; // 情况一
//        if (min >= 0) return 0; // 情况二
//
//        for (int i = gas.length - 1; i > 0; i--) {
//            min += (gas[i] - cost[i]);
//            if (min >= 0) return i; // 情况三
//        }
//
//        return -1;
//    }



    // 方法三：贪心
    // 局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行。全局最优：找到可以跑一圈的起始位置。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
        }
        // 如果总消耗<0说明永远不可能走一圈
        if (totalSum < 0) return -1;

        int index = 0;
        int curSum = 0;
        // 不遍历到 gas.length*2 的原因是，上面判断的有 totalSum < 0，如果< 0说明永远不可能走一圈，如果>=0说明一定可以走一圈，所以不用遍历到 gas.length*2
        for (int i = 0; i < gas.length ; i++) {
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        return index;
    }


    // 优化：两个for循环可以合起来
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int totalSum = 0;
//        int index = 0;
//        int curSum = 0;
//
//        for (int i = 0; i < gas.length; i++) {
//            curSum += gas[i] - cost[i];
//            totalSum += gas[i] - cost[i];
//            if (curSum < 0) {
//                index = (i + 1) % gas.length;
//                curSum = 0;
//            }
//        }
//
//        if (totalSum < 0) return -1;
//        return index;
//    }


}