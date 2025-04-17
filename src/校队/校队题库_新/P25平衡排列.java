package 校队.校队题库_新;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 枚举
// 校队题库：http://154.37.212.21/p/P25
// 讲解视频：【2024河南科技学院新生训练赛(三)-哔哩哔哩】 https://b23.tv/lnxprmL

public class P25平衡排列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();

            if (n % 4 == 0) {

                for (int j = 1; j <= n; j++) {
                    if (j % 4 == 0 || j%4 == 1) {
                        left.add(j);
                    }else {
                        right.add(j);
                    }
                }

            }else if (n % 4 == 1) {

                System.out.println(-1);
                continue;

            }else if  (n % 4 == 2) {

                System.out.println(-1);
                continue;

            }else if  (n % 4 == 3) {

                left.add(1);
                left.add(2);
                right.add(3);
                // 从4开始，因为1、2、3已经被left和right瓜分了
                for (int j = 4; j <= n; j++) {
                    if (j % 4 == 0 || j%4 == 3) {
                        left.add(j);
                    }else {
                        right.add(j);
                    }
                }

            }

            for (int j = 0; j < left.size(); j++) {
                System.out.print(left.get(j) + " ");
            }
            for (int j = 0; j < right.size(); j++) {
                System.out.print(right.get(j) + " ");
            }

        }
    }
}
