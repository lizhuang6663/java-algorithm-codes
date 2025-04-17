package 青训营.豆包;


import java.util.HashMap;
import java.util.Map;

// 签到
public class 找出整型数组中占比超过一半的数 {
    public static int solution(int[] array) {
        // 创建一个 HashMap 来存储每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，将元素及其出现次数存入 map
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int result = 0;
        // 遍历 map，查找出现次数大于数组长度一半的元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试样例
        int[] array1 = {1, 2, 3, 2, 2};
        int[] array2 = {4, 4, 4, 4, 3, 2, 1};
        int[] array3 = {5, 5, 5, 6, 6, 5};

        System.out.println(solution(array1)); // 输出 2
        System.out.println(solution(array2)); // 输出 4
        System.out.println(solution(array3)); // 输出 5
    }
}

