package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/*
Video Link: https://www.youtube.com/watch?v=f-sj7I5oXEI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=48
Problem Link:
        5
       / \
      3   6
     / \   \
    2   4   7
   /
  1
Hint: Define range for each node
TC: O(N)
SC: Auxillary recusion stack space
 */
public class ValidateBST {
    static boolean isValidBST(TreeNode node, int minValue, int maxValue){
        if(node==null)
            return true;
        //Check if value of node is out of range
        if(node.data<=minValue && node.data>=maxValue)
            return false;
        //Recursively check range for left and right node
        boolean isValidLeftNode=isValidBST(node.left,minValue,node.data); //val(leftNode)<=parent node
        boolean isValidRightNode=isValidBST(node.right,node.data,maxValue);//val(rightNode)>parent node
        return isValidLeftNode && isValidRightNode;
    }
    public static void main(String []args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);

        boolean isValidBST= isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("isValidBST: "+isValidBST);
    }
}
