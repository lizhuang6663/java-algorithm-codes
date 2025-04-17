package 代码随想录And力扣.回溯;

import java.util.*;

// dfs，回溯
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/reconstruct-itinerary/description/

// 难点：
// 1.一个行程中，如果航班处理不好容易变成一个圈，成为死循环
// 2.有多种解法，字母序靠前排在前面，让很多同学望而退步，如何该记录映射关系呢 ？
// 3.使用回溯法（也可以说深搜） 的话，那么终止条件是什么呢？
// 4.搜索的过程中，如何遍历一个机场所对应的所有机场。

public class P332重新安排行程 {

    // 方法一：代码随想录And力扣：回溯（最后一个案例超出时间限制）
    boolean[] isUsed;
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        isUsed = new boolean[tickets.size() + 1];

        // 这个排序规则是根据 List<String> 的第二个元素的字典顺序来排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));

        path.add("JFK");
        backTracking(tickets);

        return path;
    }

    public boolean backTracking(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            // 尾巴对上头
            if (!isUsed[i] && path.get(path.size() - 1).equals(tickets.get(i).get(0))) {
                isUsed[i] = true;
                path.add(tickets.get(i).get(1));

                // 为什么之前的回溯返回值都是void，但是这里要返回boolean？因为这道题只需要一条路线，当我们找到一条路线后，
                // 返回的是true，就可以直接退出了（找到的第一条正确的路线是字典集靠前的，因为前面排过序），如果返回的是false，就不退出，接着进行for循环。
                if (backTracking(tickets)) {
                    return true;
                }

                isUsed[i] = false;
                path.removeLast();
            }

        }
        return false;
    }




    // 方法二：dfs；使用 map 和 PriorityQueue优先队列 存数据
    // 构造图，key是始发地，value是目的地，目的地用PriorityQueue存放，就可以自动按升序排序了（PriorityQueue是优先队列会自动将数据排序）
//    Map<String, PriorityQueue<String>> map = new HashMap<>();
//    // 用链表来记录路线
//    List<String> res = new LinkedList<>();
//
//    public List<String> findItinerary(List<List<String>> tickets) {
//        // 遍历所有的机票，把票的起止信息都存到map里面
//        for (List<String> ticket : tickets) {
//            // 把票的始发地和目的地拆开存。src source 始发地 dest destination 目的地。 也可用start 和 end
//            String src = ticket.get(0), dest = ticket.get(1);
//            // 这里要注意，首次存入需要新建优先队列，然后执行入队操作 add/offer 都可
//            if (!map.containsKey(src)) {
//                map.put(src, new PriorityQueue<String>()); // 这个写法要记一下
//            }
//            map.get(src).add(dest); // 往优先队列里添加元素，自动升序排序
//        }
//        dfs("JFK"); // 从起点开始深度优先搜索
//        Collections.reverse(res); // 反转链表，最先找到的是最深的不能再走的目的地，所以要反转过来
//        return res;
//    }
//
//    public void dfs(String src) {
//        // 当传入的参数是始发地而且还有边的时候，取边出队删除并且继续递归深搜这条边的点，一直到不能再走再返回
//        // while 循环当优先队列里面没有数据就是退出循环的时候
//        while (map.containsKey(src) && map.get(src).size() > 0) {
//            dfs(map.get(src).poll()); // 需要删除，否则可能出现死循环
//        }
//        // 没有子递归可以调用时，递归函数开始返回，把搜过的点一次加到结果集的路线里
//        res.add(src);
//    }

}