package 代码随想录And力扣.图论;

import java.util.*;

// 无向图求最短路，广搜最为合适，广搜只要搜到了终点，那么一定是最短的路径。(需要用标记位，标记着节点是否走过，否则就会死循环)
// bfs
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/word-ladder/description/

// 问题：
// 1.单词与单词之间如何连在一起的
// 2.起点和终点的最短路径长度

public class P127单词接龙 {

    // 方法一：bfs
    // beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    // 广搜是这样的：hit -> hot -> dot,lot -> dog  log
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }

        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);

        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词

            int path = map.get(word); //获取到该单词的路径长度

            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换

                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
    }


    // 方法二：可以用双向BFS，就是从头尾两端进行搜索
    // ...

}

