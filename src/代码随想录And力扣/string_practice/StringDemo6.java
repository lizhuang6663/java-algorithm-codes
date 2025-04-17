package 代码随想录And力扣.string_practice;


//实现 strStr() 函数。
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
//示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
//说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。


public class StringDemo6 {

    //方法一：暴力
    public static int strStr1(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;

        int len = needle.length();
        int end = haystack.length()-needle.length()+1;

        for (int i = 0; i < end; i++) {
            for (int j = i; j < end; j++) {
                if (haystack.substring(j, j+len).equals(needle)) {
                    return j;
                }
            }
        }
        return -1;
    }


    //方法二：使用 String、StringBuilder 的indexOf()方法
    public static int strStr2(String haystack, String needle) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(haystack);
        return stringBuilder.indexOf(needle);

        // 或者
        // return haystack.indexOf(needle);
    }




    //不会
    /**
     * 方法三：KMP算法(在一个串中查找是否出现过另一个串，这是KMP的看家本领)
     * KMP主要应用在字符串匹配上。
     * KMP的经典思想就是:当出现字符串不匹配时，可以记录一部分之前已经匹配的文本内容，利用这些信息避免从头再去做匹配。
     * next数组里的数字表示的是什么，为什么这么表示？
     */
    //前缀表（不减一）
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }




}
