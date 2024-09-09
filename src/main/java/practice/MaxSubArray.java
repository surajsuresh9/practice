package practice;

public class MaxSubArray {
    public static void main(String[] args) {
//        int[] a = {2, 1, 5, 1, 3, 2};
        int[] a = {1, 4, 2, 10, 2, 3, 1, 0, 20};
//        int[] a = {1, 4, 2, 10, 23, 3, 1, 0, 20};
//        int[] a = {100, 200, 300, 400};
//        int size = 2;
//        int size = 3;
        int size = 4;
//        int size = 2;
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i <= a.length - size; i++) {
            for (int j = i; j < i + size; j++) {
                windowSum += a[j];
            }
            maxSum = Math.max(maxSum, windowSum);
            windowSum = 0;
        }
        System.out.println("maxSum: " + maxSum);
    }
}
