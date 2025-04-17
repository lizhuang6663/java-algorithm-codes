package common.homework;

import java.util.*;


// DFS
// 校队：https://ac.nowcoder.com/acm/contest/75588/A


//public class Num19 {
//    static int A获得木头, B, C_PolycarpRecoversthePermutation;
//    static Set<Integer> result = new HashSet<>();
//    static Set<String> set = new HashSet<>();
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        A获得木头 = scanner.nextInt();
//        B = scanner.nextInt();
//        C_PolycarpRecoversthePermutation = scanner.nextInt();
//
//        //A获得木头 B C_PolycarpRecoversthePermutation  8 9 10
//        //一开始只有C装满了咖啡，判断当A空的时候，C中可能包含多少咖啡？找出所有的情况
//
//        dfs(0, 0, C_PolycarpRecoversthePermutation);
//
//        List<Integer> sortedResult = new ArrayList<>(result);
//        Collections.sort(sortedResult);
//        for (int num : sortedResult) {
//            System.out.print(num + " ");
//        }
//    }
//
//
//    private static void dfs(int a, int b, int c) {
//        if (a == 0) {
//            result.add(c);
//        }
//
//        // 生成一个唯一标识，以便进行去重操作
//        String s = (a + "" + b) + c;
//        // 判断当前状态是否已经遍历过，如果遍历过则直接返回
//        if (!set.add(s)) {
//            return;
//        }
//
//        // 从A往B倒
//        if (a + b > 0 && a > 0 && b < B) {
//            int pourAB = Math.min(a, B - b);
//            dfs(a - pourAB, b + pourAB, c);
//        }
//
//        // 从A往C倒
//        if (a + c > 0 && a > 0 && c < C_PolycarpRecoversthePermutation) {
//            int pourAC = Math.min(a, C_PolycarpRecoversthePermutation - c);
//            dfs(a - pourAC, b, c + pourAC);
//        }
//
//        // 从B往A倒
//        if (a + b > 0 && b > 0 && a < A获得木头) {
//            int pourBA = Math.min(b, A获得木头 - a);
//            dfs(a + pourBA, b - pourBA, c);
//        }
//
//        // 从B往C倒
//        if (b + c > 0 && b > 0 && c < C_PolycarpRecoversthePermutation) {
//            int pourBC = Math.min(b, C_PolycarpRecoversthePermutation - c);
//            dfs(a, b - pourBC, c + pourBC);
//        }
//
//        // 从C往A倒
//        if (a + c > 0 && c > 0 && a < A获得木头) {
//            int pourCA = Math.min(c, A获得木头 - a);
//            dfs(a + pourCA, b, c - pourCA);
//        }
//
//        // 从C往B倒
//        if (b + c > 0 && c > 0 && b < B) {
//            int pourCB = Math.min(c, B - b);
//            dfs(a, b + pourCB, c - pourCB);
//        }
//    }
//
//}



// 使用TreeSet，这样就不用再开一个List了
public class Num19 {
    static int A, B, C;
    static Set<Integer> result = new TreeSet<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        dfs(0, 0, C);
        // 使用正则表达式
//        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
        // 或者使用for
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void dfs(int a, int b, int c) {
        String key = a + " " + b + " " + c;
        if (visited.contains(key)) {
            return;
        }

        visited.add(key);

        if (a == 0) {
            result.add(c);
        }

        // 从A往B倒(条件也可以改为：a > 0 && b >= 0 && b < B，后面的同理)
        if (a + b > 0 && a > 0 && b < B) {
            int pourAB = Math.min(a, B - b);
            dfs(a - pourAB, b + pourAB, c);
        }

        // 从A往C倒
        if (a + c > 0 && a > 0 && c < C) {
            int pourAC = Math.min(a, C - c);
            dfs(a - pourAC, b, c + pourAC);
        }

        // 从B往A倒
        if (a + b > 0 && b > 0 && a < A) {
            int pourBA = Math.min(b, A - a);
            dfs(a + pourBA, b - pourBA, c);
        }

        // 从B往C倒
        if (b + c > 0 && b > 0 && c < C) {
            int pourBC = Math.min(b, C - c);
            dfs(a, b - pourBC, c + pourBC);
        }

        // 从C往A倒
        if (a + c > 0 && c > 0 && a < A) {
            int pourCA = Math.min(c, A - a);
            dfs(a + pourCA, b, c - pourCA);
        }

        // 从C往B倒
        if (b + c > 0 && c > 0 && b < B) {
            int pourCB = Math.min(c, B - b);
            dfs(a, b + pourCB, c - pourCB);
        }

    }
}



// 快速输入输出的写法：

//import java.io.*;
//import java.util.*;
//
//public class Num19 {
//
//    // PrintWriter pw 是一个用于输出文本到控制台的工具。通过 pw.print 方法可以将数据打印到控制台上。
//    //class AReader 是一个用于从标准输入流中读取数据的工具类。它封装了 BufferedReader 和 StringTokenizer，可以方便地按照指定格式读取数据，包括字符串、整数、长整数等。
//    //这两个工具类的作用是为了方便程序的输入输出操作。PrintWriter 用于输出结果，AReader 用于读取输入数据。
//    // （BufferedReader 和 BufferedWriter 是 Java 中用于输入和输出的缓冲字符流类，它们可以提高读写效率。）
//    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
//
//    static int mod = (int) (1e9 + 7);
//
//    static Set<Integer> result = new HashSet<>();
//    static int capacityA, capacityB, capacityC;
//
//    static HashSet<String> set = new HashSet<>();
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        AReader sc = new AReader();
//        int n = sc.nextInt();
//        int t = 1;
//        while (t-- > 0) {
//            capacityA = sc.nextInt();
//            capacityB = sc.nextInt();
//            capacityC = sc.nextInt();
//            dfs(0, 0, capacityC);
//            ArrayList<Integer> list = new ArrayList<>(result);
//            Collections.sort(list);
//            for (Integer i : list) {
//                pw.print(i + " ");
//            }
//        }
//        pw.close();
//    }
//
//    public static void dfs(int a, int b, int c) {
//        if (a == 0) {
//            result.add(c);
//        }
//        String s = (a + "" + b) + c;
//        if (!set.add(s)) {
//            return;
//        }
//        // 从A往B倒
//        if (a + b > 0 && a > 0 && b < capacityB) {
//            int pourAB = Math.min(a, capacityB - b);
//            dfs(a - pourAB, b + pourAB, c);
//        }
//
//        // 从A往C倒
//        if (a + c > 0 && a > 0 && c < capacityC) {
//            int pourAC = Math.min(a, capacityC - c);
//            dfs(a - pourAC, b, c + pourAC);
//        }
//
//        // 从B往A倒
//        if (a + b > 0 && b > 0 && a < capacityA) {
//            int pourBA = Math.min(b, capacityA - a);
//            dfs(a + pourBA, b - pourBA, c);
//        }
//
//        // 从B往C倒
//        if (b + c > 0 && b > 0 && c < capacityC) {
//            int pourBC = Math.min(b, capacityC - c);
//            dfs(a, b - pourBC, c + pourBC);
//        }
//
//        // 从C往A倒
//        if (a + c > 0 && c > 0 && a < capacityA) {
//            int pourCA = Math.min(c, capacityA - a);
//            dfs(a + pourCA, b, c - pourCA);
//        }
//
//        // 从C往B倒
//        if (b + c > 0 && c > 0 && b < capacityB) {
//            int pourCB = Math.min(c, capacityB - b);
//            dfs(a, b + pourCB, c - pourCB);
//        }
//
//    }
//
//    static class AReader {
//        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        private StringTokenizer tokenizer = new StringTokenizer("");
//
//        private String innerNextLine() {
//            try {
//                return br.readLine();
//            } catch (IOException ex) {
//                return null;
//            }
//        }
//
//        public boolean hasNext() {
//            while (!tokenizer.hasMoreTokens()) {
//                String nextLine = innerNextLine();
//                if (nextLine == null) {
//                    return false;
//                }
//                tokenizer = new StringTokenizer(nextLine);
//            }
//            return true;
//        }
//
//        public String nextLine() {
//            tokenizer = new StringTokenizer("");
//            return innerNextLine();
//        }
//
//        public String next() {
//            hasNext();
//            return tokenizer.nextToken();
//        }
//
//        public char nextChar() {
//            return next().charAt(0);
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
//    }
//}
