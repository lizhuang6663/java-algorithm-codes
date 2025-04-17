package 代码随想录And力扣.hashtable_practice;

import java.util.*;

//两数之和
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

//示例:
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9,所以返回 [0, 1]

public class HashtableDemo5 {

    //方法一：暴力
    public int[] twoSum1(int[] nums, int target) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }
        return new int[]{index1, index2};
    }



    //方法二：使用Map，key来存数据元素，value来存下标，
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key

            if(map.containsKey(temp)){ //如果找到了我们需要的另一半值，就把这两个值的下标存到数组中，并退出循环(key不能重复，如果返回true，说明map里面存在我们要的值)
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }


}
