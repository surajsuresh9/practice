package arrays;

public class LessThanElementGreaterThan {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        // leftMax[i] stores maximum of arr[0..i-1]
        int n = arr.length - 1;
        int[] leftMax = new int[n];
        leftMax[0] = Integer.MIN_VALUE;

        // Fill leftMax[1..n-1]
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);

        // Initialize minimum from right
        int rightMin = Integer.MAX_VALUE;

        // Traverse array from right
        for (int i = n - 1; i >= 0; i--) {
            // Check if we found a required element
            if (leftMax[i] < arr[i] && rightMin > arr[i])
                System.out.println("Element at pos:" + i + ", " + arr[i]);

            // Update right minimum
            rightMin = Math.min(rightMin, arr[i]);
        }
    }
}
