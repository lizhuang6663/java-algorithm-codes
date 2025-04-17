package 代码随想录And力扣.回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 回溯：全排列问题，使用了标记数组
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/?spm=a2c6h.12873639.article-detail.9.394f50a7xxa6Xn

// 相同类型题目：
// P46全排列：回溯，使用了标记数组
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/permutations/description/

public class LCR157套餐内商品的排列顺序 {

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] isUsed;

    public String[] goodsOrder(String goods) {
        isUsed = new boolean[goods.length()];

        // 给字符串按从大到小排序，为了去重
        char[] chars = goods.toCharArray();
        Arrays.sort(chars);
        goods = new String(chars);

        backTracking(goods);

        // 将 list 转换为字符串数组
        return result.toArray(new String[result.size()]);
    }

    public void backTracking(String goods) {
        if (path.length() == goods.length()) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < goods.length(); i++) {

            if (isUsed[i]) continue; // 这个位置的字母使用过

            // 如果案例给的字符串中出现了多个相同的字母，在这里要去重，跳过这次循环
            if (i > 0 && goods.charAt(i) == goods.charAt(i - 1) && !isUsed[i - 1]) continue;

            path.append(goods.charAt(i));
            isUsed[i] = true;

            backTracking(goods);

            isUsed[i] = false;
            path.deleteCharAt(path.length() - 1);
        }

    }




}
