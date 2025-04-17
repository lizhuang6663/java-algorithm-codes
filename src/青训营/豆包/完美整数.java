package 青训营.豆包;

// 签到
public class 完美整数 {
    public static int solution(int x, int y) {
        int num = 0;
        for (int i = x; i <= y; i++) {
            String str = String.valueOf(i);
            boolean b = true;
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    b = false;
                    break;
                }
            }
            if (b) num++;
        }
        return num;
    }

    public static void main(String[] args) {
        // Add your test cases here

        System.out.println(solution(1, 10) == 9);
        System.out.println(solution(2, 22) == 10);
    }
}

