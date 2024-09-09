package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlap {
    public static void main(String[] args) {
//        List<int[]> mergedIntervals = mergeOverlapUsingSort(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}});
//        printIntervals(mergedIntervals);
        mergeIntervalsInPlaceUsingSort(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}});
    }

    static List<int[]> mergeOverlapUsingSort(int[][] a) {
        sortOnStartInterval(a);
        List<int[]> list = new ArrayList<>();
        list.add(a[0]);

        for (int i = 0; i < a.length; i++) {
            // each element is an array
            int[] lastInterval = list.get(list.size() - 1);
            int[] currentInterval = a[i];

            // if current start overlaps with last end, merge them (e.g     {6, 8}, {1, 9} ==> {1, 9})
            if (currentInterval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(currentInterval[1], lastInterval[1]);
            } else {
                list.add(currentInterval);
            }
        }
        return list;
    }

    static void sortOnStartInterval(int[][] a) {
        // sort interval based on start time
        for (int y = 0; y < a.length - 1; y++) {
            for (int z = y + 1; z < a.length; z++) {
                if (a[y][0] > a[z][0]) {
                    int[] t = a[y];
                    a[y] = a[z];
                    a[z] = t;
                }
            }
        }
//        for (int[] arr : a) {
//            System.out.println(Arrays.toString(arr));
//        }
    }

    static void printIntervals(List<int[]> list) {
        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int mergeIntervalsInPlaceUsingSort(int[][] a) {
        sortOnStartInterval(a);
        int resIdx = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[resIdx][1] >= a[i][0]) {
                a[resIdx][1] = Math.max(a[resIdx][1], a[i][1]);
            } else {
                resIdx++;
                a[resIdx] = a[i];
            }
        }
        return resIdx + 1;
    }
}
