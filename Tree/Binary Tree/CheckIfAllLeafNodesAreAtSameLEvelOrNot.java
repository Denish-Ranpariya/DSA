//check if all lead nodes are at same level or not

//level order treversal
//when leaf node is detected set boolean to true
//after detecting leaf node next level should not be present 
//it it is present which means that leaf nodes are not at same level

class GfG
{
    boolean check(Node root){
        
    	if(root == null){
    	    return false;
    	}
    	
        //q for level order traversal
    	Queue<Node> q = new LinkedList<Node>();
    	
        //add root node
    	q.add(root);
    	
        //leaf node is not detected yet so false
    	boolean isLeafNodeDetected = false;
    	
    	while(!q.isEmpty()){
    	    int size = q.size();
    	    
            //if leaf node is already detected then current level should not be existed so return false
    	    if(isLeafNodeDetected){
    	        return false;
    	    }
    	    
    	    for(int i = 0; i < size; i++){
    	        Node current = q.remove();
    	        
                //if current node \is leaf node then mark flag as true
    	        if(current.left == null && current.right == null){
    	            isLeafNodeDetected = true;
    	        }
    	        
    	        if(current.left != null){
    	            q.add(current.left);
    	        }
    	        
    	        if(current.right != null){
    	            q.add(current.right);
    	        }
    	    }
    	}
        
        //return true
	    return true;
	
    }
}
