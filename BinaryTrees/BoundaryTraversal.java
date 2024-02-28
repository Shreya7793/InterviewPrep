package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Link: https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
Video Link: https://www.youtube.com/watch?v=0ca1nvR0be4
Approach: 'Boundary traversal in an anti-clockwise direction' can be described as a traversal consisting of three parts:

Part 1: Left Boundary of the tree (excluding the leaf nodes).
Part 2: All the leaf nodes travelled in the left to right direction.
Part 3: Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction.

       1
      / \
     2   3
    / \ / \
   4  5 6  7

 */
public class BoundaryTraversal {

    static void addLeftBoundary(TreeNode node, List<Integer> leftList){
        TreeNode curr = node.left;
        while(curr!=null) {
            //Traverse only if node is not a leaf
            if(!isLeafNode(curr)) {
                if (node.left != null)
                    leftList.add(node.left.data);
                else //if left node is null then right nodes become part of the left boundary
                    leftList.add(node.right.data);
                curr=curr.left;
            }else
                break;
        }
    }
    static void addRightBoundary(TreeNode node, List<Integer> rightList){
        TreeNode curr = node.right;
        while(curr!=null) {
            //Traverse only if node is not a leaf
            if(!isLeafNode(curr)) {
                if (node.right != null)
                    rightList.add(node.right.data);
                else //if right node is null then left node become part of the right boundary
                    rightList.add(node.left.data);
                curr=curr.right;
            }else
                break;
        }
        rightList.reversed();
    }
    static void  addLeaves(TreeNode node, List<Integer> leafList){
        if(node==null)
            return;
        //Post order traversal
        addLeaves(node.left,leafList);
        addLeaves(node.right,leafList);
         if(node.left==null && node.right==null)
             leafList.add(node.data);
    }

    static boolean isLeafNode(TreeNode node){
        return (node.left==null && node.right==null);
    }
    public static void main(String []args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> resultList = new ArrayList<>();
        //Test case to check of there is root
        if(root==null)
            System.out.println("No Root");

        resultList.add(root.data); //add the root node
        addLeftBoundary(root,resultList);
        addLeaves(root,resultList);
        addRightBoundary(root,resultList);
        System.out.println(resultList);
    }
}
