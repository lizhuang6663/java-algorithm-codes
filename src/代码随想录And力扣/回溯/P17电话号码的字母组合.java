package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.List;


// 回溯：有点像子集问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/

public class P17电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> r = letterCombinations("23");

        for (int i = 0; i < r.size(); i++) {
            System.out.print(r.get(i) + " ");
        }

    }


    static List<String> result = new ArrayList<>();
    static StringBuilder path = new StringBuilder(""); // 比String 更改内容更快
    static String[][] strings = new String[][]{
            {""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
            {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    // 可以把二维数组替换为下面：
    // String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        backTracking(digits, 0);

        return result;
    }

    public static void backTracking(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 当前的数字
        int num = digits.charAt(startIndex) - '0';
        // 遍历当前数字对应的字母，并加到后面
        for (int j = 0; j < strings[num].length; j++) { // strings[num]：数字对应的字母数组
            path = path.append(strings[num][j]);

            backTracking(digits, startIndex + 1);

            path.deleteCharAt(path.length() - 1); // 删除最后一个字符
        }

    }


}
