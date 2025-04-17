package 青训营.豆包;

// 签到
public class 完美偶数计数 {
    public static int solution(int n, int l, int r, int[] a) {
        int num = 0;

        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 0 && a[i] >= l && a[i] <= r) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 8, new int[]{1, 2, 6, 8, 7}) == 2);
        System.out.println(solution(4, 10, 20, new int[]{12, 15, 18, 9}) == 2);
        System.out.println(solution(3, 1, 10, new int[]{2, 4, 6}) == 3);
    }
}

