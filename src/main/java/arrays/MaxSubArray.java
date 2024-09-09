package arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;

        // all +ve
        if (allPositive(a)) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
            }
            System.out.println("MaxSubArray: " + sum);

        // all -ve
        } else if (allNegative(a)) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println("MaxSubArray: " + max);

            // mix of +ve and -ve elements
        } else {
            for (int i = 0; i < a.length; i++) {
                currentSum += a[i];
                currentSum = Math.max(currentSum, a[i]);
                bestSum = Math.max(bestSum, currentSum);
            }
            System.out.println("MaxSubArray: " + bestSum);

        }
    }

    static boolean allPositive(int[] a) {
        boolean allPositive = true;
        for (int i : a) {
            if (i < 0) {
                allPositive = false;
                break;
            }
        }
        return allPositive;
    }

    static boolean allNegative(int[] a) {
        boolean allNegative = true;
        for (int i : a) {
            if (i > 0) {
                allNegative = false;
                break;
            }
        }
        return allNegative;
    }
}
