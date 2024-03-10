package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Link: https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
Video Link: https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
Hint: use level-order traversal with a flag
flag=0 => L->R
flag=1 => R->L
       1
      / \
     2   3
    / \ / \
   4  5 6  7

 */
public class ZigZagTraversal {

    static void zigZagLevelOrderTraversal(TreeNode node, List<List<Integer>> resultList, Queue <TreeNode>queue){

        boolean flag=true;
        if(node==null)
            return;
        queue.offer(node);
        while(!queue.isEmpty()){
            int levelNum= queue.size(); //root queue size =1 at level 1
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<levelNum;i++){ //pop the elements of the same level
                if(queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                    queue.offer(queue.peek().right);

                //Adding to the list ; flag determines the direction
                if(flag==true)
                    subList.add(queue.poll().data);
                else
                    // this reverses the list by adding the front element of the Q at 0th index of sublist
                    subList.add(0,queue.poll().data);
            }
            flag=!flag; //Toggle the flag to change direction
            resultList.add(subList);
        }
    }
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Queue <TreeNode> queue = new LinkedList<>(); //Level order traversal queue
        List<List<Integer>> resultList = new ArrayList<>();

        zigZagLevelOrderTraversal(root, resultList, queue);

        //Printing the Zig Zag Traversal
        for(int i=0;i<resultList.size();i++){
            System.out.println("Level:"+(i+1));
            for (int j=0;j<resultList.get(i).size();j++){
                System.out.println(resultList.get(i).get(j)+ " ");
            }
        }
    }
}
