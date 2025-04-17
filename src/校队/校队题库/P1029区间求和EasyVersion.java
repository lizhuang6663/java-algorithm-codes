package 校队.校队题库;

import java.util.Scanner;

public class P1029区间求和EasyVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scanner.nextInt();
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long temp = arr[i];
            result += temp;

            for (int j = i+1; j < n; j++) {
                temp += arr[j];
                result += temp;
            }
        }


        System.out.println(result);

    }
}
