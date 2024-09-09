package arrays;

public class CheckIfArrayIsCircularlyRotated {
    public static void main(String[] args) {
        int arr[] = {23, 34, 45, 12, 17, 19};
        int count = 0;
        boolean isRotated = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
            }
        }
        if (count == 1) {
            isRotated = arr[0] > arr[arr.length - 1];
        }
        System.out.println("isRotated: " + isRotated);
    }
}
