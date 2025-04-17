package 洛谷.六期.第二周练习;

import java.util.*;


// 注意：选择正确的容器
// 洛谷，蓝桥杯：https://www.luogu.com.cn/problem/P8661?contestId=162817

public class P8661日志统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int id = scanner.nextInt();

            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }

            map.get(id).add(t);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int temp = 1; // 点赞次数
            int id = entry.getKey(); // 存一下id

            List<Integer> time = entry.getValue();
            for (int i = 0; i < time.size(); i++) {

                for (int j = i + 1; j < time.size(); j++) {
                    if (time.get(j) - time.get(i) >= d) {
                        break;
                    } else {
                        temp++;
                    }
                }

                if (temp >= k) {
                    result.add(id);
                    break;
                }
            }

        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}


