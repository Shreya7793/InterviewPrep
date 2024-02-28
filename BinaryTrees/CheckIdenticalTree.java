package BinaryTrees;
/*
Video Link: https://www.youtube.com/watch?v=BhuvF_-PWS0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20
Problem Link: https://takeuforward.org/data-structure/check-if-two-trees-are-identical/
TC: O(N)
SC: O(N)
 */
public class CheckIdenticalTree {

    static boolean checkIdenticalTree(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null && node2!=null)
            return false;
        if(node1!=null && node2==null)
            return false;
        boolean leftCheck = checkIdenticalTree(node1.left, node2.left);
        boolean rightCheck = checkIdenticalTree(node1.right, node2.right);

        //This is same as preorder traversal - data, left, right => we do the preorder traversal for the two trees
        //so that we visit them at the same time. Wer can do any traversal.
        return (node1.data==node2.data) && leftCheck && rightCheck;
    }

    public static void main(String []args){
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);
            root1.left.left = new TreeNode(4);
            root1.left.right = new TreeNode(5);
            root1.left.right.left = new TreeNode(8);
            root1.right.left = new TreeNode(6);
            root1.right.right = new TreeNode(7);
            root1.right.right.left = new TreeNode(9);
            root1.right.right.right = new TreeNode(10);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(8);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(10);

        System.out.println("Are both of the trees identical"+ checkIdenticalTree(root1,root2));
    }
}
