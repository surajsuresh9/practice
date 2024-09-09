package arrays;

import java.util.Arrays;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println("Max rain water that can be trapped: " + naiveApproach(a));
        System.out.println("Max rain water that can be trapped: " + usingMaxHeightArrays(a));
        System.out.println("Max rain water that can be trapped: " + twoPointerApproach(a));
    }

    static int naiveApproach(int[] a) {
        int totalWaterStored = 0;
        for (int i = 0; i < a.length - 1; i++) {

            // find max height on left
            int left = a[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(a[j], left);
            }
            // find max height on right
            int right = a[i];
            for (int j = i + 1; j < a.length; j++) {
                right = Math.max(a[j], right);
            }

            totalWaterStored += Math.min(left, right) - a[i];
        }
        return totalWaterStored;
    }

    static int twoPointerApproach(int[] a) {
        // iterate each element in array
        // find max height left and right of current index
        // find the smallest of these 2 heights and subtract the height of the current index
        // add this to the total water that can be trapped
        int ans = 0;
        int l = 0, r = a.length - 1;
        int maxL = a[l], maxR = a[r];
        while (l < r) {
            if (maxL < maxR) {
                ans += maxL - a[l];
                maxL = Math.max(maxL, a[++l]);
            } else {
                ans += maxR - a[r];
                maxR = Math.max(maxR, a[--r]);
            }
        }
        return ans;
    }

    static int usingMaxHeightArrays(int[] a) {
        int[] maxLeft = new int[a.length];
        int[] maxRight = new int[a.length];

        maxLeft[0] = a[0];
        // traverse left to right and get max left
        for (int i = 1; i < a.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], a[i]);
        }

        maxRight[a.length - 1] = a[a.length - 1];
        // traverse right to left and get max right
        for (int i = a.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], a[i]);
        }

        System.out.println("maxLeft: " + Arrays.toString(maxLeft));
        System.out.println("maxRight: " + Arrays.toString(maxRight));

        int water = 0;
        for (int i = 0; i < a.length; i++)
            water += Math.min(maxLeft[i], maxRight[i]) - a[i];

        return water;
    }
}
