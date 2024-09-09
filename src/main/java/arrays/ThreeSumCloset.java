package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumCloset {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        int target = 4;
        int minDiff = Integer.MIN_VALUE;
        int resSum = a[0] + a[1] + a[2];
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;
            int sum = a[i] + a[r] + a[l];
            if (sum == target) {
                System.out.println(target);
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
            int diff = Math.abs(target - sum);
            System.out.println("Diff: " + diff);
            if (diff < minDiff) {
                resSum = sum;
            }
        }
        System.out.println(resSum);
    }
}
