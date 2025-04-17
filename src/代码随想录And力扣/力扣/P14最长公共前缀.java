package 代码随想录And力扣.力扣;


// 代码随想录And力扣.力扣：https://leetcode.cn/problems/longest-common-prefix/description/

public class P14最长公共前缀 {
    // 方法一：横向查找
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];


        for (int i = 1; i < strs.length; i++) {
            // 找到共同前缀，并更改前缀
            prefix = longestCommonPrefix(prefix, strs[i]);

            // 如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，因此不需要继续遍历剩下的字符串，直接返回空串即可。
            if (prefix.length() == 0) break;
        }

        return prefix;
    }


    // 找到这两个字符串的共同前缀
    public String longestCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        int i = 0;
        for (; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }

        return str1.substring(0, i);
    }


    // 方法二：纵向查找
//    public String longestCommonPrefix(String[] strs) {
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < strs[0].length(); i++) {
//
//            boolean b = false;
//            for (int j = 0; j < strs.length; j++) {
//                // 如果不符合或者超界了就直接退出
//                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
//                    return result.toString();
//                }
//            }
//
//            result.append(strs[0].charAt(i));
//        }
//
//        return result.toString();
//    }


    // 方法三：二分查找
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int minLength = Integer.MAX_VALUE;
//        // 找到长度最短的字符串
//        for (String str : strs) {
//            minLength = Math.min(minLength, str.length());
//        }
//
//        // 左开右闭
//        int low = 0, high = minLength;
//        while (low < high) {
//            int mid = (high - low + 1) / 2 + low;
//            if (isCommonPrefix(strs, mid)) {
//                low = mid;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return strs[0].substring(0, low);
//    }
//
//    public static boolean isCommonPrefix(String[] strs, int length) {
//        String str0 = strs[0].substring(0, length);
//        int count = strs.length;
//        for (int i = 1; i < count; i++) {
//            String str = strs[i];
//            for (int j = 0; j < length; j++) {
//                if (str0.charAt(j) != str.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
