package 代码随想录And力扣.hashtable_practice;



//赎金信
//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
//题目说明：杂志字符串中的每个字符只能在赎金信字符串中使用一次。

//注意：
//两个字符串均只含有小写字母。
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true

public class HashtableDemo7 {

    //方法一：暴力法，每从magazine中匹配到ransomNote中的一个字符，就删除ransomNote中所匹配到的字符（截取字符串）
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < magazine.length(); i++) {
            for (int j = 0; j < ransomNote.length(); j++) {
                if (magazine.charAt(i) == ransomNote.charAt(j)) {
                    ransomNote = ransomNote.substring(0, j) + ransomNote.substring(j+1);
                }
            }
        }
        return ransomNote.length() == 0;
    }



    //方法二：使用数组
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] arr = new int[26];

        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int i : arr) {
            if (i > 0) return false; //如果i > 0 说明ransomNote中还有没有匹配的字符
        }
        return true;
    }


}
