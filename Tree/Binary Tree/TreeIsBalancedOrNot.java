// Given a binary tree, find if it is height balanced or not. 
// A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

class Tree
{
    static boolean isBalanced = true;
    boolean isBalanced(Node root)
    {
	// reset global static
	  isBalanced = true;
	  height(root);
	  return isBalanced;
    }
    

    //the difference between height of left subtree and right subtree should less than or equal to 1
    //if above condition is false for one node then whole tree is unbalanced

    public static int height(Node node){
        //base case
        if(node == null){
            return 0;
        }
        
        //height of left subtree
        int left = height(node.left);

        //height of right subtree
        int right = height(node.right);
        
        //if difference between these two is greater than 1 then tree is unbalanced
        if(Math.abs(left-right) > 1){
            isBalanced = false;
        }
        
        
        return 1 + Math.max(left,right);
    }
}