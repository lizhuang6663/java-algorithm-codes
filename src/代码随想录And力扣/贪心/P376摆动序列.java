package 代码随想录And力扣.贪心;


// 贪心，动态规划
// 力扣：https://leetcode.cn/problems/wiggle-subsequence/

//局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
//整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。

//实际操作上，其实连删除的操作都不用做，因为题目要求的是最长摆动子序列的长度，所以只需要统计数组的峰值数量就可以了（相当于是删除单一坡度上的节点，然后统计长度）
//这就是贪心所贪的地方，让峰值尽可能的保持峰值，然后删除单一坡度上的节点

//需要考虑三种情况：
//情况一：上下坡中有平坡
//情况二：数组首尾两端 ：如果只有两个不同的元素，那摆动序列也是 2。
//情况三：单调坡中有平坡

public class P376摆动序列 {
    //方法一：贪心
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;

        int count = 1;// 从一开始，我们默认最右边的是一个摆动序列

        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];

            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {//或者： if (curDiff * preDiff <= 0 && curDiff != 0)
                count++;
                preDiff = curDiff; //当坡度变化了，preDiff才跟着变化，preDiff = curDiff：写到if里面是为了处理单调有平坡的情况
            }
        }
        return count;
    }


    //方法二：动态规划
    //......

}
