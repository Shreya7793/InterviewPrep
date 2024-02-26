package BinaryTrees;
/*
Problem Link: https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
Video Link: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
TC: O(N)
SC: O(N)
Eg:
        1
       /   \
      2     3
     / \   / \
    4   5 6   7
       /     / \
      8     9  10
 */
public class CheckBalancedBinaryTree {
    static int checkBalancedWithRecursion(TreeNode node){
        if(node==null)
            return 0;

        //Similar to postorder travesal: left, then right
        int leftHeight=1+checkBalancedWithRecursion(node.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight=1+checkBalancedWithRecursion(node.right);
        if(rightHeight==-1)
            return -1;
        if(leftHeight-rightHeight>1)
            return -1;
        return Math.max(leftHeight, rightHeight);
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
        if(checkBalancedWithRecursion(root)!=-1)
            System.out.println("Balanced BT");
        else
            System.out.println("Not a Balanced BT");
    }
}
