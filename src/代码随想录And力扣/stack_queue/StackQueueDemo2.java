package 代码随想录And力扣.stack_queue;

import java.util.Stack;

//栈与队列2:用栈实现队列
//push(x) -- 将一个元素放入队列的尾部。
//pop() -- 从队列首部移除元素。
//peek() -- 返回队列首部的元素。
//empty() -- 返回队列是否为空。
class MyQueue {
    Stack<Integer> stackIn ;
    Stack<Integer> stackOut ;
    public MyQueue() {
        stackIn = new Stack<>();//进栈
        stackOut = new Stack<>();//出栈
    }

    //在队列尾部增加元素
    public void push(int x) {
        stackIn.push(x);
    }

    //删除队列头部的元素
    public int pop() {
        dumpstackIn();//
        return stackOut.pop();//删除出栈顶端的元素
    }

    //获取队列头部的元素
    public int peek() {
        dumpstackIn();
        return stackOut.peek();//获取出栈顶端的元素
    }

    //返回队列是否为空。
    public boolean empty() {
        return (stackIn.isEmpty() && stackOut.isEmpty());
    }

    //如果出栈 为空了，我们把入栈的数据添加到出栈中(出栈为空时，把入栈中的屁股添加到出栈的头部，然后把入栈的屁股删除，一直循环这种操作，直到入栈没有数据)
    private void dumpstackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());//这里的pop()方法是Stack对象的方法：删除栈顶部的对象（也就是入栈的屁股），pop()会返回删除的元素
        }
    }
}


