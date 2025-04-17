package 代码随想录And力扣.力扣.面试题;


// 模拟
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/compress-string-lcci/description/

public class P0106字符串压缩 {


    public String compressString(String S) {
        if (S.length() == 0) return S;

        StringBuilder sb = new StringBuilder();

        int temp = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                temp++;
            } else {
                sb.append(S.charAt(i - 1));
                sb.append(temp);
                temp = 1; // 重置
            }
        }

        // 把末尾的字母加上
        sb.append(S.charAt(S.length() - 1));
        sb.append(temp);

        // 判断字符串是否变短了
        return S.length() > sb.length() ? sb.toString() : S;
    }

}
