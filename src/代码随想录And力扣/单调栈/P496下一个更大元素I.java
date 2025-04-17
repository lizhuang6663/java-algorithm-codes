package 代码随想录And力扣.单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// 单调栈（栈尾到栈顶递减）
// 力扣：https://leetcode.cn/problems/next-greater-element-i/description/

public class P496下一个更大元素I {
    // 方法一：暴力
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length];
//
//        for (int i = 0; i < nums1.length; i++) {
//            int j;
//            for (j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    break;
//                }
//            }
//
//            boolean b = false;
//            for (int k = j + 1; k < nums2.length; k++) {
//                if (nums2[k] > nums1[i]) {
//                    res[i] = nums2[k];
//                    b = true;
//                    break;
//                }
//            }
//
//            if (!b)  res[i] = -1;
//
//        }
//        return res;
//    }

    // 或者：
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] arr = new int[nums1.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = -1;
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            boolean b = false;
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    b = true;
//                }
//                if (b && nums2[j] > nums1[i]) {
//                    arr[i] = nums2[j];
//                    break;
//                }
//            }
//        }
//
//        return arr;
//    }


    // 方法二：单调栈1（官方题解，栈里面存值的大小）
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> stack = new Stack<>();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        // 倒着遍历nums2
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            int n = nums2[i];
//            while (!stack.isEmpty() && n >= stack.peek()) {
//                // 删除小的元素
//                stack.pop();
//            }
//            // 栈头到栈尾是递增的，这时候 nums2[i] 的下一个更大的元素就是栈的栈头元素了
//            // 把数据存到map里面
//            map.put(n, stack.isEmpty() ? -1 : stack.peek());
//            stack.add(n);
//        }
//
//        int[] res = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            res[i] = map.get(nums1[i]);
//        }
//
//        return res;
//    }


    // 单调栈2（代码随想录，栈里面存索引）
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        stack.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        Integer index = map.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.add(i);
            }
        }

        return res;
    }

}
