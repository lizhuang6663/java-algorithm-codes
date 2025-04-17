package 蓝桥杯.第13届;

// 二维前缀和
// 蓝桥杯：https://www.lanqiao.cn/paper/3876/problem/2485/

public class MainF最大子矩阵 {
    public static void main(String[] args) {
        System.out.println(154);

        int[][] arr = new int[21][21];
        String str = "69859241839387868941" +
                "17615876963131759284" +
                "37347348326627483485" +
                "53671256556167864743" +
                "16121686927432329479" +
                "13547413349962773447" +
                "27979945929848824687" +
                "53776983346838791379" +
                "56493421365365717745" +
                "21924379293872611382" +
                "93919353216243561277" +
                "54296144763969257788" +
                "96233972513794732933" +
                "81443494533129939975" +
                "61171882988877593499" +
                "61216868895721348522" +
                "55485345959294726896" +
                "32124963318242554922" +
                "13593647191934272696" +
                "56436895944919899246";
        int index = 0;

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                arr[i][j] = Integer.parseInt(str.substring(index, ++index));
            }
        }


        // 前缀和
        int[][] prefix = new int[21][21];
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(prefix[i][j] + "   ");
            }
            System.out.println();
        }


        int max = Integer.MIN_VALUE;
        max = Math.max(prefix[5][5], max);
        System.out.println(max);
        for (int i = 5; i < 21; i++) {
            for (int j = 5; j < 21; j++) {
                int temp = prefix[i][j] - prefix[i - 5][j] - prefix[i][j - 5] + prefix[i - 5][j - 5];
                max = Math.max(max, temp);
            }
        }

        System.out.println(max); // 154
    }
}
