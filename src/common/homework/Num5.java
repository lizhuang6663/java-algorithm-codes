package common.homework;

import java.util.*;

//对数组排序，求每个数的差值最大的情况
//https://www.matiji.net/exam/brushquestion/4/4009/C448715ED43BEA9D2D47CED523050945

public class Num5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = new int[n];
        Arrays.sort(arr);

        int left = 0, right = arr.length-1;
        int index = 0;
        while (index < result.length && left <= right) {
            result[index++] = arr[left];

            if (index >= result.length) break;  //当数组的长度为奇数时的特殊情况，result[index++] = arr[right] 中的index要超出界限

            result[index++] = arr[right];
            left++;
            right--;
        }




        //不正确
//        //长度为奇数时
//        int left , right;
//        int left2 , right2;//result的下标
//
//        if (arr.length % 2 == 0) {
//            //奇数时
//            left = 0;
//            right = arr.length-1;
//            left2 = result.length/2-1;
//            right2 = result.length/2;
//        }else {
//            result[result.length/2] = arr[arr.length-1];//最大值放result的中间
//
//            left = 0;
//            right = arr.length-2;
//            left2 = result.length/2-1;
//            right2 = result.length/2+1;
//        }
//
//
//        int temp = 1;
//        while (left < right) {
//            if (temp == 1) {
//                result[left2] = arr[left];
//                result[right2] = arr[right];
//            }else {
//                result[left2] = arr[right];
//                result[right2] = arr[left];
//            }
//
//            left++;
//            right--;
//            left2--;
//            right2++;
//            temp *= -1;
//        }



//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        int sum = 0;
        for (int i = 1; i < result.length; i++) {
            sum += Math.abs(result[i] - result[i-1]);
        }

        sum += Math.abs(result[result.length-1] - result[0]);
        System.out.println(sum);

    }
}
