package 代码随想录And力扣.string_practice;


//字符串1:反转字符串
//将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//必须原地修改输入数组
public class StringDemo1 {
    // 使用异或运算符
    public void reverseString1(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }



    public void reverseString2(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            right--;
            left++;
        }

    }
}
