package common.homework;

import java.io.*;

// 判断奇数还是偶数
// 校队：https://ac.nowcoder.com/acm/contest/75906/B

public class Num22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(n);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            // 看一个数是否可以被4整除，看最后两位数
            // 4，8，12，16 .... 96，100，104，108...

            int temp = 0;
            if (str.length() > 2) {
                temp = Integer.parseInt(str.substring(str.length() - 2));
            } else {
                temp = Integer.parseInt(str);
            }

            temp %= 4;
            if (temp == 3 || temp == 0) {  // temp == 0：4，8，12...   temp == 3：7，15...
                bw.write("even\n");
            } else {
                bw.write("odd\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
