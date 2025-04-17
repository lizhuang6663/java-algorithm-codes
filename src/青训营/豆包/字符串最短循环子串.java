package 青训营.豆包;

// 签到
public class 字符串最短循环子串 {
    public static String solution(String inp) {
        int len = inp.length();
        for (int i = 1; i <= len / 2; i++) {
            // 如果长度可以整除
            if (len % i == 0) {
                String s = inp.substring(0, i);
                StringBuilder demo = new StringBuilder();
                // 重复字符串 s
                for (int j = 0; j < len / i; j++) {
                    demo.append(s);
                }
                if (demo.toString().equals(inp)) {
                    return s;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String inp = "abcabcabc";
        System.out.println(solution(inp)); // 输出 "abc"
    }
}
