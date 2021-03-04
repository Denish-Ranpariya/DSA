class Tree
{
	boolean isIdentical(Node root1, Node root2)
	{
	    //if both are null then return true
	    if(root1 == null  && root2 == null){
	        return true;
	    }
	    
        //if one of them is null and another is not then return false
	    if((root1 != null && root2 == null) || (root1 == null && root2 != null)){
	        return false;
	    }
	    
        //if both node's data is not same then return false
	    if(root1.data != root2.data){
	        return false;
	    }
	    
        //call for left subtree and right subtree
	    boolean left = isIdentical(root1.left, root2.left);
	    boolean right = isIdentical(root1.right, root2.right);
	    
        //if they are identical then resturn true else return false
	    if(left && right){
	        return true;
	    }else{
	        return false;
	    }
	}
	
}