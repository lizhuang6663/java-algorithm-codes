package 校队.Codeforces.Num4月25日_2022年中国大学生程序设计竞赛女生专场;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// 模拟（时间超限）
// Codeforces：https://codeforces.com/gym/104081/problem/G

public class G排队打卡 {
    public static void main(String[] args) {
        int t = nextInt();
        long n = nextLong();
        int m = nextInt();
        int k = nextInt();

        // 优先队列，int[0] 存时间，int[1] 存这个时间加入的人数，
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < m; i++) {
            queue.add(new long[]{nextLong(), nextLong()});
        }
        // 把睡醒的时间加入进去
        queue.add(new long[]{t, 0});


        // 当前的人数; 上一次放行的时间
        long people = 0, preTime = 0;
        // 主角放行的时间;需要的时间
        long beginTime = 0, needTime = Long.MAX_VALUE;

        while (!queue.isEmpty()) {
            long[] temp = queue.poll();

            // 第一次减去走的人是为了，防止时间空出来，比如说：从第4秒直接跳到了第6秒，第5秒的时候也应该出去一些人；
            // 如果是从第4秒直接跳到了第5秒，相当于没有减少人数，在羡慕减少人数
            people = Math.max(people - k * (temp[0] - preTime - 1), 0L); // 放行人

            // 新加入的人数
            people += temp[1];

            // 主角清醒的时候，判读日志是否正确
            if (temp[1] == 0 && n != people) {
                out.println("Wrong Record");
                out.flush();
                return;
            }

            // 主角可以放行了，取最短时间
            if (temp[0] >= t && temp[1] != 0) {
                long need = (people + 1) / k;
                if ((people + 1) % k != 0) need++; // 注意：可能有余数，需要多1秒

                if (needTime >= need) {//如果说所需要的时间与在记录的时间相等或者是更小
                    needTime = need;//把当前短的时间作为记录
                    beginTime = temp[0];//记录当前的时间 因为更晚优先 因为队列是按照时间序列输出的 所以直接将最晚时间记录为当前时间
                }
            }

            preTime = temp[0];
            people = Math.max(people - k, 0L); // 每秒放行
        }
        out.println(beginTime + " " + needTime);
        out.flush();
    }


    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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
