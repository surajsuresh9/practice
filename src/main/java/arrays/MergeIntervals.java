package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{6, 8}, {1, 3}, {2, 4}, {4, 7}};
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        for (int[] i : mergeIntervals(intervals)) {
            for (int ii : i) {
                System.out.print(ii + " ");
            }
            System.out.println();
        }

    }

    static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            System.out.println(intervals);
        }
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // overlapping intervals
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // non overlapping interval
                // add new interval to list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
