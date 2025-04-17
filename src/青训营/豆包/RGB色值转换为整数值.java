package 青训营.豆包;

// 进制

public class RGB色值转换为整数值 {
    public static int solution(String rgb) {
        // 去掉 "rgb(" 和 ")"，并按逗号分割
        String[] rgbValues = rgb.substring(4, rgb.length() - 1).split(",");

        // 解析红、绿、蓝的值
        int r = Integer.parseInt(rgbValues[0].trim());
        int g = Integer.parseInt(rgbValues[1].trim());
        int b = Integer.parseInt(rgbValues[2].trim());

        // 将 RGB 转换为整数值
        // 通过移位操作，将红色值放在高 16 位，绿色值放在中间 8 位，蓝色值放在低 8 位，得到最终的整数值。
        return (r << 16) | (g << 8) | b;
        // 通过移位操作组合成一个整数，然后直接返回这个整数。虽然在计算过程中涉及到二进制的位操作，但最终输出的结果用的是十进制表示。
        // 例如，对于输入 rgb(192, 192, 192)：
        // 红色 192 转换为二进制 11000000，并向左移动 16 位：11000000 00000000 00000000。
        // 绿色 192 转换为二进制 11000000，并向左移动 8 位：00000000 11000000 00000000。
        // 蓝色 192 保持原样：00000000 00000000 11000000。
        // 最终通过 | 操作组合在一起得到：11000000 11000000 11000000，对应的十进制值是 12632256。所以输出的结果是十进制的数值，不是十六进制或二进制。
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution("rgb(192, 192, 192)") == 12632256);
        System.out.println(solution("rgb(100, 0, 252)") == 6553852);
        System.out.println(solution("rgb(33, 44, 55)") == 2174007);
    }
}
