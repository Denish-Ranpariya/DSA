//search in binary tree
//use of property (left sub tree nodes are smaller & right sub tree nodes are greater)

//if node's value is equal to key return true
//if node's value is larger than key then go to right
//if node's value is smaller than key then go to left

//iterative approach
class BST
{
    boolean search(Node root, int x)
    {
	    // Your code here
	    Node current = root;
	    while(current != null){
	        if(current.data == x){
	            return true;
    	    }else if(current.data < x){
    	        current = current.right;
    	    }else if(current.data > x){
    	        current = current.left;
    	    } 
	    }
	    return false;
    }
}

//recursice approach
class BST
{
    boolean search(Node root, int x)
    {
	    //base case
	    if(root == null){
	        return false;
	    }
	    
		//if nodes data is equal to key then return true
	    if(root.data == x){
	        return true;
	    }
	    
		//if key is smaller then go to left sub tree otherwise go to right subtree
	    if(root.data > x){
	        return search(root.left, x);
	    }else{
	        return search(root.right, x);
	    }
    }
}