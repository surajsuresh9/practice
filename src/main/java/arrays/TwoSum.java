package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
//        twoSumUsingHashSet();
//        twoSumUsingTwoPointerTechnique();
        twoSumBinarySearch();
//        int[] arr = {0, -1, 2, -3, 1};
//        int target = -2;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == target) {
//                    System.out.println("pair " + arr[i] + " and " + arr[j] + " exist");
//                }
//            }
//        }
    }

    static void twoSumUsingHashSet() {
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // insert number into set
            // check if compliment exists in set
            if (hs.contains(target - arr[i])) {
                System.out.println("pair " + arr[i] + " and " + (target - arr[i]) + " exist");
            }
            hs.add(arr[i]);
        }
    }

    static void twoSumUsingTwoPointerTechnique() {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int target = 16;
        // Sort array ascending
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            if (arr[l] + arr[r] == target) {
                System.out.println("Pair found: " + arr[l] + " and " + arr[r]);
                return;
            } else if (arr[l] + arr[r] < target) {
                l++;
            } else {
                r--;
            }
        }
    }

    static void twoSumBinarySearch() {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int target = 16;
        for (int i = 0; i < arr.length; i++) {
            if (binarySearch(arr, (target - arr[i]))) {
                System.out.println("Pair exists :" + arr[i] + " and " + (target - arr[i]));
                return;
            }
        }
    }

    static boolean binarySearch(int[] a, int target) {

        // sort array
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }

//        System.out.println(Arrays.toString(a));
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}

class TwoSumDemo {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int target = 16;
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            if (arr[l] + arr[r] == target) {
                System.out.println("Pair found: " + arr[l] + ", " + arr[r]);
                break;
            } else if (arr[l] + arr[r] > target) {
                r--;
            } else {
                l++;
            }
        }

    }
}
