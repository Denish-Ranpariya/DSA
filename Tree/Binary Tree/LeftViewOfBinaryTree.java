class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> result  = new ArrayList<Integer>();
      
      if(root == null){
          return result;
      }
      
      Queue<Node> q = new LinkedList<Node>();
      
      //add root node to queue
      q.add(root);
      
      //while queue is not empty 
      while(!q.isEmpty()){

        //calculate size of queue
        int size = q.size();

        //insert first element of queue in result because it is left most node of current level
        result.add(q.peek().data);
        
        //remove current element of current level
        //and insert nodes of next level if exists
        for(int i = 0; i < size; i++){
            Node current = q.remove();
            
            if(current.left != null){
                q.add(current.left);
            }
            
            if(current.right != null){
                q.add(current.right);
            }
        }   
      }
      
      return result;
      
    }
}