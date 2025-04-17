package 代码随想录And力扣.hashtable_practice;

import java.util.*;

//有效的字母异位词
//当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法。如果在做面试题目的时候遇到需要判断一个元素是否出现过的场景也应该第一时间想到哈希法！
//哈希法也是牺牲了空间换取了时间，因为我们要使用额外的数组，set或者是map来存放数据，才能实现快速的查找。
//哈希：包含数组，set，map

public class HashtableDemo2 {

    //方法一：使用数组
    public boolean isAnagram1(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {    // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        // record数组所有元素都为零0，说明字符串s和t是字母异位词
        return true;
    }


    //方法二：分开每个字符，，分别比较
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        String[] splitS = s.split("");
        String[] splitT = t.split("");
        Arrays.sort(splitS);
        Arrays.sort(splitT);
        for (int i = 0; i < splitS.length; i++) {
            if (!splitS[i].equals(splitT[i])){
                return false;
            }
        }
        return true;
    }

}
