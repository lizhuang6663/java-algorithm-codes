package 代码随想录And力扣.贪心;


// 贪心
// 力扣：https://leetcode.cn/problems/jump-game-ii/description/

public class P45跳跃游戏II {

    // 方法一：贪心
    // 局部最优：当前可移动距离尽可能多走，如果还没到终点，步数再加一。整体最优：一步尽可能多走，从而达到最少步数。
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }


    // 优化代码：
//    public int jump(int[] nums) {
//        int result = 0;
//        // 当前覆盖的最远距离下标
//        int end = 0;
//        // 下一步覆盖的最远距离下标
//        int maxPosition = 0;
//        for (int i = 0; i <= end && end < nums.length - 1; ++i) {
//            maxPosition = Math.max(maxPosition, i + nums[i]);
//            // 可达位置的改变次数就是跳跃次数
//            if (i == end) {
//                end = maxPosition;
//                result++;
//            }
//        }
//        return result;
//    }


    // 方法二：反向查找出发位置
//    public int jump(int[] nums) {
//        int position = nums.length - 1;
//        int steps = 0;
//        while (position > 0) {
//            for (int i = 0; i < position; i++) {
//                if (i + nums[i] >= position) {
//                    position = i;
//                    steps++;
//                    break;
//                }
//            }
//        }
//        return steps;
//    }



}
