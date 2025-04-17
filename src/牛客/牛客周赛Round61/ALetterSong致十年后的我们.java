package 牛客.牛客周赛Round61;

import java.util.Scanner;

// 签到题
public class ALetterSong致十年后的我们 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        String str = s.substring(0, 2) + (s.charAt(2)-'0' + 1) + s.substring(3);
        System.out.println(str);
    }
}
