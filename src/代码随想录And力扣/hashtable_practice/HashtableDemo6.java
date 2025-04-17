package 代码随想录And力扣.hashtable_practice;

import java.util.*;

//四数相加II(使用哈希法的经典题目，和 两数之和 相似)
//给定四个包含整数的数组列表 Num19 , B , C_PolycarpRecoversthePermutation , D ,计算有多少个元组 (i, j, k, l) ，使得 Num19[i] + B[j] + C_PolycarpRecoversthePermutation[k] + D[l] = 0。
//为了使问题简单化，所有的 Num19, B, C_PolycarpRecoversthePermutation, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

//例如:
//输入:Num19 = [ 1, 2]
//B = [-2,-1]
//C_PolycarpRecoversthePermutation = [-1, 2]
//D = [ 0, 2]
//输出:2

public class HashtableDemo6 {
    //暴力方法：使用四个for循环，会超时

    /**
     * 首先定义 map。key放a和b两数之和，value 放a和b两数之和出现的次数。遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value，也就是出现次数统计出来。
     * 最后返回统计值 count 就可以了
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {

                int temp = i + j;
                map.put(temp, map.getOrDefault(temp, 0) + 1);//map.getOrDefault(temp, 0) 如果temp所对应的value不存在，那么默认返回0

                //也可以，不过速度比较慢：
//                int temp = i + j;
//                if (map.containsKey(temp)) {
//                    int tt = map.get(temp);
//                    map.put(temp, tt + 1);
//                }else {
//                    map.put(temp, 1);
//                }
            }
        }

        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                count += map.getOrDefault(-i - j, 0);

//                int temp = - i - j;
//                if (map.containsKey(temp)) count += map.get(temp);
            }
        }
        return count;
    }
}



