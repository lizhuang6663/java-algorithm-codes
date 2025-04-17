package 代码随想录And力扣.贪心;

import java.util.*;

public class P406根据身高重建队列 {
    // 遇到两个维度权衡的时候，一定要先确定一个维度，再确定另一个维度。如果两个维度一起考虑一定会顾此失彼。我们应该先先确定身高维度，然后再确定人数维度

    //按照身高排序之后，优先按身高高的people的k来插入，后序插入节点也不会影响前面已经插入的节点，最终按照k的规则完成了队列。
    // 所以在按照身高从大到小排序后：
    // 局部最优：优先按身高高的people的k来插入。插入操作过后的people满足队列属性全局最优：最后都做完插入操作，整个队列满足题目队列属性
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a[1] - b[1] 是升序排列，故在a[0] == b[0]的状况下，会根据k值升序排列
            return -(a[0] - b[0]);   // - (a[0]-b[0]) 是降序排列，在a[0] != b[0]，的状况会根据h值降序排列
        });

        // 或者：
        /*

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });

         */

        LinkedList<int[]> que = new LinkedList<>();
        // 用 List 也可以
//        List<int[]> que = new ArrayList<>();
        for (int[] p : people) {
            que.add(p[1], p);   // Linkedlist.add(index, value)，会将value插入到指定的 index 索引位置。
        }

        return que.toArray(new int[people.length][]);
    }


    // 不使用列表
//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, new Comparator<int[]>() {
//            public int compare(int[] person1, int[] person2) {
//                if (person1[0] != person2[0]) {
//                    return person1[0] - person2[0];
//                } else {
//                    return person2[1] - person1[1];
//                }
//            }
//        });
//        int n = people.length;
//        int[][] ans = new int[n][];
//        for (int[] person : people) {
//            int spaces = person[1] + 1;
//            for (int i = 0; i < n; ++i) {
//                if (ans[i] == null) {
//                    --spaces;
//                    if (spaces == 0) {
//                        ans[i] = person;
//                        break;
//                    }
//                }
//            }
//        }
//        return ans;
//    }

}
