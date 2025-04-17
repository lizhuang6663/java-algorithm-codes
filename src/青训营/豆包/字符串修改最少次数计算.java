package 青训营.豆包;

// 字符串

public class 字符串修改最少次数计算 {
    public static int solution(String s) {
        int result = 0;
        int demo = 1; // 相邻连续相同的字母个数
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right - 1) == s.charAt(right)) {
                demo++;
            } else {
                result += demo / 2;
                demo = 1;
            }
        }
        // 加上最后面的
        result += demo / 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("111222333") == 3);
        System.out.println(solution("11551111") == 4);
        System.out.println(solution("1234567890") == 0);
        System.out.println(solution("1511") == 1);
        System.out.println(solution("1551") == 1);
    }
}
