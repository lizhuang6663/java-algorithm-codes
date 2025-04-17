package 代码随想录And力扣.贪心;

// 贪心
// 力扣：https://leetcode.cn/problems/jump-game/description/

public class P55跳跃游戏 {
    // 方法一：暴力dfs（没试过不知道会不会时间超限）


    // 方法二：贪心
    // 思路：
    // 跳几步无所谓，关键在于可跳的覆盖范围！不一定非要明确一次究竟跳几步，每次取最大的跳跃步数，这个就是可以跳跃的覆盖范围。
    // i 每次移动只能在 cover 的范围内移动，每移动一个元素，cover 得到该元素数值（新的覆盖范围）的补充，让 i 继续移动下去。
    // 而 cover 每次只取 max(该元素数值补充后的范围, cover 本身范围)。如果 cover 大于等于了终点下标，直接 return true 就可以了。

    // 局部最优解：每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int cover = 0; // cover是下标的值，也代替覆盖的范围
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);//cover 代表着我们的最大移动的距离，cover是从0开始的

            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    // 或者：
//    public boolean canJump(int[] nums) {
//        int cover = nums[0];
//
//        for (int i = 1; i < nums.length ; i++) {
//            if (cover < i) return false; // 退出
//            if (cover >= nums.length-1) return true;
//
//            cover = Math.max(cover, i + nums[i]) ;
//        }
//
//        return  true;
//    }




    // 方法三：倒序
    // 从后往前遍历，设置目标tar，如果 Num19 位置能够到达 tar ，则把 tar 更新为 Num19 的位置
//    public boolean canJump(int[] nums) {
//        int tar = nums.length - 1; // 指的是下标
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (i + nums[i] >= tar) tar = i;
//        }
//
//        return tar == 0;
//    }


}
