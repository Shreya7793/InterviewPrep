package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/description/
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.
Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1
Hint: Use priority Queue - min heap to keep a track which room will get vacated first
 */
public class MeetingRoom2 {
    public static int minMeetingRooms(int[][] intervals) {

        //Sort the input array based on their start time i.e [0] to compare the intervals
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        //Ue minHeap to keep a track of the end times
        PriorityQueue <Integer> minHeap= new PriorityQueue<>();
        minHeap.add(intervals[0][1]); //add the end time of first interval

        //Iterate through the intervals
        for(int i=1;i<intervals.length;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            //currStart>last end time then we can use the same meeting room ; minHeap has the last end time
            if(currStart >= minHeap.peek()) {
                minHeap.poll(); //use the room by removing the meeting that ended from the minHEap
            }
            // Add the current meeting's end time to the min-heap
            minHeap.offer(currEnd);
        }
        // The size of the min-heap represents the number of meeting rooms needed
        return minHeap.size();
    }
    public static void main(String []args){
        int[][] intervals ={{1, 3}, {2, 10}, {15, 18}};
        System.out.println(minMeetingRooms(intervals));
    }
}
