package MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Leetcode link: https://leetcode.com/problems/merge-intervals/description/
Video solution: https://www.youtube.com/watch?v=QZG8ep54-Lc
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        int size=intervals.length;
        //sort the intervals based on their start value-O(nlogn) where n is the number of intervals
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>(); //taking a list because we don't know how many intervals will be there

        result.add(intervals[0]);//add the first interval to list, it'll be easy for comparing
        for(int i=1;i<intervals.length;i++){ //starting from next interval as we already added the first interval to list
            int []currentInterval = intervals[i];
            int []lastMergerInterval = result.get(result.size()-1);
            //lastMergerInterval references to the last element in result list
            //Hence, Updating it would update the result also

            int lastEnd=lastMergerInterval[1]; //end of last merged interval
            int start=currentInterval[0]; //start of current interval

            if(start<=lastEnd){ //overlapping when start of current interval<=end of last interval
                lastMergerInterval[1]=Math.max(currentInterval[1],lastEnd); //(1,3)(2,6) => (1,6)
            }else{
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String []args){
        int[][] intervals ={{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Original intervals: " + Arrays.deepToString(intervals));
        int[][] mergedIntervals = merge(intervals);
        System.out.println("Merged intervals: " + Arrays.deepToString(mergedIntervals));
    }
}
