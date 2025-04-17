package 代码随想录And力扣.单调栈;

import java.util.Stack;

// 单调栈
// 力扣：https://leetcode.cn/problems/trapping-rain-water/description/

public class P42接雨水 {

    // 方法一：暴力（时间超限）
//    public int trap(int[] height) {
//        int sum = 0;
//        for (int i = 0; i < height.length; i++) {
//            // 第一个柱子和最后一个柱子不接雨水
//            if (i==0 || i== height.length - 1) continue;
//
//            int rHeight = height[i]; // 记录右边柱子的最高高度
//            int lHeight = height[i]; // 记录左边柱子的最高高度
//            for (int r = i+1; r < height.length; r++) {
//                if (height[r] > rHeight) rHeight = height[r];
//            }
//            for (int l = i-1; l >= 0; l--) {
//                if(height[l] > lHeight) lHeight = height[l];
//            }
//            int h = Math.min(lHeight, rHeight) - height[i];
//            if (h > 0) sum += h;
//        }
//        return sum;
//    }


    // 方法二：双指针（做预处理）（纵向计算）
//    public int trap(int[] height) {
//        int length = height.length;
//        if (length <= 2) return 0;
//        int[] maxLeft = new int[length];
//        int[] maxRight = new int[length];
//
//        // 记录每个柱子左边柱子最大高度
//        maxLeft[0] = height[0];
//        for (int i = 1; i < length; i++) maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
//
//        // 记录每个柱子右边柱子最大高度
//        maxRight[length - 1] = height[length - 1];
//        for (int i = length - 2; i >= 0; i--) maxRight[i] = Math.max(height[i], maxRight[i + 1]);
//
//        // 求和
//        int sum = 0;
//        for (int i = 0; i < length; i++) {
//            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
//            if (count > 0) sum += count;
//        }
//        return sum;
//    }

    // 双指针优化：
//    public int trap(int[] height) {
//        if (height.length <= 2) return 0;
//
//        int sum = 0;
//        // 从两边向中间寻找最值
//        int maxLeft = height[0], maxRight = height[height.length - 1];
//        int l = 1, r = height.length - 2;
//
//        while (l <= r) {
//            // 不确定上一轮是左边移动还是右边移动，所以两边都需更新最值
//            maxLeft = Math.max(maxLeft, height[l]);
//            maxRight = Math.max(maxRight, height[r]);
//            // 最值较小的一边所能装的水量已定，所以移动较小的一边。
//            if (maxLeft < maxRight) {
//                sum += maxLeft - height[l++];
//            } else {
//                sum += maxRight - height[r--];
//            }
//        }
//        return sum;
//    }


    // 方法三：单调栈（横向计算）
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        int result = 0;
        for (int i = 1; i < len; i++) {

            if (height[i] < height[stack.peek()]) {
                stack.add(i);
            } else if (height[i] == height[stack.peek()]) {
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop(); // 这行写不写无所谓，因为如果不删除的话h=0，对结果没有影响
                stack.add(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    // 如果还有元素（左边还有元素）
                    if (!stack.isEmpty()) {
                        // i 就相当于 right
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];// 可以存放水的高度
                        int w = i - stack.peek() - 1; // 可以存放水的宽度
                        if (h > 0) result += h * w;
                    }
                }
                stack.add(i);
            }
        }

        return result;
    }
}
