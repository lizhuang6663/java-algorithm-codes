package 代码随想录And力扣.stack_queue;

import java.util.LinkedList;
import java.util.Queue;


//栈与队列3:用队列实现栈
//push(x) -- 元素 x 入栈
//pop() -- 移除栈顶元素
//top() -- 获取栈顶元素
//empty() -- 返回栈是否为空


class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();//删除队列的头元素
    }

    public int top() {
        //我们想要获得栈的顶部元素，也就是队列的末尾元素，先将该队列的末尾元素的前面的所有元素都删除，然后就可以使用队列的方法peek()获得该元素，但是我们还要把该元素重新恢复到原来的末尾
        rePosition();
        int result = queue.poll();//先删除该元素，会返回删除元素的值，可以省略掉peek()这一步
        queue.add(result);//再添加到这个元素原本的位置
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    //将我们想要获取，删除的元素移动到队列的头部
    public void rePosition() {
        int size = queue.size();

        while (size >= 2) {//留着最后一个元素不要删除
            queue.add(queue.poll());//删除我们想要操作的元素的前面的所有元素，并把删除的元素添加到队列的最后面
            size--;
        }
    }


}


