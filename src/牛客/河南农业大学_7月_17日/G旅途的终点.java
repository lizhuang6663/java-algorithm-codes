package 牛客.河南农业大学_7月_17日;

// 反悔贪心：先开一个最大堆存储每次经过的路径，我们先不考虑释放神力k，每次经过国家都消耗生命值，当生命值小于等于0时，
// 考虑反悔之前消耗生命值最多的一次，然后将栈顶出栈，若k次数用尽，则输出当前坐标减去1（不包含当前坐标），若最后全部通过则输出n。
// 牛客：https://ac.nowcoder.com/acm/contest/86639/G

// java无法通过，C++可以通过

import java.util.PriorityQueue;
import java.util.Scanner;

public class G旅途的终点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        int k = scanner.nextInt();
        long[] arr = new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextLong();
        }

        // 优先队列
        PriorityQueue<Long> p = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            p.add(arr[i]);
            m -= arr[i];

            while (m <= 0) {
                if (k <= 0) {
                    System.out.println(i-1);
                    return;
                }
                k--;
                m += p.peek() ;
                p.poll();
            }
        }
        System.out.println(n);
    }
}


/*


#include <iostream>
#include <queue>
#include <vector>
using namespace std;

void solve() {
    long long n, m, k;
    cin >> n >> m >> k;
    vector<long long > a(n+1);  // 定义一个大小为 n+1 的数组来存储输入数据
    priority_queue<long long> q;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }

    for (int i = 1; i <= n; ++i) {
        q.push(a[i]);
        m -= a[i];
        while (m <= 0) {
            if (k <= 0) {
                cout << i - 1 << endl;
                return;
            }
            k--;
            m += q.top();
            q.pop();
        }
    }
    cout << n << endl;
    return;
}

int P24多路归并Ⅱ() {
    solve();
    return 0;
}




 */


/*

3 10 1
11 2 1
3

1 10 0
10
0

 */