package 青训营.豆包;


// 递归
public class 数字分组求偶数和 {
    public static int solution(int[] numbers) {
        // 将每个整数转换为字符串数组
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        return digui(strNumbers, 0, 0);
    }

    // 递归
    private static int digui(String[] numbers, int index, int currentSum) {
        // 如果遍历完所有的数字组,判断总和是否为偶数
        if (index == numbers.length) {
            return (currentSum % 2 == 0) ? 1 : 0;
        }

        int count = 0;
        String group = numbers[index];
        // 遍历当前数字组中的每个数字
        for (char ch : group.toCharArray()) {
            int digit = ch - '0';
            // 递归处理下一个数字组
            count += digui(numbers, index + 1, currentSum + digit);
        }
        return count;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }
}
