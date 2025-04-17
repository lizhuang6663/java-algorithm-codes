package 代码随想录And力扣.单调栈;

import java.util.Stack;


// 单调栈：栈尾到栈顶递减(栈里面存索引)
// 力扣：https://leetcode.cn/problems/daily-temperatures/

// 单调栈的本质是空间换时间，因为在遍历的过程中需要用一个栈来记录右边第一个比当前元素高的元素，优点是整个数组只需要遍历一次。
//在使用单调栈的时候首先要明确如下几点：
//单调栈里存放的元素是什么？单调栈里只需要存放元素的下标i就可以了，如果需要使用对应的元素，直接T[i]就可以获取。
//单调栈里元素是递增呢？ 还是递减呢？如果求一个元素右边第一个更大元素，单调栈就是递增的，如果求一个元素右边第一个更小元素，单调栈就是递减的。


// 栈头到栈底的顺序，要从小到大，也就是保持栈里的元素为递增顺序。只要保持递增，才能找到右边第一个比自己大的元素。（记住：是第一个）
// 递减栈就是求右边第一个比自己小的元素了。

public class P739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // 存下标
        int[] res = new int[temperatures.length];

        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            // 递增
            if (temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            }else {
                // 要新加的元素大于栈顶元素，这时要弹出元素了
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.peek(); // 索引为stack.peek()的元素后面的第一个更高温度的索引就是i了，距离就是 i - stack.peek()
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }

}
