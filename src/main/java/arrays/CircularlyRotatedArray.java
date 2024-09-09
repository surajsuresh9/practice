package arrays;

import java.util.Arrays;

public class CircularlyRotatedArray {
    public static void main(String[] args) {
        // sort the array (any order)
        // rotate array k times

//        int[] arr = {32, 54, 25, 64, 17, 98, 4, 45, 62, 22, 73};
//        int[] arr = {12, 17, 19, 23, 34, 45};
        int arr[] = {35, 26, 11, 9, 5, 3};
        int k = 3;
        System.out.println("Original: " + Arrays.toString(arr));
        // sort array (descending)
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] < arr[j]) {
//                    int t = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = t;
//                }
//            }
//        }

        System.out.println("Sorted: " + Arrays.toString(arr));
        for (int i = 0; i < k; i++) {
            int first = arr[0];
            for (int c = 0; c < arr.length - 1; c++) {
                arr[c] = arr[c + 1];
            }
            arr[arr.length - 1] = first;
        }
        System.out.println("Anti-clockwise (left) Rotated (" + k + ") times: " + Arrays.toString(arr));

    }


}
