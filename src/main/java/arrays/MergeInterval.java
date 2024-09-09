package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval() {
            this.start = 0;
            this.end = 0;
        }

    }

    static boolean doesIntervalOverlap(Interval a, Interval b) {
        return Math.min(a.end, b.end) > Math.min(a.start, b.start);
    }

    public static List<Interval> insertNewInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        int n = intervals.size();

        // add new interval and return
        if (n == 0) {
            res.add(newInterval);
            return res;
        }

        // Case 1 and Case 2, intervals at corners
        if (newInterval.end < intervals.get(0).start || newInterval.start > intervals.get(n - 1).end) {

            // add at first
            // {4,5} {8,9}, add {1,3}
            if (newInterval.end < intervals.get(0).start) {
                res.add(newInterval);
            }
            for (int i = 0; i < intervals.size(); i++) {
                res.add(intervals.get(i));
            }

            // add at last
            // {1,3} {5,6}, add {7,9}
            if (newInterval.start > intervals.get(n - 1).end) {
                res.add(newInterval);
            }
            return res;
        }

        // Case 3, new interval covers all existing intervals
        // {4,5} {6,8}, add {1,9}
        if (newInterval.start <= intervals.get(0).start && newInterval.end >= intervals.get(n - 1).end) {
            res.add(newInterval);
            return res;
        }

        // Case 4 and Case 5, check if interval overlaps, use subroutine
        boolean overlap = true;
        for (int i = 0; i < intervals.size(); i++) {
            overlap = doesIntervalOverlap(intervals.get(i), newInterval);

            // Case 4 : To check if given interval
            // lies between two intervals. (No overlap)

            if (!overlap) {
                res.add(intervals.get(i));
                // {1, 2}, {6, 9}, add {3,5}
                if (i < n && newInterval.start > intervals.get(i).start && newInterval.end > intervals.get(i + 1).start) {
                    res.add(newInterval);
                }
                continue;
            }

            // Case 5 : Merge Overlapping Intervals.
            // {1, 4}, {5, 9}, add {3,7}
            // Starting time of new merged interval is minimum of starting time of both overlapping intervals.
            Interval temp = new Interval();
            temp.start = Math.min(intervals.get(i).start, newInterval.start);

            // Traverse the set until intervals are overlapping
            while (i < n && overlap) {
                // Ending time of new merged interval is maximum of ending time both overlapping intervals.
                temp.end = Math.max(newInterval.end, intervals.get(i).end);

                if (i == n - 1) {
                    overlap = false;
                } else {
                    overlap = doesIntervalOverlap(intervals.get(i + 1), newInterval);
                }
                i++;
            }
            i--;
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval newInterval = new Interval(1, 2);
        intervals.add(newInterval);
        newInterval = new Interval(3, 5);
        intervals.add(newInterval);
        newInterval = new Interval(6, 7);
        intervals.add(newInterval);
        newInterval = new Interval(8, 10);
        intervals.add(newInterval);
        newInterval = new Interval(12, 16);
        intervals.add(newInterval);
        newInterval = new Interval(4, 9);

    }
}

