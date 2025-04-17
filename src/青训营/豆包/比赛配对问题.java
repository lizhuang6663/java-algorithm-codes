package 青训营.豆包;

// 数学

public class 比赛配对问题 {
    public static int solution(int n) {
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                res += n / 2;
                n /= 2;
            } else {
                res += n / 2;
                n = (n + 1) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(7) == 6);
        System.out.println(solution(14) == 13);
        System.out.println(solution(1) == 0);
    }
}
