package 校队.Nu5月5日_力扣第396场周赛;

/*

    第 396 场周赛:https://leetcode.cn/contest/weekly-contest-396/

 */

// 签到题
public class A_100284有效单词 {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        // 判断是否是字母或者数字
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))) return false;
        }

        boolean b1 = false, b2 = false;
        // 变小写
        word = word.toLowerCase();

        // 判断元音和辅音
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                b1 = true;
            } else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                b2 = true;
            }
        }

        return b1 && b2;
    }

}
