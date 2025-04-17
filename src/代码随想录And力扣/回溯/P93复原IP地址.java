package 代码随想录And力扣.回溯;

import java.util.ArrayList;
import java.util.List;

// 回溯：切割问题
// 代码随想录And力扣.力扣：https://leetcode.cn/problems/restore-ip-addresses/description/
// 在for (int i = startIndex; i < s.size(); i++)循环中 [startIndex, i] 这个区间就是截取的子串，需要判断这个子串是否合法。
// 如果合法，就...，不合法就退出循环break，因为后面直接就不用判断了

public class P93复原IP地址 {


    // 方法一：声明一个StringBuilder，在StringBuilder身上增减 子字符串 和 "."
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);

        return result;
    }

    // point：需要三个点，也就是需要分割成四段
    public void backTracking(String s, int startIndex, int point) {
        if (point == 3) {

            if (judgeString(s.substring(startIndex))) {
                path.append(s.substring(startIndex));
                result.add(path.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            String temp = s.substring(startIndex, i + 1);

            // 如果合法
            if (judgeString(temp)) {
                path.append(temp);
                path.append(".");

                backTracking(s, i + 1, point + 1);

                // 注意：应该是 startIndex，而不是 i
                path.delete(startIndex + point, path.length());

                // 或者：
//                int index = path.lastIndexOf(temp + ".");
//                path.delete(index, path.length());

            } else { // 不合法，直接结束本层循环
                break;
            }

        }
    }

    // 判断子字符串是否合法
    public boolean judgeString(String str) {
        if (str.length() == 1) {
            return true;
        }

        if (str.length() == 0 || str.charAt(0) == '0' || Long.parseLong(str) > 255) {
            return false;
        }

        return true;
    }


    // 方法二：代码随想录And力扣：直接在传递的参数字符串上做手脚
    // 如果合法就在字符串后面加上符号.表示已经分割，如果不合法就结束本层循环。
//    List<String> result = new ArrayList<>();
//
//    public List<String> restoreIpAddresses(String s) {
//        // 剪枝
//        if (s.length() > 12) return result;
//
//
//        StringBuilder path = new StringBuilder(s);
//        backTracking(path, 0, 0);
//
//        return result;
//    }
//
//    public void backTracking(StringBuilder s, int startIndex, int point) {
//        if (point == 3) {
//            if (isValid(s, startIndex, s.length() - 1)) {
//                result.add(s.toString());
//            }
//            return;
//        }
//
//
//        for (int i = startIndex; i < s.length(); i++) {
//            if (isValid(s, startIndex, i)) {
//                s.insert(i + 1, "."); // 这个子字符串符合规范，在这个子字符串后面加上 "."
//
//                // 因为多加了一个 "."， 所以下一个递归的开始位置是 i+2
//                backTracking(s, i + 2, point + 1);
//
//                s.deleteCharAt(i + 1);
//            }
//
//        }
//
//
//    }
//
//    private boolean isValid(StringBuilder s, int start, int end) {
//        if (start > end) return false;
//
//        if (s.charAt(start) == '0' && start != end) return false;
//
//        int num = 0;
//        // 防止数据范围超界
//        for (int i = start; i <= end; i++) {
//            int digit = s.charAt(i) - '0';
//            num = num * 10 + digit;
//            if (num > 255)
//                return false;
//        }
//
//        return true;
//    }



    // 方法三：比上面的方法时间复杂度低，更好地剪枝，优化时间复杂度
//    List<String> result = new ArrayList<String>();
//    StringBuilder stringBuilder = new StringBuilder();
//
//    public List<String> restoreIpAddresses(String s) {
//        restoreIpAddressesHandler(s, 0, 0);
//        return result;
//    }
//
//    // number表示stringbuilder中ip段的数量
//    public void restoreIpAddressesHandler(String s, int start, int number) {
//        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
//        if (start == s.length() && number == 4) {
//            result.add(stringBuilder.toString());
//            return;
//        }
//        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
//        if (start == s.length() || number == 4) {
//            return;
//        }
//        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
//        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
//                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
//            // 如果ip段的长度大于1，并且第一位为0的话，continue
//            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
//                continue;
//            }
//            stringBuilder.append(s.substring(start, i + 1));
//            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
//            if (number < 3) {
//                stringBuilder.append(".");
//            }
//            number++;
//            restoreIpAddressesHandler(s, i + 1, number);
//            number--;
//            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
//            stringBuilder.delete(start + number, i + number + 2);
//        }
//    }

}
