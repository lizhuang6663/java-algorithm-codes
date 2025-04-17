package 代码随想录And力扣.stack_queue;

import java.util.Deque;
import java.util.LinkedList;


//栈与队列7:滑动窗口最大值
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
//你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回滑动窗口中的最大值。



//解法一
//自定义数组
class MyQueue2 {
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        //存放结果元素的数组
        int[] res = new int[nums.length - k + 1];
        int num = 0;

        //自定义队列
        MyQueue2 myQueue2 = new MyQueue2();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue2.add(nums[i]);
        }
        res[num++] = myQueue2.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue2.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue2.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue2.peek();
        }
        return res;
    }
}