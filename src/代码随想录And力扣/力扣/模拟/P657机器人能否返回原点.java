package 代码随想录And力扣.力扣.模拟;

// 模拟
// 力扣：https://leetcode.cn/problems/robot-return-to-origin/description/

public class P657机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] chars = moves.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                x++;
            } else if (chars[i] == 'L') {
                x--;
            } else if (chars[i] == 'U') {
                y++;
            } else if (chars[i] == 'D') {
                y--;
            }
        }

        return x == 0 && y == 0;
    }
}
