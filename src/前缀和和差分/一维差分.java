package 前缀和和差分;

import java.util.Scanner;


//一维差分
//CSDN： https://blog.csdn.net/weixin_45629285/article/details/111146240?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164895247816781685391282%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=164895247816781685391282&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-5-111146240.142%5Ev5%5Epc_search_result_cache,157%5Ev4%5Econtrol&utm_term=%E5%89%8D%E7%BC%80%E5%92%8C%E7%AE%97%E6%B3%95&spm=1018.2226.3001.4187
// a数组是b数组的前缀和数组，比如对b数组的b[i]的修改，会影响到a数组中从a[i]及往后的每一个数。
// a数组是b数组的前缀和数组，那么b数组就是a数组的差分数组了
// 适用范围：
// 给定区间[l, r]，需求：把a数组中的[l, r] 区间中的每一个数都加上c,即 a[l] + c , a[l + 1] + c , a[l + 2] + c ,,,,,, a[r] + c;
// 正常写法是 两层for循环，时间复杂度为O(n*m)
// 使用差分：时间复杂度为O(n)


//输入一个长度为n的整数序列。
//接下来输入m个操作，每个操作包含三个整数l, r, c，表示将序列中[l, r]之间的每个数加上c。
//请你输出进行完所有操作后的序列。

//输入格式
//第一行包含两个整数n和m。
//第二行包含n个整数，表示整数序列。
//接下来m行，每行包含三个整数l，r，c，表示一个操作。

//输出格式
//共一行，包含n个整数，表示最终序列。

public class 一维差分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 将a看作是前缀和数组，b看作是a的差分数组
        int a[] = new int[n*n];
        int b[] = new int[n*n];

        for (int i = 1; i < n+1; i++) {
            a[i] = scanner.nextInt();
            b[i] = a[i] - a[i-1];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            b[l] += c;
            b[r+1] -= c;
        }

        // 将差分数组恢复为前缀和数组
        for (int i = 1; i < n+1; i++) {
            b[i] += b[i-1];
            System.out.println(b[i]);
        }

    }
}

/*

6 3
1 2 2 1 2 1
1 3 1
3 5 1
1 6 1

输出样例：
3 4 5 3 4 2

 */