package 校队.校队题库_新;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// map

public class P27接龙字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        // 时间超限：
//        int res = 0;
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//                if (str.charAt(i) == str.charAt(j)) {
//                    res++;
//                }
//            }
//        }
//        System.out.println(res);

        // 使用map记录：
        long res = str.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            long demo = entry.getValue();
            if (demo >= 2) {
                res += (demo * (demo - 1)) / 2;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}
