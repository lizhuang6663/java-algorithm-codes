package 青训营.豆包;

public class 字典序最小的01字符串 {
    public static String solution(int n, int k, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < n && k > 0; i++) {
            // 只处理 '0'，并尝试把它移到尽可能靠前的位置
            if (chars[i] == '0') {
                // j 指向当前的 '0' 的位置
                int j = i;
                // 往左移动，直到找到合适的位置或者耗尽 k
                while (j > 0 && chars[j - 1] == '1' && k > 0) {
                    // 交换位置：'0' 和它前面的 '1'
                    chars[j] = '1';
                    chars[j - 1] = '0';
                    j--;
                    k--; // 每次交换减少一次操作机会
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 2, "01010").equals("00101"));
        System.out.println(solution(7, 3, "1101001").equals("0110101"));
        System.out.println(solution(4, 1, "1001").equals("0101"));
    }
}