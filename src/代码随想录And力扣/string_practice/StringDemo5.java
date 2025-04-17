package 代码随想录And力扣.string_practice;


//剑指Offer58-II.左旋转字符串
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

public class StringDemo5 {

    //方法一：
    public String dynamicPassword1(String password, int target) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = target; i < password.length(); i++) {
            stringBuilder.append(password.charAt(i));
        }

        for (int i = 0; i < target; i++) {
            stringBuilder.append(password.charAt(i));
        }
        return stringBuilder.toString();
    }


    //方法二：使用substring()
    public String dynamicPassword2(String password, int target) {
        return password.substring(target) + password.substring(0, target);
    }



    /**
     * 方法三：
     * 难度提升：1.不能申请额外空间，只能在本串上操作，不要使用辅助空间，空间复杂度要求为O(1)。
     *         2.不使用Java内置方法实现（局部反转+整体反转就可以实现反转顺序的目的）
     */
    public String dynamicPassword3(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        //例子：输入: s = "abcdefg", k = 2
        reverseString(sb,0,n-1);//先翻转前n个 --> bacdefg
        reverseString(sb,n,len-1);//再翻转n到最后的字符 --> bagfedc
        return sb.reverse().toString();//最后整体翻转 --> cdefgab
    }
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
