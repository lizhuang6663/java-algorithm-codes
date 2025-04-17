package 代码随想录And力扣.额外题目;


// 数组
// 力扣：https://leetcode.cn/problems/sort-array-by-parity-ii/

public class 数组_P922按奇偶排序数组II {
    // 方法一：模拟。使用两个额外的数组分别存放 nums 中的奇数、偶数
//    public int[] sortArrayByParityII(int[] nums) {
//        int len = nums.length;
//        int[] ji = new int[len / 2];
//        int[] ou = new int[len / 2];
//
//        int indexJi = 0, indexOu = 0;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] % 2 == 0) {
//                ou[indexOu++] = nums[i];
//            } else {
//                ji[indexJi++] = nums[i];
//            }
//        }
//
//        indexJi = 0;
//        indexOu = 0;
//        int[] arr = new int[len];
//        for (int i = 0; i < len; i++) {
//            if (i % 2 == 0) {
//                arr[i] = ou[indexOu++];
//            } else {
//                arr[i] = ji[indexJi++];
//            }
//        }
//
//        return arr;
//    }

    // 方法二：使用一个额外数组
//    public int[] sortArrayByParityII(int[] nums) {
//        int[] arr = new int[nums.length];
//        int even = 0, odd = 1;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 0) {
//                arr[even] = nums[i];
//                even += 2;
//            } else {
//                arr[odd] = nums[i];
//                odd += 2;
//            }
//        }
//        return arr;
//    }


    // 方法三：不采用额外的数组空间，在原数组上修改。双指针
//    public int[] sortArrayByParityII(int[] nums) {
//        int oddPoint = 1, evenPoint = 0;
//
//        //开始移动并交换，最后一层必然为相互交换后再移动或者相同直接移动
//        while (oddPoint < nums.length && evenPoint < nums.length) {
//            //进行判断
//            if (nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 1) { // 如果这两个位置可以交换
//                // 交换 nums[oddPoint] 和 nums[evenPoint]
//                int temp = nums[oddPoint];
//                nums[oddPoint] = nums[evenPoint];
//                nums[evenPoint] = temp;
//                oddPoint += 2;
//                evenPoint += 2;
//            } else if (nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 0) {  //偶数满足
//                evenPoint += 2;
//            } else if (nums[oddPoint] % 2 == 1 && nums[evenPoint] % 2 == 1) {  //奇数满足
//                oddPoint += 2;
//            } else {
//                oddPoint += 2;
//                evenPoint += 2;
//            }
//        }
//        return nums;
//    }

    // 优化：
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 0;
        for(int i = 1; i < nums.length; i+=2){
            if (nums[i] % 2 == 0){ // 当前是偶数
                while (nums[oddIndex] % 2 == 0){ // 找到奇数
                    oddIndex+=2;
                }
                // 偶数和奇数互换位置
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

}
