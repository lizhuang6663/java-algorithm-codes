package 代码随想录And力扣.hashtable_practice;

import java.util.*;


//两个数组的交集
public class HashtableDemo3 {

    //方法一：使用HashSet
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //遍历数组1
        for (int result : nums1) {
            set1.add(result);
        }

        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        //另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[set2.size()];
        int index = 0;
        for(int result : set2){
            arr[index++] = result;
        }
        return arr;
        //也可以直接 将结果集合 转为 数组
        //return set2.stream().mapToInt(x -> x).toArray();
    }



    //方法二：使用Hash数组，占用内存比较大
    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];//nums1中的各个值出现的次数
        int[] hash2 = new int[1002];//nums2中的各个值出现的次数

        for(int i : nums1) hash1[i]++;
        for(int i : nums2) hash2[i]++;

        List<Integer> resList = new ArrayList<>();

        for(int i = 0; i < 1002; i++)
            if(hash1[i] > 0 && hash2[i] > 0)//nums1和nums2中相同的值都出现过，把都出现过的值添加到list中
                resList.add(i);


        int res[] = new int[resList.size()];
        int index = 0;
        for(int result : resList)
            res[index++] = result;

        return res;
    }

}
