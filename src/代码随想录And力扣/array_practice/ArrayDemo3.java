package 代码随想录And力扣.array_practice;

//数组3:移除元素
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

public class ArrayDemo3 {

    //方法一：暴力解法
    //数组在内存空间的地址是连续的，所以我们在删除或者增添元素的时候，就难免要移动其他元素的地址。
    //数组的元素是不能删的，只能覆盖。
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0;i<size; i++){
            if (nums[i] == val) {
                for (int j = i+1;j<size; j++){
                    nums[j-1] = nums[j];// nums[i] = nums[j];
                }

                //或者：
//                for (int j = i;j<size-1;j++) {
//                    nums[j] = nums[j+1];
//                }

                i--;
                size--;
            }
        }
        return size;
    }


    //方法二：双指针法（快慢指针）
    //双指针法（快慢指针法）：通过一个快指针和慢指针在一个for循环下完成两个for循环的工作
    public int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int quickIndex = 0; quickIndex<nums.length; quickIndex++){
            if (nums[quickIndex] != val) {
                nums[slowIndex] = nums[quickIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }


    //方法三：相向指针法
    public int removeElement3(int[] nums, int val) {
       int leftIndex = 0, rightIndex = nums.length-1;
       while (leftIndex <= rightIndex){
           //从左边找到等于val的值，然后换掉
           while (leftIndex<=rightIndex && nums[leftIndex] != val) leftIndex++;
           //从右边找到不等于val的值，然后换给左边
           while (leftIndex<=rightIndex && nums[rightIndex] == val) rightIndex--;

           if (leftIndex < rightIndex) {
               nums[leftIndex] = nums[rightIndex];
               leftIndex++;
               rightIndex--;
           }
       }
        return leftIndex;
    }


}


