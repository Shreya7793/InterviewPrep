package BinaryTrees;

import com.sun.source.tree.Tree;/*
Video Link: https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
Problem Link:
Diameter at a given node=Left height + Right height
Brute Force:
Recursive traversal for every node, calculate the diameter, find max out of every diameter
TC: O(N^2)
Post Order Approach:
TC: O(N)
SC: O(H) Recursion stack space
 */

public class DiameterOfBinaryTree {
    static  int diamWithRecursion(TreeNode node, int []diameter) {
        if (node == null)
            return 0;
        int leftHeight = diamWithRecursion(node.left, diameter);
        int rightHeight = diamWithRecursion(node.right, diameter);

        diameter[0] = Math.max(diameter[0],leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        int []diameter = {0};
        diamWithRecursion(root, diameter);
        System.out.println("Diameter of a BT: "+diameter[0]);

    }
}

