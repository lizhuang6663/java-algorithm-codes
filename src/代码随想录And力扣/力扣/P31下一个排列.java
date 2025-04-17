package 代码随想录And力扣.力扣;

// 代码随想录And力扣.力扣：https://leetcode.cn/problems/next-permutation/description/
// 题解：https://leetcode.cn/problems/next-permutation/solutions/1/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
// https://leetcode.cn/problems/next-permutation/solutions/479151/xia-yi-ge-pai-lie-by-leetcode-solution/

public class P31下一个排列 {

    // 123456 的 下一个更大的整数为 123465 -> 123546 -> 123564 -> 123645 -> 123654 ....

    // 1.我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
    // 2.我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
    //  a.在 尽可能靠右的低位 进行交换，需要 从后向前 查找
    //  b.将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
    //  c.将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；
    // 然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列

    public void nextPermutation(int[] nums) {

        // 找到要交换的位置1
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        // 找到要交换的位置2
        int right = nums.length - 1;
        if (left >= 0) {

            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }

            // 把这两个位置的值交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        // 反转 left 后面的数组（注意：left 要 +1，）
        reverse(nums, left + 1);
    }


    // 反转数组的后部分
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
