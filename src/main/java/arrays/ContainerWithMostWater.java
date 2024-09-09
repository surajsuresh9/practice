package arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
        naiveApproach(a);
        naiveApproach(b);
        twoPointerApproach(a);
        twoPointerApproach(b);
    }

    static void naiveApproach(int[] a) {
        int maxHeight = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int base = j - i;
                int height = Math.min(
                        a[i], a[j]);
                int maxArea = base * height;
//                System.out.println("Max Area for " + a[i] + " and " + a[j] + " = " + base + " x " + height + " = " + maxArea);
                maxHeight = Math.max(maxArea, maxHeight);
            }
        }
        System.out.println("Max area = " + maxHeight);
    }

    static void twoPointerApproach(int[] a) {
        int l = 0, r = a.length - 1;
        int maxArea = 0;

        while (l < r) {
            int computedArea = Math.min(a[l], a[r]) * (r - l);
            maxArea = Math.max(computedArea, maxArea);
            if (a[l] < a[r]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("Max area: " + maxArea);
    }
}

