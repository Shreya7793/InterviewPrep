package BinaryTrees;
/*
Video Link: https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=19
Problem Link: https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
 */
public class MaximumPathSum {
    static int pathSum(TreeNode node, int []maxSum){
        if(node==null)
            return 0;

        int leftValue= pathSum(node.left, maxSum);
        int rightValue=pathSum(node.right, maxSum);
        maxSum[0]= Math.max(maxSum[0], node.data+leftValue+rightValue);

        return node.data +Math.max(leftValue,rightValue);
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
        int []maxSum= new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        pathSum(root, maxSum);
        System.out.println("Maximum Path Sum: "+maxSum[0]);
    }
}
