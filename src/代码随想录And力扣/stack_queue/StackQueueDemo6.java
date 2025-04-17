package 代码随想录And力扣.stack_queue;


//栈与队列6:逆波兰表达式求值
//逆波兰表达式：是一种后缀表达式，所谓后缀就是指运算符写在后面
//平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 )
//该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * )

//逆波兰表达式主要有以下两个优点：
//去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
//适合用栈操作运算：遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中。
//逆波兰表达式相当于是二叉树中的后序遍历
//将中缀表达式，转化为后缀表达式之后，计算机可以利用栈来顺序处理，不需要考虑优先级了。也不用回退了， 所以后缀表达式对计算机来说是非常友好的。

import java.util.Stack;

public class StackQueueDemo6 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                //将靠近栈顶的两个元素取出，并相加，然后再返回到栈内
                stack.push( stack.pop() + stack.pop());
            }else if (s.equals("-")) {
                stack.push( -stack.pop() + stack.pop());
            }else if (s.equals("*")) {
                stack.push( stack.pop() * stack.pop());
            }else if (s.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
