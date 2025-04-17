package 代码随想录And力扣.图论;

import java.util.*;

// 有向图搜索全路径
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/keys-and-rooms/description/

public class P841钥匙和房间 {
    // 方法一：dfs
    boolean[] visited;
    int num;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        num = 0;
        dfs(rooms, 0);
        return num == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, int key) {
        visited[key] = true;
        num++;

        for (int curKey : rooms.get(key)) {
            if (!visited[curKey]) {
                dfs(rooms, curKey);
            }
        }
    }


    // 繁琐的dfs：
//     Set<Integer> set = new HashSet<>();
//     boolean[] visited;
//
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        int n = rooms.size();
//        visited = new boolean[n];
//
//        visited[0] = true;
//        set.add(0);
//
//        for (int i = 0; i < rooms.get(0).size(); i++) {
//            set.add(rooms.get(0).get(i));
//            dfs(rooms, rooms.get(0).get(i));
//        }
//
//        return set.size() == n;
//    }
//
//    // num 表示索引
//     public void dfs(List<List<Integer>> rooms, int num) {
//        if (visited[num]) return;
//        visited[num] = true;
//
//        for (int i = 0; i < rooms.get(num).size(); i++) {
//            if (visited[rooms.get(num).get(i)]) continue;
//            set.add(rooms.get(num).get(i));
//            dfs(rooms, rooms.get(num).get(i));
//        }
//
//    }


    // 方法二：bfs
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        // bfs
//        boolean[] visited = new boolean[rooms.size()];
//        visited[0] = true;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//
//        while (!queue.isEmpty()) {
//
//            int curKey = queue.poll();
//            for (int key : rooms.get(curKey)) {
//                if (!visited[key]) {
//                    queue.offer(key);
//                    visited[key] = true;
//                }
//            }
//        }
//
//        for (boolean key : visited) {
//            if (!key) {
//                return false;
//            }
//        }
//
//        return true;
//    }

}