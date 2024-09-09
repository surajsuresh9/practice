package arrays;

public class MaxSubArray_Kadane {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
//          Keep moving and add, if it's less than 0 drop
//          don't carry any negatives forward
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            // if -ve reset (drop negatives)
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) maxSum = sum;
        }
        System.out.println(maxSum);
    }
}
