package BinaryTrees;

/*
Video Link: https://www.youtube.com/watch?v=KcNt6v_56cc
Brute:
If we find using any traversal then
TC: O(N)
Optimised approach: To use BST property:
TC: Height of Balanced BST=O(LogN) since height of BST is logN,
so at max we'll travel either left or right throug-out the height
 */

public class SearchInBST {
    static boolean searchInBST(TreeNode node, int searchVal){
        //if current node is null
        if(node==null)
            return false;
        // If current node's value matches the search value
        if(node.data==searchVal)
            return true;
        // If the search value is less than or equal to the current node's value,
        // search in the left subtree; otherwise, search in the right subtree.
        return (searchVal<=node.data)?searchInBST(node.left,searchVal):searchInBST(node.right, searchVal);
    }
    public static void main(String []args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        int searchVal = 5;
        System.out.println("Is value present in BST?"+searchInBST(root,searchVal));
    }
}
