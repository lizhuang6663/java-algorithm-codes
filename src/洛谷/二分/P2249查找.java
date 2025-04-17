package 洛谷.二分;

import java.io.*;

// 二分（左闭右开），快速输入输出
// 洛谷：https://www.luogu.com.cn/problem/P2249?contestId=162285

public class P2249查找 {
    public static void main(String[] args) throws Exception {
        Read2 scanner = new Read2();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = scanner.nextInt();

            int left = 0, right = n - 1;
            while (left < right) { // 如果这里的条件加上等号，需要查询的结果是最后一个元素的话，就会陷入到死循环中。
                int mid = left + ((right - left) >> 1);

                // 左闭右开
                if (arr[mid] < target) {
                    left = mid + 1;
                } else if (arr[mid] >= target) {
                    right = mid;
                }

                // 错误：
//                if (arr[mid] == temp) {
//                    // 向左边查找
//                    while (mid > 0 && arr[mid - 1] == temp) {
//                        mid--;
//                    }
//                    bw.write(String.valueOf(mid + 1) + " ");
//                    break;
//                } else if (arr[mid] > temp) {
//                    right = mid - 1;
//                } else if (arr[mid] < temp) {
//                    left = mid + 1;
//                }

            }
            if (arr[left] == target) {
                bw.write(String.valueOf(left + 1) + " ");
            } else {
                bw.write(String.valueOf(-1) + " ");
            }

        }

        bw.flush();
        bw.close();
    }
}


// 如果使用Read类的话，最后一个案例会内存超限
class Read2 {
    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}


/*

10 1
1 3 3 3 5 7 9 11 13 15
15

10

 */