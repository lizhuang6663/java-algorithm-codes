package 青训营.豆包;

// 字符串格式化
public class 数字字符串格式化 {
    public static String solution(String s) {
        // 去掉0
        int index = 0;
        while (s.charAt(index) == '0') {
            index++;
        }
        s = s.substring(index);

        // 分割 .
        String[] arr = s.split("\\.");// 要把 . 转义
        StringBuilder sb = new StringBuilder(arr[0]).reverse();// 翻转
        StringBuilder result = new StringBuilder(); // 最终的结果
        // 添加 ,
        for (int i = 0; i < sb.length(); i++) {
            if (i != 0 && i % 3 == 0) {
                result.append(",");
            }
            result.append(sb.charAt(i));
        }
        // 再次翻转
        result.reverse();

        // 如果有小数就添加
        if (arr.length == 2) {
            result.append(".");
            result.append(arr[1]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}