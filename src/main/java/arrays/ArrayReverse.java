package arrays;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(a);
        System.out.println("==========");
        System.out.println("Original: " + Arrays.toString(a));
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            int t = a[i];
            a[i] = a[N - i - 1];
            a[N - i - 1] = t;
        }
        System.out.println("Reversed: " + Arrays.toString(a));
    }

    static void reverse(int[] a) {
        System.out.println("Original: " + Arrays.toString(a));
        int[] t = new int[a.length];
        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++, j--) {
            t[j] = a[i];
        }
        System.out.println("Reversed: " + Arrays.toString(t));
    }
}
