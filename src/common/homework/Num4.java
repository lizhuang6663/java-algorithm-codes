package common.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//甄别情报
//https://www.matiji.net/exam/brushquestion/14/4009/C448715ED43BEA9D2D47CED523050945
public class Num4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            judge(s1,s2);
        }
    }


    public static void judge(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();

        for (int j = 0; j < s1.length(); j++) {

            if (map.containsKey(s1.charAt(j)) && map.get(s1.charAt(j)) != s2.charAt(j)) {
                System.out.println("NO");
                return;
            }else {
                //通过了上面的if，还要 判断 b、c的values 同时是 B时的错误情况。  方法一：
//                for (Character c : map.keySet()) {
//                    if (s2.charAt(j) == map.get(c) && c != s1.charAt(j)) {
//                        System.out.println("NO");
//                        return;
//                    }
//                }


                //通过了上面的if，还要 判断 b、c的values 同时是 B时的错误情况。  方法二：推荐
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    char key = entry.getKey();
                    char value = entry.getValue();

                    //key 不相等，但是value相等了，就说明错误了
                    if (key != s1.charAt(j) && value == s2.charAt(j)) {
                        System.out.println("NO");
                        return;
                    }
                }


                map.put(s1.charAt(j), s2.charAt(j));
            }
        }
        System.out.println("YES");
    }
}

/*

4
ab CD
abc ABB
abb ABC
xyzz ABCC


 */