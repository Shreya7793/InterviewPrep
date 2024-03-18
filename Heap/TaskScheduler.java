package Heap;

import java.util.*;

/*
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
Each cycle or interval allows the completion of one task. Tasks can be completed in any order,
but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
Return the minimum number of intervals required to complete all tasks.
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
Video Solution: https://www.youtube.com/watch?v=ySTQCRya6B0
LeetCode Link: https://leetcode.com/problems/task-scheduler/submissions/1204712954/
Hint: You want to run the most frequently occurring task first
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> taskFreqMap=new HashMap<>();
        //creating the map
        for(int i=0;i<tasks.length;i++){
            taskFreqMap.put(tasks[i], taskFreqMap.getOrDefault(tasks[i],0)+1);
        }
        //This puts the max freq at the top of the heap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        maxHeap.addAll(taskFreqMap.values()); //We want cycles so just keeping track of the frequencies would be enough
        int cycles=0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp= new ArrayList<>(); //This list stores the process that we are able to run in the cycle
            //say if cooldown i.e n is 10 sec, we need to make sure that we are using complete 10 sec
            //therefore n+1
            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());//adding it to temp since we'd need to pout it back to heap
                }
            }
            //Now check everything that ran within the cycle, does it need to be processed more
            for(int i:temp){
                if(--i>0) {//decrementing since it ran in the cycle
                    maxHeap.add(i); //add it back the the heap.
                }
            }
            //If heap is not empty after this then we just need to run the number of elements that are left
            //else simple we need to wait for cooldown
            cycles += maxHeap.isEmpty()? temp.size():n+1;
        }
        return cycles;
    }
    public static void main(String []args){
        char []tasks={'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(tasks,n));
    }
}
