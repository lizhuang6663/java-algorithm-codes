package 校队.校队题库.不太理解和做错的;

import java.util.Scanner;

// 错误
public class P1003数学游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];

        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            total += arr[i];
        }

        long min = 0;
        for (int i = 0; i < n; i++) {
            long temp = arr[i];
            min = Math.min(min, temp);

            for (int j = i + 1; j < n && temp <= 0; j++) {
                temp += arr[j];
                min = Math.min(min, temp);
            }
        }

        System.out.println(total - 2 * min);
    }
}



//        BigInteger zero = new BigInteger("0");
//        BigInteger two = new BigInteger("2");
//
//        BigInteger total = new BigInteger("0");
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextLong();
//            total = total.add(new BigInteger(String.valueOf(arr[i])));
//        }
//
//
//        BigInteger minNum = new BigInteger("0");
//        for (int i = 0; i < n; i++) {
//            BigInteger temp = new BigInteger(String.valueOf(arr[i]));
//            minNum = minNum.min(temp);
//
//            for (int j = i + 1; j < n && temp.compareTo(zero) <= 0; j++) {
//                temp = temp.add(new BigInteger(String.valueOf(arr[j])));
//                minNum = minNum.min(temp);
//            }
//        }
//
//        System.out.println(total.subtract(two.multiply(minNum)));

