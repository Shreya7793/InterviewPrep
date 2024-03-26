package MergeInterval;

import java.util.Arrays;

/*
Leetcode link:https://leetcode.com/problems/meeting-rooms/description/
Video Link: https://www.youtube.com/watch?v=PaJxqZVPhbg
Given an array of meeting time intervals where intervals[i] = [starti, endi],
 determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
 */
public class MeetingRoom {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//Sort array based on start time in ascending order

        for(int i=1;i<intervals.length;i++){
            int []lastInterval=intervals[i-1];
            int []currentInterval=intervals[i];
            int lastEnd=lastInterval[1];
            int start=currentInterval[0];
            if(start<lastEnd){ //if starttime of current meeetin<end time of last meeting=>overlapping
                return false;
            }
        }
        return true;
    }
    public static void main(String []args){
        //int[][] intervals ={{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals ={{1, 3}, {8, 10}, {15, 18}};
        System.out.println("Original intervals: " + Arrays.deepToString(intervals));
        System.out.println("Can Attend meeting? " + canAttendMeetings(intervals));
    }
}
