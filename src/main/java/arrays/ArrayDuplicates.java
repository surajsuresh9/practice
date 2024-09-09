package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicates {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 3, 1, 6, 3};
        findDuplicatesAuxiliaryArray();
        Map<Integer, Integer> freqMap = new HashMap<>();

/*
        for (int i = 0; i < a.length; i++) {
            // add all element along with their frequency to map
            // if key is already present, increment frequency count
            if (freqMap.containsKey(a[i])) {
                freqMap.put(a[i], freqMap.get(a[i]) + 1);
                // else add key and value
            } else {
                freqMap.put(a[i], 1);
            }
        }
*/

        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Duplicates are: ");
        for (Map.Entry<Integer, Integer> es : freqMap.entrySet()) {
//            System.out.println(es.getKey() + " : " + es.getValue());
            if (es.getValue() > 1) {
                System.out.print(es.getKey() + " ");
            }
        }
    }

    static void findDuplicatesAuxiliaryArray() {
        int[] a = {4, 3, 2, 7, 7, 2, 3, 1};
        int arr[] = new int[a.length];
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) {
            if (++arr[i] > 1) {
                l.add(i);
            }
        }
        System.out.println("Duplicates: " + l);
    }
}
