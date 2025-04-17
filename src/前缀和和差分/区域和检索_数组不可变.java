package 前缀和和差分;


//一维前缀和（下标熟练度考察）
//代码随想录And力扣.力扣： https://leetcode.cn/problems/range-sum-query-immutable/description/

class NumArray {
    //方法一：
    int sums [] ;
    public NumArray(int[] nums) {
        sums = new int[nums.length+1];

        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                //sums从下标从1开始正式赋值
                sums[i+1] = sums[i] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }



    //方法二：（下标不同，sums是从0开始有值）
    /*
    int sums [] ;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[0] = nums[0];
            }else {
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return sums[right];
        return sums[right] - sums[left-1];
    }
     */

}

