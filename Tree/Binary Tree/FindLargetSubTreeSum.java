import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class FindLargetSubTreeSum{

    //to store sum of largest sub tree
    static int sumOfLargestSubTree = 0;
    public static void main(String[] args) {

        //reset global statics
        sumOfLargestSubTree = 0;

        TreeNode root = new TreeNode(1);  
        root.left = new TreeNode(-2);  
        root.right = new TreeNode(3);  
        root.left.left = new TreeNode(4);  
        root.left.right = new TreeNode(5);  
        root.right.left = new TreeNode(-6);  
        root.right.right = new TreeNode(2);

        //call recursive function
        solve(root);

        System.out.println("Larget sub tree sum : " + sumOfLargestSubTree);
    }

    public static int solve(TreeNode node){

        //base case
        if(node == null){
            return 0;
        }

        //call for left sub tree
        int left = solve(node.left);

        //call for right sub tree
        int right = solve(node.right);
        
        //sum will be total of left subtree, right subtree and node itself
        int sum = left + right + node.data;

        //if this sum is grater than sumOfLargestSubTree then sumOfLargestSubTree will be sum 
        if(sum > sumOfLargestSubTree){
            sumOfLargestSubTree = sum;
        }

        return sum;
    }
}