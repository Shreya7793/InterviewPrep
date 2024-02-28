package BinaryTrees;

import BinaryTrees.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
Hint: Inorder of BST gives sorted

        5
       / \
      3   6
     / \   \
    2   4   7
   /
  1

 */
public class KthSmallestInBST {
    static void inOrder(TreeNode node, List<Integer> travesalList){
        if(node==null)
            return;
        inOrder(node.left,travesalList);
        travesalList.add(node.data);
        inOrder(node.right,travesalList);
    }
    public static void main(String []args){
        List<Integer> traversalList = new ArrayList<>();
        TreeNode root = new TreeNode(5);
        int k=2;
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        System.out.println("PreOrder Traversal: ");
        inOrder(root,traversalList);
        if (k <= traversalList.size()) {
            System.out.println("Kth Smallest Element: "+traversalList.get(k - 1));
        }
        if (k <= traversalList.size()) {
            System.out.println("Kth Largest Element: "+traversalList.get(traversalList.size()-k));
        }
    }
}
