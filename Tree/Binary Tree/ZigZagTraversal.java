//2 methods are possible

//1.using one queue and and a stack
//2.using two stacks

//method-1


// Print the zig zag traversal of tree.
class GFG
{
    // return an array containing the zig zag level order traversal of the given tree
    
    
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    if(root == null){
	        return result;
	    }
	    
        //queue for level order traversal
	    Queue<Node> q = new LinkedList<Node>();
	    
        //add root node
	    q.add(root);

        //level is initially zero
	    int level = 0;
	    
        //stack
	    Stack<Node> s = new Stack<Node>();
	    
        //while q is not empty 
	    while(!q.isEmpty()){

            //calculate the size of the queue
	        int size = q.size();
	        
            //remove all the element of the queue and add children of them
	        for(int i = 0; i < size; i++){
	            Node current = q.remove();

                //if level is even add it to the result
	            if(level % 2 == 0){
	                result.add(current.data);
	                
	            }else{
                    //if level is odd add it to stack to reverse it afterwards
	                s.push(current);
	            }
	            
	            if(current.left != null){
	                q.add(current.left);
	            }
	            
	            if(current.right != null){
	                q.add(current.right);
	            }
	        }
	        
            //after every level 
            //until stack becomes empty pop the node from the stack and add it to the result
	        while(!s.isEmpty()){
	            result.add(s.pop().data);
	        }
	        
            //after every level increment the level
	        level++;
    	        
	    }
	    
	    return result;
	}
	
	
}

//method - 2
//using 2 stacks
class GFG
{
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(root == null){
	        return result;
	    }
	    
	    Stack<Node> s1 = new Stack<Node>();
	    Stack<Node> s2 = new Stack<Node>();
	    
        //push root to s1
	    s1.push(root);
	    
	    //while both stack becomes empty
	    while(!s1.isEmpty() || !s2.isEmpty()){
	        
            //while stack 1 is not empty
            //pop and print
            //push left and right child to s2 (order matters)
            while(!s1.isEmpty()){
	            Node current = s1.pop();
	            result.add(current.data);
	            if(current.left != null){
	                s2.push(current.left);
	            }
	            if(current.right != null){
	                s2.push(current.right);
	            }
	        }

            //while stack 2 is not empty
            //pop and print
            //push right and left child to s2 (order matters)
	        while(!s2.isEmpty()){
	            Node current = s2.pop();
	            result.add(current.data);
	            if(current.right != null){
	                s1.push(current.right);
	            }
	            if(current.left != null){
	                s1.push(current.left);
	            }
	            
	        }
	    }
	    
	    return result;
	}
}
