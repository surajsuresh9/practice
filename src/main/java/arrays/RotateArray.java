package arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        int times = 3;

        System.out.println("Original: " + Arrays.toString(original));


//        clockwise rotation
        for (int ii = 0; ii < times; ii++) {
            int last = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = last;
        }
        System.out.println("Anti-clockwise: " + Arrays.toString(a));

        // anti-clockwise
        for (int k = 0; k < times; k++) {
            int first = b[0];
            for (int j = 0; j < a.length - 1; j++) {
                b[j] = b[j + 1];
            }
            b[a.length - 1] = first;
        }
        System.out.println("Clockwise: " + Arrays.toString(b));

    }
}
