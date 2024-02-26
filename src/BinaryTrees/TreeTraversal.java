package BinaryTrees;
/*
For Traversal:
TC: O(N), N is the number of nodes, cuz at max we are going the number of times we have nodes
SC: O(height)orO(N), auxillary space is similar to the height; in worst case is when the tree is skewed all the nodes is considered
Level Order:
SC: O(N), auxillary space , in worst case queue is going to store all the nodes at a time
 */

import java.util.*;

public class TreeTraversal {
    static void preOrder(TreeNode node){
        if(node==null)
            return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    static void postOrder(TreeNode node){
        if(node==null)
            return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }
    static void inOrder(TreeNode node){
        if(node==null)
            return;

        preOrder(node.left);
        System.out.println(node.data);
        preOrder(node.right);
    }

    /*
    Queue Operations:
    offer(): Adds an element to the end of the queue if it is possible to do so immediately without violating capacity restrictions. Returns true upon success and false if the element cannot be added.
    peek(): Retrieves, but does not remove, the head of the queue, or returns null if the queue is empty.
    poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
     */
    static ArrayList<ArrayList<Integer>> levelOrder(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(node==null)
            return result; //return empty list if the tree is empty

        queue.offer(node);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();
            //Check if the front element has left child, if yes then add the left child to the queue.
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode=queue.poll();
                levelNodes.add(currentNode.data);

                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            result.add(levelNodes);
        }
        return result;
    }
    public static void main(String []args){
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

        System.out.println("PreOrder Traversal: ");
        preOrder(root);
        System.out.println("PostOrder Traversal: ");
        postOrder(root);
        System.out.println("InOrder Traversal: ");
        inOrder(root);
        System.out.println("Level-Order Traversal: ");
        for (ArrayList<Integer> level : levelOrder(root)) {
            for (int data : level) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
