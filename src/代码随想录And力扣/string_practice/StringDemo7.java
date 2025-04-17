package 代码随想录And力扣.string_practice;


//重复的子字符串:
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

//输入: "abab"  输出: True
//输入: "aba"输出: False
public class StringDemo7 {

    //方法一：移动匹配
    public boolean repeatedSubstringPattern1(String s) { //s=abcabc
        String str = s + s; //str = abcabcabcabc
        str = str.substring(1, str.length()-1);//掐头去尾，str = bcabcabcab
        //掐头去尾后 abcabc 中前面的abc就是 bcabcabcab 中的后面的abc；abcabc中的后面的abc就是 bcabcabcab 中的前面的abc)
        // 如果s是重复的字符串，那么两个s和在一起后掐头去尾，中间一定还会有重复的子字符串
        if (str.contains(s)) return true;
        return false;
    }





}
