package 青训营.豆包;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 签到
public class 环状DNA序列的最小表示法 {
    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();

        // 生成所有的旋转字符串
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            list.add(rotated);
        }

        // 对列表进行排序
        Collections.sort(list);

        // 返回排序后的第一个字符串
        return list.get(0);
    }

    public static void main(String[] args) {
        String s = "cabbage";
        System.out.println(solution(s)); // 输出旋转后字典序最小的字符串
    }
}

