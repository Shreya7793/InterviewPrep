package BinaryTrees;
/*
Video Link: https://www.youtube.com/watch?v=u-yWemKGWO0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=34
Problem Link: https://takeuforward.org/binary-tree/count-number-of-nodes-in-a-binary-tree/
 */
public class CountNodesInCompleteTree {
    static int leftHeight(TreeNode node){
        if(node==null)
            return 0;
        return 1+leftHeight(node.left);
    }
    static int rightHeight(TreeNode node){
        if(node==null)
            return 0;
        return 1+rightHeight(node.right);
    }
    static int countTotalNodesInCompleteBT(TreeNode node){
        if(node==null)
            return 0;

        int totalNodesLeftTree= (int) (Math.pow(2,leftHeight(node))-1);
        int totalNodesRightTree= (int) (Math.pow(2,rightHeight(node))-1);

        return  1+totalNodesLeftTree+totalNodesRightTree;
    }
    public static void main(String []args){

    }
}
