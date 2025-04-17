package 校队.Codeforces.Num4月26日_第十届山东省ACM省赛;

import 校队.Codeforces.Read;
import java.util.Comparator;
import java.util.PriorityQueue;

// 贪心+优先队列
// Codeforces:https://codeforces.com/gym/104459/problem/H

// 题目大意：
// 在二维坐标系中给出n条线段，第i条线段的两个端点分别为（li,i）和（ri,i）,每个整数点都可以被标记，但是被标记的点x坐标不能相同，求至少有一个点被标记的线段最多有多少条
// 基本思路：贪心+优先队列
// 1.要使标记的线段最多，一条线段上只需标记一个点
// 2.尽可能标记短的线段，使更多线段可以被标记
// 3. 先对所有线段按左端点从小到大，左端点相同时按右端点从小到大的顺序进行排序
// 4.可选线段中左端点最小，且在与它左端点相同的所有线段中右端点最小的线段，标记左端点，对于与它左端点相同的其他线段则只能标记该点之后的点->优先队列
// 5.队首线段左端点可标记则出队，计数器加一，若队首线段左端点已被标记，则将该线段左端点加一后再入队（保证左端点小于等于右端点）

public class HTokensOnTheSegments {
    public static void main(String[] args) throws Exception {
        Read scanner = new Read();
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();

            // 要使用优先队列，里面的元素一直是有序的
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });

            for (int j = 0; j < n; j++) {
                // 将所有线段加入队列
                queue.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }

            int k = 0; // k记录上一个被标记的点的x坐标
            int ans = 0;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                if (k == temp[0]) {
                    temp[0]++; // 若左端点已被标记，则左端点x坐标加1
                    // 得到的新线段如果符合要求就则入队
                    if (temp[0] <= temp[1]) queue.add(temp);

                } else { // 若左端点没被标记，则k记为左端点，计数器加一
                    k = temp[0];
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }
}
