package common.homework;

import java.io.*;

// 输入数据量多，选择较快的读写方式
// 校队：https://ac.nowcoder.com/acm/contest/75906/A
public class Num21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {

            String str = br.readLine();
            long l = 0;
            for (int j = 0; j < str.length(); j++) {
                l += str.charAt(j) - '0';
            }

            bw.write(l % 3 == 0 ? "YES" : "NO");
            bw.write("\n");
//            System.out.println(l % 3 == 0 ? "YES" : "NO");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}

/*

5
1000
999
0
10
99


 */