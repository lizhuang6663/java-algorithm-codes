package common.incomplete;

import java.util.Scanner;

//连续队列
//校队训练：https://ac.nowcoder.com/acm/contest/70300/C
//未写正确

public class Num2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2 && arr[2]-arr[1] > 1) {
            System.out.println(2);
            return;
        }


        int left = 0, right;
        //是否可以改变一个数
        boolean isSure = true;
        int admin = 0;//标记点

        int result = 0;

        for (right = 1; right <= n; right++) {
            if (arr[right] > arr[right-1] ) {
                result++;
            }else {
                //如果可以插入一个值，才标记一下
                if (isSure && arr[right-1] - arr[right] > 1) {
                    isSure = false;
                    admin = right;
                }else {
                    //不能标记：1.标记够了 2.差小于等于1
                    if (!isSure) {
                        isSure = true;
                        left = admin;
                    }
                    if (arr[right-1] - arr[right] <= 1) {
                        left = right;
                        isSure = true;
                    }

                }
            }
            if (left == 0) {
                result = Math.max(result, right-left);
            }else {
                result = Math.max(result, right-left+1);
            }

        }
        System.out.println(result);

    }
}

/*

6
7 2 3 1 5 6

2
4 2

5
7 4 3 5 6



5
1 2 3 2 4

5
1 2 3 2 5


 */