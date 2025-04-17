package 校队.Num4月19日_牛客小白月赛91;

import java.util.Scanner;

// 动态规划（不会写）
// 牛客：https://ac.nowcoder.com/acm/contest/78807/D

public class Bingbong的奇偶世界 {
    // 方法一：
    static int mod =(int) 1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        long ans =0,pre = 0;
        for(int i=0;i<n;i++){
            if(i>0&&s.charAt(i-1)!='0'){
                pre++;
            }
            if(s.charAt(i)%2==0){
                ans=(ans+pre+1)%mod;
            }
            pre=pre*2%mod;
        }
        System.out.println(ans);
    }


//    // 方法二：
//    static final long MOD = 1000000007;
//    static final int N = 200005;
//
//    static long[][] dp = new long[N][3];
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//        String s = scanner.nextLine();
//
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = dp[i][1] = dp[i][2] = 0;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            char c = s.charAt(i - 1);
//            int a = Character.getNumericValue(c);
//
//            if (a == 0) {
//                dp[i][0] = (dp[i - 1][0] + 1) % MOD;
//                dp[i][1] = dp[i - 1][1];
//                dp[i][2] = (dp[i - 1][2] * 2 % MOD + dp[i - 1][1]) % MOD;
//            } else if (a % 2 == 1) {
//                dp[i][0] = dp[i - 1][0];
//                dp[i][1] = (2 * dp[i - 1][1] % MOD + 1 + dp[i - 1][2]) % MOD;
//                dp[i][2] = dp[i - 1][2];
//            } else {
//                dp[i][0] = dp[i - 1][0];
//                dp[i][1] = dp[i - 1][1];
//                dp[i][2] = (2 * dp[i - 1][2] % MOD + 1 + dp[i - 1][1]) % MOD;
//            }
//        }
//
//        long ans = (dp[n][0] + dp[n][2]) % MOD;
//        System.out.println(ans);
//    }
//
//
//    // 方法三：
//    static long MOD = (long) 1e9 + 7;
//
//    public static void P24多路归并Ⅱ(String[] args) throws IOException {
//        int n = sc.nextInt();
//        String s = sc.next();
//        long ans = 0;
//        long cnt = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '0') {//如果当前并进来的数字是0
//                ans = (ans + cnt + 1) % MOD; // 0可以与并在所有非0数的后面 所以答案数量就是加上当前可构成数字的数量再加1 单独的0
//                cnt = (cnt * 2) % MOD; //因为每一个可行数字都并上了一个0 那么可行数字就翻倍 例如：原来有 1 10 并上0 可行数字变为 1 10 10 100 四个 乘以2
//            } else if (s.charAt(i) % 2 == 0) {//如果并入的数字是一个偶数
//                ans = (ans + cnt + 1) % MOD; //并入偶数是可行的 类似与0 可以并在每一个可行数字的后面 变为新的可行数字 1仍然为单独的偶数0
//                cnt = (cnt * 2 + 1) % MOD; //乘以2类似与0 单独加1是因为单独的一个偶数可以作为一个可行数字
//            } else {//如果并入的数字是一个奇数
//                cnt = (cnt * 2 + 1) % MOD; //如果是奇数 可行数字后面并入一个奇数仍然是可行数字 但是并入后构成的数字并不是满足规则的偶数 所以ans不动 cnt*2
//            }
//
//        }
//        out.println(ans);
//
//        out.flush();
//        out.close();
//        br.close();
//    }
//
//
//    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//    static Input sc = new Input(System.in);
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    static class Input {
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public Input(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public String nextLine() {
//            String str = null;
//            try {
//                str = reader.readLine();
//            } catch (IOException e) {
//                // TODO 自动生成的 catch 块
//                e.printStackTrace();
//            }
//            return str;
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        public Double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public BigInteger nextBigInteger() {
//            return new BigInteger(next());
//        }
//    }
}
