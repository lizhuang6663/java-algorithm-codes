package 代码随想录And力扣.力扣.数学知识;

// 整数反转：数学
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/reverse-integer/description/
public class P7整数反转 {

    // 方法一：使用 StringBuilder类 内置的字符串反转方法
    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();

        if (x >= 0) {
            sb = new StringBuilder(String.valueOf(x));
            sb = sb.reverse();
        } else {
            sb = new StringBuilder(String.valueOf(-1 * x));
            sb = new StringBuilder("-" + sb.reverse());
        }

        int result = 0;
        // 按照题目中的要求：如果反转后整数超过 32 位的有符号整数的范围，就返回 0。如果将sb转换为int类型的数字出错了，就说明超出了范围
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            result = 0;
        }

        return result;
    }


    // 方法二：数学知识反转
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {

            // 题目需要判断反转后的数字是否超过 32 位有符号整数的范围
            // 在给rev * 10 之前，先判断是否可能会超出范围
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;


            // 或者不判断，如果rev超出了范围，捕获错误但是不处理，直接返回0
//            try {
//                int digit = x % 10;
//                x /= 10;
//                rev = rev * 10 + digit;
//            } catch (NumberFormatException e) {
//                return 0;
//            }

        }
        return rev;
    }

}
