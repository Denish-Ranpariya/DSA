//given sorted array 
//construct balanced bst
//return preorder of it


//tree node
public class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

class Solution
{
    //array for preorder
    static int preorderArray[]; 
    //index of preorder array
    static int index;
    
    public int[] sortedArrayToBST(int[] nums)
    {
        preorderArray = new int[nums.length];
        index = 0;
        
        //call recursive function with low as 0 and high as n - 1
        TreeNode root = solve(nums, 0, nums.length - 1);
        
        //preorder traversal of tree
        preorder(root);
        
        return preorderArray;
    }
    
    public static TreeNode solve(int[] nums, int low, int high){
        //base case
        //when low is greater than high then attacj null
        if(low > high){
            return null;
        }
        
        //calculate mid
        int mid = (low + high) / 2;
        
        //create newNode with data at index mid in array
        TreeNode newNode = new TreeNode(nums[mid]);
        
        //attach left child 
        //low as it is
        //high mid - 1
        newNode.left = solve(nums, low, mid - 1);

        //attach right child
        //low mid + 1
        //high as it is
        newNode.right = solve(nums, mid + 1, high);
        
        //attach created node
        return newNode;
    }
    
    //preorder traversal of tree
    public static void preorder(TreeNode root){
        if(root == null){
            return;
        }
        
        //add to preorder array
        //increment index by 1
        preorderArray[index] = root.data;
        index++;
        
        preorder(root.left);
        preorder(root.right);
    }
}