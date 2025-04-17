package 代码随想录And力扣.hashtable_practice;

import java.util.HashSet;
import java.util.Set;

//快乐数(不是数学问题)
//判断一个数 n 是不是快乐数。
//「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
//如果 n 是快乐数就返回 True ；不是，则返回 False 。

//示例：
//输入：19  输出：true
//解释：
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1


//这道题目看上去貌似一道数学问题，其实并不是！
//题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
//当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。
//所以这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。

public class HashtableDemo4 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) { //判断是否会重复出现，如果重复出现，说明一定不是快乐数
            set.add(n);//将n记录到set中，这次循环结束后，如果以后又出现了这个数，说明一定不是快乐数
            n = getNextNumber(n);//求和，并改变n的值
        }

        return n == 1;
    }

    //求和
    private int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
}