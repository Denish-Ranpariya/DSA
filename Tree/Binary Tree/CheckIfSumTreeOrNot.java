class Tree
{   
	boolean isSumTree(Node root)
	{
        //if root is null then it is not balanced
        //base case
	    if(root == null){
	        return false;
	    }
	    
        //get sum of left sub tree
	    int left = getSum(root.left);

        //get sum of right sub tree
	    int right = getSum(root.right);
	    
        //if sum of left subtree and right sub tree are equal then return true otherwise false
	    if(left + right == root.data){
	        return true;
	    }else{
	        return false;
	    }
	}
	
    //recursive function to get sum 
	public static int getSum(Node node){
        
        //if root is null then return sum as zero
        //base case
	    if(node == null){
	        return 0;
	    }
	    
        //getsum of left sub tree
	    int left = getSum(node.left);

        //get sum of right sub tree
	    int right = getSum(node.right);
	    
        //return sum of leftsubtree + rightsubtree + node's data
	    return node.data + left + right;
	}
 }