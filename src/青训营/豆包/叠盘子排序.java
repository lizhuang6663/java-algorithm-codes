package 青训营.豆包;

// 数组
public class 叠盘子排序 {
    public static String solution(int[] plates, int n) {
        StringBuilder result = new StringBuilder();
        int start = 0;

        while (start < n) {
            int end = start;
            // 找到连续递增的序列
            while (end + 1 < n && plates[end + 1] == plates[end] + 1) {
                end++;
            }
            if (end - start >= 2) {
                // 如果序列长度大于等于3，表示为范围
                result.append(plates[start]).append("-").append(plates[end]);
            } else {
                // 否则单独列出
                for (int i = start; i <= end; i++) {
                    result.append(plates[i]);
                    if (i < end) {
                        result.append(",");
                    }
                }
            }

            // 添加分隔符
            if (end < n - 1) {
                result.append(",");
            }
            start = end + 1;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}, 10).equals("-3--1,2,10,15,16,18-20"));
        System.out.println(solution(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}, 20).equals("-6,-3-1,3-5,7-11,14,15,17-20"));
        System.out.println(solution(new int[]{1, 2, 7, 8, 9, 10, 11, 19}, 8).equals("1,2,7-11,19"));
    }
}
