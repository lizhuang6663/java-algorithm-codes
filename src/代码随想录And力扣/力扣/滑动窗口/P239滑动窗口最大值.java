package 代码随想录And力扣.力扣.滑动窗口;

import java.util.Deque;
import java.util.LinkedList;


public class P239滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        result[index++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            // 保证队列中最多有3个元素，最少有1个元素
            myQueue.poll(nums[i-k]); // 删除过期的元素
            myQueue.add(nums[i]);
            result[index++] = myQueue.peek();
        }

        return result;
    }

}


class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    // 非递增
    public void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    // 如果元素值和头部的元素值相同就删除头部元素
    public void poll(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.poll();
        }
    }

    // 获得头部元素的值
    public int peek() {
        return deque.peek();
    }

}

