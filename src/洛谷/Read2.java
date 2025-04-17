package 洛谷;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class Read2 {
    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}
