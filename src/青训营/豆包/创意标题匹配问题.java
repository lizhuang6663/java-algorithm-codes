package 青训营.豆包;

import java.util.regex.*;

// 字符串匹配，正则表达式
public class 创意标题匹配问题 {
    public static String solution(int n, String template, String[] titles) {
        // 将模板中的通配符部分转换成正则表达式
        String regex = template.replaceAll("\\{.*?\\}", ".*");
        // 在正则表达式的前后添加起始和结束标志
        regex = "^" + regex + "$";

        // 创建一个 Pattern 对象
        Pattern pattern = Pattern.compile(regex);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // 获取当前标题
            String title = titles[i];
            // 检查标题是否与正则表达式匹配
            Matcher matcher = pattern.matcher(title);
            if (matcher.matches()) {
                result.append("True");
            } else {
                result.append("False");
            }
            // 添加逗号分隔
            if (i < n - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        //  You can add more test cases here
        String[] testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"};
        String[] testTitles2 = {"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"};
        String[] testTitles3 = {"abcdefg", "abefg", "efg"};

        System.out.println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1).equals("True,False,False,True"));
        System.out.println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2).equals("False,False,False,False,False,True"));
        System.out.println(solution(3, "a{bdc}efg", testTitles3).equals("True,True,False"));
    }
}

