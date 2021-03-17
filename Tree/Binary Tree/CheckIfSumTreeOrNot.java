class Tree
{
	//flag for tree if it is balanced or not
    static boolean flag = true;
    
	boolean isSumTree(Node root)
	{
        
        getSum(root);
        
        return flag;
	}
	

	//to make binary tree unbalanced only one node is required
	//if we found one node with is unbalanced then whole tree is unbalanced
	//leaf node is already balanced so we have to check for only non-leaf nodes
	public static int getSum(Node node){

		//base case
	    if(node == null){
	        return 0;
	    }
	    
		//sum of left sub tree
	    int left = getSum(node.left);

		//sum of right sub tree
	    int right = getSum(node.right);
	    

		//for non-leaf nodes
		//if root's data is not equal to sum of left sub tree and right sub tree then tree will be unbalanced
	    if(node.left != null && node.right != null){
	        if(node.data != left + right){
	            flag = false;
	        }
	    }
	    
		//return sum
	    return node.data + left + right;
	}
}