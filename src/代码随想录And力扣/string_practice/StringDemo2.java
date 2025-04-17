package 代码随想录And力扣.string_practice;


//字符串2:反转字符串II
//给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
//如果剩余字符少于 k 个，则将剩余字符全部反转。
//如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

//示例:
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"

//题目的意思概括为：每隔2k个反转前k个；如果剩余k到2k个，反转前k个；尾数不够k个时候全部反转
public class StringDemo2 {

    //方法一：
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            //这里是判断尾数够不够k个 来取决end指针的位置
            int end = Math.min(chars.length - 1, i + k - 1);
            reverseChars(chars, start, end);
        }
        return new String(chars);
    }


    //方法二：容易理解，和方法一差不多
    public String reverseStr3(String s, int k) {
        char[] chars = s.toCharArray();

        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < chars.length; i += 2 * k) {

            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= chars.length) {//注意是 <=
                reverseChars(chars, i, i + k - 1);
            } else {
                // 3. 剩余字符少于 k 个，则将剩余字符全部反转
                reverseChars(chars, i, chars.length - 1);
            }
        }
        return new String(chars);
    }


    // 定义翻转函数
    public void reverseChars(char[] chars, int start, int end) {
        while (start < end) {
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }

}
