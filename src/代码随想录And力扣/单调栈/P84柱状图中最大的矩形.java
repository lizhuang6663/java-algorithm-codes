package 代码随想录And力扣.单调栈;

import java.util.Stack;


// 单调栈
// 力扣：https://leetcode.cn/problems/trapping-rain-water/description/

public class P84柱状图中最大的矩形 {
    // 方法一：暴力（预处理）
//    public int largestRectangleArea(int[] heights) {
//        int length = heights.length;
//        int[] minLeftIndex = new int [length];
//        int[] minRightIndex = new int [length];
//
//        // 记录左边第一个小于该柱子的下标
//        minLeftIndex[0] = -1 ;
//        for (int i = 1; i < length; i++) {
//            int t = i - 1;
//            // 找前一个，可以用debug运行看一看
//            while (t >= 0 && heights[t] >= heights[i]) t = minLeftIndex[t];
//            minLeftIndex[i] = t;
//        }
//
//        // 记录每个柱子右边第一个小于该柱子的下标
//        minRightIndex[length - 1] = length;
//        for (int i = length - 2; i >= 0; i--) {
//            int t = i + 1;
//            while(t < length && heights[t] >= heights[i]) t = minRightIndex[t];
//            minRightIndex[i] = t;
//        }
//
//        // 求和
//        int result = 0;
//        for (int i = 0; i < length; i++) {
//            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
//            result = Math.max(sum, result);
//        }
//        return result;
//    }


    // 方法二：单调栈
    int largestRectangleArea(int[] heights) {
        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop(); // 这个可以加，可以不加，效果一样，思路不同
                stack.push(i);
            } else {
                while (heights[i] < heights[stack.peek()]) { // 注意是while
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                stack.push(i);
            }
        }
        return result;
    }

    // 简练代码：
//    public int largestRectangleArea(int[] heights) {
//        int[] newHeight = new int[heights.length + 2];
//        System.arraycopy(heights, 0, newHeight, 1, heights.length);
//        newHeight[heights.length+1] = 0;
//        newHeight[0] = 0;
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//
//        int res = 0;
//        for (int i = 1; i < newHeight.length; i++) {
//            while (newHeight[i] < newHeight[stack.peek()]) {
//                int mid = stack.pop();
//                int w = i - stack.peek() - 1;
//                int h = newHeight[mid];
//                res = Math.max(res, w * h);
//            }
//            stack.push(i);
//        }
//        return res;
//    }

}
