package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {23, 4, 54, 52, 35, 47, 4, 32, 15, 54, 52, 53, 5, 6, 45, 98};
//        Collections.sort(Arrays.stream(a).boxed().collect(Collectors.toList()));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
        int x = 15;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                System.out.println(x + " found at index: " + mid);
                return;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                // so we decrease our r pointer to mid - 1
            } else if (arr[mid] > x) {
                r = mid - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our l pointer to mid + 1
            } else {
                l = mid + 1;
            }
        }

    }

    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }
}
