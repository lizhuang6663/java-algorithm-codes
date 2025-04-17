package 代码随想录And力扣.string_practice;

//剑指Offer.替换空格
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//示例 1： 输入：s = "We are happy."
//输出："We%20are%20happy."

public class StringDemo3 {

    //方法一：（虽然可以用，但是我们要知道原理）
    public static String replaceSpace(String s) {
        String str =  s.replace(" ", "%20");
        return str;
    }


    //方法二：使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制
    public static String replaceSpace2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            }else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }



    //方法三：双指针法（在给的字符串上修改），从后向前替换空格。
    public String replaceSpace3(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置

        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
