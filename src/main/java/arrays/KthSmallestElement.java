package arrays;

import java.util.Arrays;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] a = {12, 3, 5, 7, 19};
        findKthSmallestElementBySorting(a, 4);

    }

    static void findKthSmallestElementBySorting(int[] a, int k) {
        Arrays.sort(a);
        System.out.println(k + "th smallest element: " + a[k - 1]);
    }
}
