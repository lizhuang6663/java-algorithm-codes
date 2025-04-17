package 校队.Codeforces.Num4月25日_2022年中国大学生程序设计竞赛女生专场;

import 校队.Codeforces.Read;

/*

    2022年中国大学生程序设计竞赛女生专场:https://codeforces.com/gym/104081
    题解：https://zhuanlan.zhihu.com/p/659151416

 */

// 贪心
// Codeforces：https://codeforces.com/gym/104081/problem/A

public class A减肥计划 {
    // 方法一：模拟使用 LinkedList，时间超限
//    public static void P24多路归并Ⅱ(String[] args) throws Exception {
//        Read scanner = new Read();
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//
//        // 用 list 装下标
//        LinkedList<Integer> list = new LinkedList<>();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//            list.addLast(i);
//        }
//
//        int who = 0, win = 0;
//        for (int i = 0; i < 2000000; i++) {
//
//            int a0 = list.get(0);
//            list.removeFirst();
//            int a1 = list.get(1);
//            list.removeFirst();
//
//            if (arr[a0] >= arr[a1]) {
//                list.addFirst(a0);
//                list.addLast(a1);
//                who = a0;
//                win++;
//
//            } else { // 如果后面的数大，win要重新开始计数了
//                list.addFirst(a1);
//                list.addLast(a0);
//                who = a1;
//                win = 1;
//            }
//
//            if (win >= k) {
//                System.out.println(who + 1); // who 记录的是下标
//                return;
//            }
//
//        }
//
//        System.out.println(win);
//    }

    // 方法二：
    public static void main(String[] args) throws Exception {
        Read scanner = new Read();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int ans = 0;
        int max = arr[1];
        int index = 1;

        // 1 1 4 5 1 4 可知：前三个中4是最大的，4和5比较的时候，如果5比4大，那么5一定比1，1大，所以5就不用和1，1比较了
        for (int i = 2; i <= n; i++) {
            if (max >= arr[i]) {
                ans++;
                if (ans == k) {
                    System.out.println(index);
                    return;
                }

            }else {
                ans = 1;
                max = arr[i];
                index = i;
            }
        }

        // 程序没有在上面退出，说明ans的值还不够，但是我们一定找到了 最大值的下标（index）
        System.out.println(index);
    }
}

