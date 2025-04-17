package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 回溯：切割问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/palindrome-partitioning/description/
// 将 s 分割成一些子串，使每个子串都是回文串

// 难点在于每一次回溯，应该截取多长的子串（每次截取 [startIndex, i]，如果是回文串，就进行下一次递归，如果不是就continue，这样下一次循环的i就会变大一个）
// 在递归循环中如何截取子串
// 如何模拟那些切割线
// 切割问题中递归如何终止

public class P131分割回文串 {

    // 方法一：回溯
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {

        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            // 截取 [startIndex, i] 的字符串
            String temp = s.substring(startIndex, i + 1);

            // 不是回文字符串，跳过这次循环，i++
            if (!judgeString(temp)) {
                continue;
            }
            path.add(temp);

            backTracking(s, i + 1);

            path.removeLast();
        }
    }

    public boolean judgeString(String str) {

        for (int start = 0, end = str.length() - 1; start <= end; start++, end--) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
        }

        return true;
    }


//    // 方法二：回溯 + 记忆搜索法
//    int[][] memory;
//    List<List<String>> result = new ArrayList<>();
//    LinkedList<String> path = new LinkedList<>();
//
//    public List<List<String>> partition(String s) {
//        memory = new int[s.length()][s.length()];
//
//        if (s.equals("")) return new ArrayList<>();
//
//        dfs(s, 0);
//
//        return result;
//    }
//
//    public void dfs(String s, int startIndex) {
//        if (startIndex == s.length()) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = startIndex; i < s.length(); i++) {
//
//            // 如果是回文字符串
//            if (isPalindrome(s, startIndex, i) == 1) {
//
//                path.add(s.substring(startIndex, i + 1));
//
//                dfs(s, i + 1);
//
//                path.removeLast();
//            }
//
//        }
//    }
//
//
//    // 判断是否是回文串
//    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串，节省时间
//    public int isPalindrome(String s, int i, int j) {
//        if (memory[i][j] != 0) {
//            return memory[i][j];
//        }
//
//        if (i >= j) {
//            memory[i][j] = 1;
//        } else if (s.charAt(i) == s.charAt(j)) {
//            memory[i][j] = isPalindrome(s, i + 1, j - 1);
//        } else {
//            memory[i][j] = -1;
//        }
//
//        return memory[i][j];
//    }




    // 方法三：回溯 + 动态规划预处理
//    List<List<String>> result = new ArrayList<>();
//    LinkedList<String> path = new LinkedList<>();
//    boolean[][] isPalindrome; // 判断子字符串是否为回文字符串
//
//    public List<List<String>> partition(String s) {
//
//        int n = s.length();
//        isPalindrome = new boolean[n][n];
//
//        // 先全部填充为true，为true时是回文字符串
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(isPalindrome[i], true);
//        }
//
//        // 不是太理解，不知道为什么这样可以
//        // 预处理：判断是否为回文串，到时候判断某个子字符串是否为回文串是判断时间为O(1)
//        for (int i = n - 1; i >= 0; --i) {
//            for (int j = i + 1; j < n; ++j) {
//                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
//            }
//        }
//
//        backTracking(s, 0);
//
//        return result;
//    }
//
//    public void backTracking(String s, int startIndex) {
//        if (startIndex == s.length()) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = startIndex; i < s.length(); i++) {
//
//            // true为回文字符串
//            if (isPalindrome[startIndex][i]) {
//                path.add( s.substring(startIndex, i + 1));
//
//                backTracking(s, i + 1);
//
//                path.removeLast();
//            }
//
//        }
//    }

}
