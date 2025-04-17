package 蓝桥杯.JavaB组第14届_1;

public class MainD蜗牛 {
//    static double result = Double.MAX_VALUE;
//    static long[] arr;
//    static int[][] arr2;
//
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        arr = new long[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            arr[i] = scanner.nextLong();
//        }
//
//        arr2 = new int[n][2];
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                arr2[i][j] = scanner.nextInt();
//            }
//        }
//
//        dfs(1, 1, 0);
//        dfs(1, 2, arr2[0][1] * 0.7);
//
//
//        System.out.printf("%.2f", result);
//    }
//
//    /**
//     * @param index  该走第几个arr里面的元素了（index 是 arr的下标，下标从1开始）
//     * @param select 上一次的选择
//     * @param time   花费的时间
//     */
//    public static void dfs(int index, int select, double time) {
//        // 如果这里时间已经 > result 了就直接退出
//        if (time > result) return;
//
//        if (index == arr.length) {
////            if (select == 2) {
////                time += arr2[index - 1][1] * 1.3;
////            }
//
//            result = Math.min(result, time);
//            return;
//        }
//
//
//        // 上一次的选择是沿着坐标走
//        if (select == 1) {
//            // 还是沿着坐标走
//            double temp1 = arr[index] - arr[index - 1];
//            dfs(index + 1, 1, time + temp1);
//
//            // 开始爬竹竿
//            if (index <= arr.length - 1) {
//                // 如果要爬第index根竹竿，这时候要爬第index-1根竹竿，然后传送
//                double temp2 = arr2[index - 1][0] / 0.7;
//                dfs(index + 1, 2, time + temp2);
//            }
//
//        } else if (select == 2) { // 上一次的选择是爬竹竿
//
//            // 还是在竹竿上走
//            // 要爬到竹竿上相应的位置才能传送
//            // Todo
//            if (index <= arr.length - 1) {
//                if (arr2[index - 2][1] >= arr2[index - 1][0]) { // 还要往下爬一点或者不动
//                    dfs(index + 1, 2, time + (arr2[index - 2][1] - arr2[index - 1][0]) / 1.3);
//                } else { // 往上爬
//                    dfs(index + 1, 2, time + (arr2[index - 1][0]) - arr2[index - 2][1] / 0.7);
//                }
//            }
////            else if (index == arr.length - 1) {
////                // 现在到最后一根竹子了，只能往下爬
////                dfs(index + 1, 2, time + arr2[arr2.length - 1][1] / 1.3);
////            }
//
//
//            // 沿着坐标走（先下去，然后走坐标）
//            double temp = arr2[index - 1][1] / 1.3 + (arr[index] - arr[index - 1]);
//            dfs(index + 1, 1, time + temp);
//
//        }
//
//
//    }


}
