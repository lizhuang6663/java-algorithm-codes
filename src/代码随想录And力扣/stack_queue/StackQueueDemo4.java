package 代码随想录And力扣.stack_queue;

import java.util.Stack;

//栈与队列4:有效的括号
//括号匹配是使用栈解决的经典问题。
//在写代码的过程中，要求括号的顺序是一样的，有左括号，相应的位置必须要有右括号。
//编译器在 词法分析的过程中处理括号、花括号等这个符号的逻辑，也是使用了栈这种数据结构。
//栈结构的特殊性，非常适合做对称匹配类的题目。

//有三种情况：1.左边的括号多了，右边的括号不够，栈中的左括号多了；2.括号是偶数，但是类型不对应；3.左边的括号少了，右边的括号多了，栈中已经没有左括号了
public class StackQueueDemo4 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        char ch ;
        for (int i = 0;i<s.length();i++) {
            ch = s.charAt(i);

            //把左括号全部变成右括号加入到栈中，如果不是左括号，就和栈中的右括号比较，看看是否相同，如果相同就把这个右括号从栈中删除
            if (ch == '(') {
                stack.push(')');
            }else if (ch == '{') {
                stack.push('}');
            }else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {//左括号不够，右括号多了，栈中已经没有左括号了；左括号和右括号类型不匹配
                return false;
            }else {
                stack.pop();
            }
        }
        //循环结束后，如果左括号多出来了，就返回false
        return stack.isEmpty();
    }
}


//else if 语句稍微有一点不同的写法：
/*

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 !=0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            }else if (ch == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty()) {

                    if (ch == stack.peek()) {
                        stack.pop();
                    }else {
                        return false;//左右括号类型不匹配：如果ch != stack.peek() 说明左括号和右括号不匹配，返回false
                    }

                }else {
                    return false;//右括号多了：这时循环还没有结束，可是已经为空了，返回false
                }
            }

        }
        //左括号多了：返回false，如果为空，返回true
        return stack.isEmpty();
    }
}


 */
