package 代码随想录And力扣.贪心;

import java.util.Arrays;

// 贪心
// 力扣：https://leetcode.cn/problems/assign-cookies/description/
public class P455分发饼干 {

    // 方法一：优先考虑胃口，先喂饱大胃口，遍历胃口
    // 局部最优：大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优：喂饱尽可能多的小孩。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        if (s.length == 0) return 0;
        if (s[s.length-1] < g[0]) return 0;

        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }


    // 方法二：优先考虑饼干，小饼干先喂饱小胃口，遍历饼干
//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//
//        if (s.length == 0) return 0;
//        if (s[s.length-1] < g[0]) return 0;
//
//        int start = 0;
//        int count = 0;
//        for (int i = 0; i < s.length && start < g.length; i++) {
//            if (s[i] >= g[start]) {
//                start++;
//                count++;
//            }
//        }
//        return count;
//    }


}
