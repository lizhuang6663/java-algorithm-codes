package 代码随想录And力扣.stack_queue;

import java.util.Stack;

//栈与队列5:删除字符串中的所有相邻重复项

//实现函数递归调用就需要栈，但不是每种编程语言都支持递归，例如：递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中，然后递归返回的时候，从栈顶弹出上一次递归的各项参数，所以这就是递归为什么可以返回上一层位置的原因。
//相信大家应该遇到过一种错误就是栈溢出，系统输出的异常是Segmentation fault（当然不是所有的Segmentation fault 都是栈溢出导致的） ，如果你使用了递归，就要想一想是不是无限递归了，那么系统调用栈就会溢出。
//而且在企业项目开发中，尽量不要使用递归！在项目比较大的时候，由于参数多，全局变量等等，使用递归很容易判断不充分return的条件，非常容易无限递归（或者递归层级过深），造成栈溢出错误（这种问题还不好排查！）

public class StackQueueDemo5 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("abbaca"));
    }

    //方法一：用栈来做
    public static String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    //方法二：拿字符串直接作为栈，省去了栈还要转为字符串的操作。
    public static String removeDuplicates2(String s) {
        StringBuffer res = new StringBuffer();
        //res当前的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }


    //方法三：用双指针
    public static String removeDuplicates3(String s) {
        char[] ch = s.toCharArray();
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }

}
