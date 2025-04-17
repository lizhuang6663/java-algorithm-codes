package common.incomplete;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// dp
// 校队：https://ac.nowcoder.com/acm/contest/75906/C
/*
这段代码创建了一个二维数组 f，其大小为 n 行 10 列。每行代表字符串 s 中的一个数字字符（0 到 9），每列代表字符串 s 中该数字字符的下一个位置。

具体解释如下：

int[][] f = new int[n][10];：创建一个二维数组 f，包含 n 行和 10 列，初始化所有元素为 0。

for (int i = 0; i < 10; i++) {：外层循环遍历数字字符的可能取值（0 到 9）。

int ne = -1;：在每次迭代开始时，将 ne 初始化为 -1，表示当前数字字符在字符串 s 中不存在。

for (int j = s.length() - 1; j >= 0; j--) {：内层循环从字符串 s 的最后一个字符开始向前遍历。

f[j][i] = ne;：将数组 f 的第 j 行、第 i 列的值设置为 ne，即当前数字字符 i 在字符串 s 中的下一个位置。

if (s.charAt(j) == i + '0') { ne = j; }：如果当前字符等于数字字符 i 的 ASCII 值加上 '0'，则将 ne 更新为当前位置 j，表示找到了数字字符 i 在字符串 s 中的位置。

通过这个循环，我们可以得到一个二维数组 f，其中 f[j][i] 表示数字字符 i 在字符串 s 中下标为 j 的位置后面的下一个数字字符 i 在字符串 s 中的位置。

 */
public class Num5 {
    public static void main(String[] args) throws IOException {
        Read sc = new Read(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt() + 1;
        int t = sc.nextInt();
        String s = " " + sc.next();


        int[][] f = new int[n][10];
        for (int i = 0; i < 10; i++) {
            int ne = -1;
            for (int j = s.length() - 1; j >= 0; j--) {
                f[j][i] = ne;
                if (s.charAt(j) == i + '0') {  //  s.charAt(j) - '0' == i
                    ne = j;
                }
            }
        }




        while (t-- > 0) {
            String x = sc.nextLong() + "";
            boolean flag = true;
            int idx = 0;
            for (char c : x.toCharArray()) {
                idx = f[idx][c - '0'];
                if (idx == -1) {
                    flag = false;
                    break;
                }
            }
            bw.write(!flag ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
    }
}


class Read {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public Read(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public Double nextDouble() {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
}

/*

11 4
11234567892
22
1
11234567892
73


 */