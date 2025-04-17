package 代码随想录And力扣.力扣;


// 力扣：https://leetcode.cn/problems/next-greater-element-iii/description/
// 相同类型的题目：P31下一个排列，力扣：https://leetcode.cn/problems/next-permutation/description/

public class P556下一个更大元素III {

    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }

        int left = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                left = i - 1;
                break;
            }
        }

        int right = 0;
        for (int i = nums.length - 1; i > left; i--) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }

        // 把这两个数字换一下位置
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        // 反转left后面的数字
        reverse(nums, left + 1, nums.length - 1);

        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result * 10 + nums[i];
        }

        // 没有找到合适的right，或者数据超出界限
        if (right == 0 || result > Integer.MAX_VALUE || result < 0) {
            return -1;
        }

        return (int) result;
    }


    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
