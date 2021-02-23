//same as level order traversal 
//only difference is first add right child then left
//instead of print add it to stack
//pop until stack becomes empty

public ArrayList<Integer> reverseLevelOrder(Node node) 
{
    // code here
    
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    if(node == null){
        return result;
    }
    
    
    Queue<Node> q = new LinkedList<Node>();
    
    //stack because 
    Stack<Node> st = new Stack<Node>();
    
    q.add(node);
    
    while(!q.isEmpty()){
        int size = q.size();
        
        for(int i = 0; i < size; i++){
            Node current = q.remove();
            
            st.push(current);
            
            if(current.right != null){
                q.add(current.right);
            }
            
            if(current.left != null){
                q.add(current.left);
            }
            
        }
    }
    
    while(!st.isEmpty()){
        result.add(st.pop().data);
    }
    return result;
}