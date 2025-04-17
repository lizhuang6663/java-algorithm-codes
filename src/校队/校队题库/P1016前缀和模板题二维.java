package 校队.校队题库;

import java.io.*;

// 二维前缀和
// 需要使用快速输入读写
public class P1016前缀和模板题二维 {
    public static void main(String[] args) throws IOException {
        Read scanner = new Read(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // 二维前缀和
        long[][] result = new long[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

//            System.out.println(result[x2][y2] - result[x1-1][y1-1]-result[x1-1][y2] - result[x2][y1-1]);
            bw.write(String.valueOf(result[x2][y2] + result[x1 - 1][y1 - 1] - result[x1 - 1][y2] - result[x2][y1 - 1]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

