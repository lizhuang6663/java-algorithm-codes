package 校队.Codeforces.Num4月29日_2019陕西省大学生程序设计竞赛;

import java.io.*;

/*

    2019 陕西省大学生程序设计竞赛：https://codeforces.com/gym/104460/
    题解：https://sua.ac/wiki/2019-provincial-shaanxi/
    https://www.cnblogs.com/Kescholar/p/17603219.html
    https://zhuanlan.zhihu.com/p/643013619
    https://blog.csdn.net/c_eeking/article/details/121989959

 */

// 欧拉图
// 并查集，欧拉路径，有向图（入度和出度）（只有连通图才有欧拉路径）
// Codeforces:https://codeforces.com/gym/104460/problem/B
// 题解CSDN：https://blog.csdn.net/ywzdcj/article/details/130671646?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169944459916800182160825%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=169944459916800182160825&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-130671646-null-null.142%5Ev96%5Epc_search_result_base4&utm_term=Grid%20with%20Arrows&spm=1018.2226.3001.4187

public class BGridWithArrows {
    // 经过所有的点且每条边只经过一次，可以想到欧拉路径。
    // 题目可以转换为一个有向图，因此我们可以统计这个有向图中每一个点的入度和出度，若这个有向图中每一个点的入度都等于出度，则存在欧拉回路，满足；
    // 若存在一个点的入度比出度大1，存在一个点的出度比入度大1，其余的点入度出度相等，则也满足。
    // 注：在判断是否含有欧拉路径前要先判断有向图是否连通，只有连通图才有欧拉路径，用并查集来判断。

    static String[] arrow;
    static int[] fa, in, out; // 把二维看作一维

    public static void main(String[] args) {
        int T = nextInt();

        for (int i = 0; i < T; i++) {
            int n = nextInt();
            int m = nextInt();
            // 也可以直接开辟空间为 100005，因为 1 <= n*m <= 100000
            arrow = new String[n];
            fa = new int[n * m];
            in = new int[n * m];
            out = new int[n * m];

            // 初始化
            for (int j = 0; j < n * m; j++) {
                fa[j] = j;
                in[j] = 0;
                out[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                arrow[j] = next();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int a = nextInt();

                    // *m 代表着第几行，将二维变成了一维的
                    if (arrow[j].charAt(k) == 'u' && j - a >= 0) {
                        in[(j - a) * m + k]++;
                        out[j * m + k]++;
                        union( j * m + k, (j - a) * m + k);
                    } else if (arrow[j].charAt(k) == 'd' && j + a < n) {
                        in[(j + a) * m + k]++;
                        out[j * m + k]++;
                        union( j * m + k, (j + a) * m + k);
                    } else if (arrow[j].charAt(k) == 'l' && k - a >= 0) {
                        in[j * m + (k - a)]++;
                        out[j * m + k]++;
                        union( j * m + k, j * m + (k - a));
                    } else if (arrow[j].charAt(k) == 'r' && k + a < m) {
                        in[j * m + (k + a)]++;
                        out[j * m + k]++;
                        union( j * m + k, j * m + (k + a));
                    }
                }
            }

//            for (int j = 0; j < n*m; j++) {
//                System.out.print(fa[j] + " ");
//            }
//            System.out.println();
//            for (int j = 0; j < n*m; j++) {
//                System.out.print(in[j] + " ");
//            }
//            System.out.println();
//            for (int j = 0; j < n*m; j++) {
//                System.out.print(out[j] + " ");
//            }
//            System.out.println();


            // 欧拉路径的存在性与图的连通性以及顶点的度数有关。具体来说：
            // 1.对于无向图：如果图是连通的，并且图中恰好有两个顶点的度数为奇数，其余顶点的度数都为偶数，则图中存在欧拉路径。
            // 2.对于有向图：如果图是弱连通的，并且图中恰好有两个顶点的出度与入度之差为 1，另外两个顶点的入度与出度之差为 -1，其余顶点的入度和出度相等，则图中存在欧拉路径。
            int fbig = 0, fsmall = 0, count = 0, flag = 0;
            for (int j = 0; j < n * m; j++) {
                if (fa[j] == j) flag++;

                // 不联通，有多个连通分量
                if (flag > 1) break;

                if (in[j] != out[j]) {
                    count++;
                    if (in[j] == out[j]+ 1 ) {
                        fbig = 1;
                    } else if (in[j]  + 1 == out[j]) {
                        fsmall = 1;
                    }
                }
            }

            if (flag == 1 && count == 0) { // 联通且含有欧拉回路
                System.out.println("Yes");
            } else if (flag == 1 && count == 2 && fbig == 1 && fsmall == 1) { // 联通且含有欧拉回路
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }


    // 查找
    public static int find(int i) {
        if (fa[i] == i) {
            return i;
        } else {
            fa[i] = find(fa[i]);
            return fa[i];
        }
    }

    // 合并
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        fa[x] = y;
    }


    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double nextDouble() {
        try {
            st.nextToken();
            return (double) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Long nextLong() {
        try {
            st.nextToken();
            return (long) st.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String next() {
        try {
            st.nextToken();
            return st.sval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

/*
C_PolycarpRecoversthePermutation++ 版本：


#include<iostream>

using namespace std;

string arrow[100005];
int fa[1000005], in[1000005], out[1000005]; // 把二维看作一维


// 查找
int find(int i) {
    if (fa[i] == i)
        return fa[i];
    else {
        fa[i] = find(fa[i]);
        return fa[i];
    }
}

// 合并
void unions(int x, int y) {
    int i = find(x);
    int j = find(y);
    fa[i] = j;
}

int P24多路归并Ⅱ() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        scanf("%d %d", &n, &m);
        // 初始化
        for (int i = 0; i < n * m; i++) {
            fa[i] = i;
            in[i] = 0;
            out[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            cin >> arrow[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a;
                scanf("%d", &a);

                // *m 代表着第几行，将二维变成了一维的
                if (arrow[i][j] == 'u' && i - a >= 0) {
                    in[(i - a) * m + j]++;
                    out[i * m + j]++;
                    unions(i * m + j, (i - a) * m + j);
                } else if (arrow[i][j] == 'd' && i + a < n) {
                    in[(i + a) * m + j]++;
                    out[i * m + j]++;
                    unions(i * m + j, (i + a) * m + j);
                } else if (arrow[i][j] == 'l' && j - a >= 0) {
                    in[i * m + j - a]++;
                    out[i * m + j]++;
                    unions(i * m + j, i * m + j - a);
                } else if (arrow[i][j] == 'r' && j + a < m) {
                    in[i * m + j + a]++;
                    out[i * m + j]++;
                    unions(i * m + j, i * m + j + a);
                }
            }
        }

        for (int i = 0; i < n * m; i++) {
            printf("%d ",fa[i]);
        }
        printf("\n");
        for (int i = 0; i < n * m; i++) {
            printf("%d ",in[i]);
        }
        printf("\n");
        for (int i = 0; i < n * m; i++) {
            printf("%d ",out[i]);
        }
        printf("\n");


        int fbig = 0, fsmall = 0, count = 0, flag = 0;
        for (int i = 0; i < n * m; i++) {
            if (fa[i] == i) flag++;

            // 不联通，有多个连通分量
            if (flag > 1) break;

            if (in[i] != out[i]) {
                count++;
                if (in[i] == out[i] + 1)
                    fbig = 1;
                else if (in[i] + 1 == out[i])
                    fsmall = 1;
            }
        }

        if (count == 0 && flag == 1) { //联通且含有欧拉回路
            printf("Yes\n");
        } else if (fbig == 1 && fsmall == 1 && count == 2 && flag == 1) { //联通且含有欧拉通路
            printf("Yes\n");
        } else{
            printf("No\n");
        }

    }
}


 */