//level order traversal 
//swap left and right every time

class Tree
{
    void mirror(Node node){
	// Your code here
	    if(node == null){
	        return;
	    }
	    
	    Queue<Node> q = new LinkedList<>();
	    
	    q.add(node);
	    
	    while(!q.isEmpty()){
	        int size = q.size();
	        
	        for(int i = 0; i < size; i++){
	            Node current = q.remove();
	            
	            if(current.left != null){
	                q.add(current.left);
	            }
	            
	            if(current.right != null){
	                q.add(current.right);
	            }
	            
                //swapping
	            Node temp = current.left;
	            current.left = current.right;
	            current.right = temp;
	        }
	    }
	
    }
}
