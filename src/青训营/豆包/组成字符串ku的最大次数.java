package 青训营.豆包;

// 签到
public class 组成字符串ku的最大次数 {
    public static int solution(String s) {
        int k = 0, u = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'k') {
                k++;
            } else if (s.charAt(i) == 'u') {
                u++;
            }
        }
        return Math.min(k, u);
    }

    public static void main(String[] args) {
        System.out.println(solution("AUBTMKAxfuu") == 1);
        System.out.println(solution("KKuuUuUuKKKKkkkkKK") == 6);
        System.out.println(solution("abcdefgh") == 0);
        System.out.println(solution("bzmsvzxbgerkqsb") == 0);
    }
}
