package common.homework;

import java.util.Scanner;

//连续的字符串
//牛客： https://ac.nowcoder.com/acm/contest/69695/B

public class Num12 {
    //没有写出来
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int result = 0, s0 = 0, s1 = 0;
        for(char ch : s.toCharArray()) {
            if (ch == '0') {
                s0 ++;
                s1 = 0;
            } else if (ch == '1') {
                s1 ++;
                s0 = 0;
            }else {
                s1 ++;
                s0 ++;
            }
            result = Math.max(result, Math.max(s0, s1));
        }
        System.out.println(result);
    }


    //超时
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//
//        if (s.length() < 1) {
//            System.out.println(1);
//            return;
//        }
//
//        int result = 0;
//        List<Character> list = new ArrayList<>();
//
//        for (int j = 0; j < s.length(); j++) {
//            list.add(s.charAt(j));
//            while (list.contains('1') && list.contains('0')) {
//                list.remove(0);
//            }
//            result = Math.max(result, list.size());
//        }
//        System.out.println(result);
//    }
}

//   1?0?1?     1??0?1