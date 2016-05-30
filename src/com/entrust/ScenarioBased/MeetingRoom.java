package com.entrust.ScenarioBased;

/**
 *Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 Understand the problem:
 The problem looks very similar to the merge interval and insert intervals.
 So the idea is still the same: first sort the intervals according to the start times,
 then check if there is any overlap.

 Also check minimum Meeting rooms.
 Logic is if overlap you need two rooms
 */
import java.util.*;
public class MeetingRoom {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return true;
            }

            // Sort according to the start time
            Arrays.sort(intervals, new IntervalComparator());

            Interval prev = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                Interval curr = intervals[i];
                if (isOverlapped(prev, curr)) {
                    return false;
                }
                prev = curr;
            }

            return true;
        }

        public class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

        private boolean isOverlapped(Interval a, Interval b) {
            return a.end > b.start;
        }

        public int minMeetingRooms(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            Arrays.sort(intervals, new IntervalComparator());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int numRooms = 1;

            pq.offer(intervals[0].end);

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < pq.peek()) {
                    numRooms++;
                    pq.offer(intervals[i].end);
                } else {
                    pq.poll();
                    pq.offer(intervals[i].end);
                }
            }

            return numRooms;

        }
    }

}

