package 青训营.豆包;

// 签到：位运算
public class 找单独的数 {
    public static int solution(int[] inp) {
        int n = 0;
        // 使用异或操作计算结果
        for (int v : inp) {
            n ^= v;
        }
        return n;
    }

    // public static void P24多路归并Ⅱ(String[] args) {
    //     int[] inp = {1, 2, 3, 2, 1};
    //     System.out.println(solution(inp)); // 输出3
    // }
}
