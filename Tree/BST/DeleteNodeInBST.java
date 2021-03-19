//IMP
//4 cases are possible
//0 child - leaf node
//only left child
//only right child
//both child

class Tree
{
	public static Node deleteNode(Node node, int key)
	{
        //base case
		if(node == null){
		    return null;
		}
		
        //if node is found
		if(node.data == key){
            //have 2 child
		    if(node.left != null && node.right != null){
                //find in inorder predecesor
		        int inorderPredecesor = findInorderPredecesor(node);
		        
                //replace node data with in order predecesor
		        node.data = inorderPredecesor;
		        
                //delete in order predecesor in left sub tree
		        node.left = deleteNode(node.left, inorderPredecesor);
		        
                //attch node
		        return node;
		    }else if(node.left != null){
                //if only have left child then by pass it
                //attch left sub tree
		        return node.left;
		    }else if(node.right != null){
                //if only have right child then by pass it
                //attach right sub tree
		        return node.right;
		    }else{
                //if no child then attach null
		        return null;
		    }
		}else if(node.data > key){
            //if key is smaller than node's data then delete node in left sub tree
		    node.left = deleteNode(node.left, key);
		}else{
            //if key is greater than node's data then delete node in right dub tree
		    node.right = deleteNode(node.right, key);
		}
		
		return node;
	}

    //function to find in order predecesor (greatest in left sub tree)
	public static int findInorderPredecesor(Node node){
	    Node current = node.left;
	    
	    while(current.right != null){
	        current = current.right;
	    }
	    
	    return current.data;
	}
}	