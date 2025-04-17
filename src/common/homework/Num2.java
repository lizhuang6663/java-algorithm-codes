package common.homework;

import java.util.*;

/*

正式队每日任务：
第一天链接：
https://codeforces.com/contest/1881/problem/D

质因数分解

 */

public class Num2 {
    //质因数分解+哈希表
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        boolean b ;
        for (int i = 1;i<=t;i++) {
            b = true;

            map.clear();
            int n = scanner.nextInt();
            int [] arr = new int[n];

            for (int j = 0;j<arr.length;j++) {
                arr[j] = scanner.nextInt();
                del(arr[j]);
            }

            for (Integer value : map.values()) {
                //查看这n个数中，每种因数的个数能否平均分配给这n个数
                if (value%n != 0) {
                    b = false;
                    break;
                }
            }

            if (b) {
                System.out.println("Yes");
            }else {
                System.out.println("NO");
            }
        }
    }


    //找出质因数的次数，存放到map中
    public static void del(int n) {
        for (int i = 2;i<n;i++) {
            while (n%i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                //也可以：
//                if (map.get(i) == null) {
//                    map.put(i, 1);
//                }else {
//                    int count = map.get(i);
//                    map.put(i, ++count);
//                }
                n /= i;
            }
        }

        if (n != 1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

    }


}

/*

输入：
7
5
100 2 50 10 1
3
1 1 1
4
8 2 4 2
4
30 50 27 20
2
75 40
2
4 4
3
2 3 1


输出：
YES
YES
NO
YES
NO
YES
NO


 */