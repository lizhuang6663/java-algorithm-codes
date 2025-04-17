package 代码随想录And力扣.单调栈;

import java.util.Arrays;
import java.util.Stack;

// 单调栈
// 力扣：https://leetcode.cn/problems/next-greater-element-ii/
public class P503下一个更大元素II {

    // 方法一：暴力
//    public int[] nextGreaterElements(int[] nums) {
//        int[] arr = new int[nums.length * 2];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = nums[i % nums.length];
//        }
//
//        int[] result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            boolean b = false;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (nums[i] < arr[j]) {
//                    result[i] = arr[j];
//                    b = true;
//                    break;
//                }
//            }
//
//            if (!b) result[i] = -1;
//        }
//        return result;
//    }


    // 方法二：单调栈
//    public int[] nextGreaterElements(int[] nums) {
//        int len = nums.length;
//        Stack<Integer> stack = new Stack<>();
//        int[] arr = new int[len];
//        Arrays.fill(arr, -1);
//        stack.add(0);
//        for (int i = 1; i < 2 * len; i++) {
//            if (nums[stack.peek()] >= nums[i % len]) {
//                stack.add(i % len);
//            } else {
//                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
//                    arr[stack.peek()] = nums[i % len];
//                    stack.pop();
//                }
//                stack.add(i % len);
//            }
//        }
//
//        return arr;
//    }

    // 或者
    public int[] nextGreaterElements(int[] nums) {
        //边界判断
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }

        int size = nums.length;
        int[] result = new int[size];//存放结果
        Arrays.fill(result, -1);//默认全部初始化为-1
        Stack<Integer> stack = new Stack<>();//栈中存放的是nums中的元素下标

        for (int i = 0; i < 2 * size; i++) {
            while (!stack.empty() && nums[i % size] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % size];//更新result
                stack.pop();//弹出栈顶
            }
            stack.push(i % size);
        }
        return result;
    }

}