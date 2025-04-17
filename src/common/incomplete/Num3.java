package common.incomplete;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 牛客周赛：https://ac.nowcoder.com/acm/contest/73422/E （没看懂）

//小红希望你构造一个数组，满足以下三个条件：
//1. 数组的元素都是素数。
//2. 数组所有元素相乘恰好等于x
//3. 数组任意相邻两个元素不等。
public class Num3 {

    // 分解n
    static List<long[]> split(long n) {
        List<long[]> res = new ArrayList<>();

        for (long i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int cnt = 0;
                while (n % i == 0) {
                    n /= i;
                    cnt++;
                }
                res.add(new long[]{i, cnt});
            }
        }

        if (n > 1) {
            res.add(new long[]{n, 1});
        }
        return res;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        long e = sc.nextLong();

        if (e == 1) {
            System.out.println(-1);
            return;
        }

        List<long[]> primes = split(e);

        // 感觉像众数的构造???
        int n = 0;

        // primes 列表按照每个数组 long[] 中的第二个元素进行降序排序
        Collections.sort(primes, Comparator.comparing(x -> -x[1]));

        int m = (int) primes.get(0)[1];
        for (long[] x : primes) {
            n += (int) x[1]; // e一共能分解成多少个数
        }


        // 看不懂了
        if (m > (n + 1) / 2) {
            System.out.println(-1);
        } else {
            Long[] res = new Long[n];

            int ptr = 0;
            for (long[] x : primes) {
                for (int j = 0; j < x[1]; j++) {
                    res[ptr] = x[0];
                    ptr += 2;
                    if (ptr >= n) ptr = 1;
                }
            }
            System.out.println(n);
            System.out.println(Arrays.stream(res).map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }


}


