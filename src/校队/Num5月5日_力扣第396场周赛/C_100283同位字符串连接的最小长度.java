package 校队.Nu5月5日_力扣第396场周赛;


// 最大公因数（均分）
// 力扣：https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/

public class C_100283同位字符串连接的最小长度 {

    public int minAnagramLength(String s) {
        int len = s.length();

        // 统计每个单词的数量
        int [] arr = new int[26];
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i)-'a'] ++;
        }

        // i 代表字符串s可以均分为几份，每一份所包含的字母数量和种类相同（比如 aaacccccc a:3个，c:6个，可以把它均分为 acc acc acc）
        for (int i = len; i > 0; i--) {
            boolean flag = true;

            for (int j = 0; j < 26; j++) {
                // 无法均分为i份
                if (arr[j] % i != 0) { // 当arr[j] == 0 的时候，arr[j] % i = 0
                    flag = false;
                    break;
                }
            }
            // 如果flag为true，len / i 一定是整数，没有余数
            if (flag) return len / i;
        }
        return len;
    }

}
