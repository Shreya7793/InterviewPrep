package BinaryTrees;
/*
TC: O(N) -> Need to traverse all nodes, so can't be reduced further
SC: O(N) -> at the worst case if it's skewed tree
 */
public class MaximumDepth {
    static int maxDepthUsingRecursion(TreeNode node){
        if(node==null)
            return 1;

        int leftHeight=maxDepthUsingRecursion(node.left);
        int rightHeight=maxDepthUsingRecursion(node.right);
        return 1+ Math.min(leftHeight,rightHeight);
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

        System.out.println("Maximum Depth: "+maxDepthUsingRecursion(root));
    }
}
