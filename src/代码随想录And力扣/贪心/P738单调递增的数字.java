package 代码随想录And力扣.贪心;

// 贪心
// 力扣：https://leetcode.cn/problems/monotone-increasing-digits/description/

public class P738单调递增的数字 {
    // 方法一：暴力，超时
//    public int monotoneIncreasingDigits(int n) {
//        while (!judge(n)) {
//            n--;
//        }
//        return n;
//    }
//
//    public boolean judge(int n) {
//        int max = 10;
//        while (n > 0) {
//            int t = n % 10;
//            if (max >= t) max = t;
//            else return false;
//            n /= 10;
//        }
//        return true;
//    }


    // 方法二：贪心
    // 比如：98，一旦出现strNum[i - 1] > strNum[i]的情况（非单调递增），首先想让strNum[i - 1]--，
    // 然后strNum[i]给为9，这样这个整数就是89，即小于98的最大的单调递增整数。
    // 需要从后向前遍历，用一个flag来标记从哪里开始赋值9。
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        int start = chars.length;
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                start = i;
                chars[i - 1]--;
            }
        }

        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }


}
