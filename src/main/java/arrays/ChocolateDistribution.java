package arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        System.out.println("Min diff: " + slidingWindow(new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}, 7));
    }

    static int slidingWindow(int[] a, int windowSize) {

        // Check base cases
        if (a.length == 0 || windowSize == 0) {
            return 0;
        }

        // Check if there are enough packets for the given number of students
        if (a.length - 1 < windowSize) {
            // Invalid input
            return -1;
        }

        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(a);

        // Iterate through the array to find the minimum difference
        for (int i = 0; i < a.length; i++) {
            int nextWindow = i + windowSize - 1;
            if (nextWindow >= a.length) break;
            int diff = a[nextWindow] - a[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
