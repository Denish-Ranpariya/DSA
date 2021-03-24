//iterative inorder traversal
class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        
        //current pointer
        Node current = root;
        
        //stack
        Stack<Node> s = new Stack<Node>();
        
        //while stack is not empty and current is not null
        while(current != null || !s.isEmpty()){

            //if current is not null then push it to stack go to left
            if(current != null){
                s.push(current);
                current = current.left;
            }else{

                //if current is null then pop element from the stack and it will be current
                current = s.pop();
                
                //visit the node
                result.add(current.data);
                
                //go to right
                current = current.right;
            }
            
            
        }
        
        return result;
    }    
}


//iterative preorder
class BinaryTree
{
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        
        Stack<Node> s = new Stack<Node>();
        
        Node current = root;
        
        s.push(root);
        
        while(!s.isEmpty()){
            
            current = s.pop();
            
            result.add(current.data);
            if(current.right != null){
              s.push(current.right);  
            }
            if(current.left != null){
                s.push(current.left);
            }
            
        }
        
        return result;
    }

}