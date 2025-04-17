package 代码随想录And力扣.贪心;

// 贪心
// 力扣：https://leetcode.cn/problems/lemonade-change/description/

public class P860柠檬水找零 {
    // 局部最优：遇到账单20，优先消耗美元10，完成本次找零。全局最优：完成全部账单的找零。
//    public boolean lemonadeChange(int[] bills) {
//        int num5 = 0, num10 = 0;
//
//        if (bills[0] != 5) return false;
//
//        for (int i = 0; i < bills.length; i++) {
//            if (bills[i] == 5) {
//                num5++;
//
//            } else if (bills[i] == 10) {
//                num10++;
//                if (num5 >= 1) {
//                    num5--;
//                } else {
//                    return false;
//                }
//
//            } else if (bills[i] == 20) {
//                // 先花10元的钱，然后花5元的钱
//                if (num10 >= 1 && num5 >= 1) { // 1张10元，1张5元
//                    num10--;
//                    num5--;
//                } else if (num10 <= 0 && num5 >= 3) { // 3张5元
//                    num5 -= 3;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // 优化代码：
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }

}
