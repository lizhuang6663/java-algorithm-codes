package 校队.Codeforces;

import java.io.*;

// 只有一个快速读 int 类型
public class Read {
    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}