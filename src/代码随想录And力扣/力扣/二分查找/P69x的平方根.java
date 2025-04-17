package 代码随想录And力扣.力扣.二分查找;


// 二分查找
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/sqrtx/

public class P69x的平方根 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) >> 1;

            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;

        // 或者直接
//        return (int) Math.sqrt(x);
    }


    // 方法二：
//    public int mySqrt(int x) {
//        long a = 0;
//        for(long i=0;i*i<=x;i++){
//            a=i;
//        }
//        return (int)a;
//    }

}
