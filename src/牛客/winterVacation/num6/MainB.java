package 牛客.winterVacation.num6;

import java.util.Arrays;
import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

//        int result[] = arr1;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        // 时间复杂度：O(n^2)
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int diff = arr1[i] - arr2[j];
//                if (Math.abs(diff)< min) {
//                    min = Math.abs(diff);
//                    minIndex = i;
//                }
//            }
//        }

        // 时间复杂度：O(nlogn) O(n^2)
        int l = 0, r = 0;
        while (l < n && r < n) {
            int diff = arr1[l] - arr2[r];
            if (Math.abs(diff) < min) {
                min = Math.abs(diff);
                minIndex = l;
            }
            if (diff < 0) {
                l++;
            } else {
                r++;
            }
        }



//        for (int i = 0; i < n; i++) {
//            if (i != minIndex) {
//                int temp = arr1[i];
//                result[i] = result[minIndex];
//                result[minIndex] = temp;
//                break;
//            }
//        }
//
//        for (int j = 0; j < n; j++) {
//            System.out.print(result[j] + " ");
//        }


        for (int i = 0; i < n; i++) {
            if (i != minIndex) {
                int temp = arr1[i];
                arr1[i] = arr1[minIndex];
                arr1[minIndex] = temp;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(arr1[j] + " ");
        }

    }
}

/*

3
2 6 4
1 3 5

2 4 6


3
1 2 4
4 5 6

4 2 1


4
1 2 4 5
11 11 15 16

5 2 4 1

 */
