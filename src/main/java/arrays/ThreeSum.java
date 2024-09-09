package arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {0, -1, 2, -3, 1};
        Arrays.sort(a);
        int target = 0;
        Set<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;
            while (l <= r) {
                int sum = a[i] + a[r] + a[l];
                if (sum == target) {
//                    System.out.println(a[i] + "+" + a[l] + "+" + a[r] + "=" + target);
                    list.add(Arrays.asList(a[i], a[l], a[r]));
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        // Print output
        for (List<Integer> arrayList : list) {
            System.out.println(arrayList);
        }
    }
}
