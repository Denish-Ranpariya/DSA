//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Level_order_traversal
{
    //You are required to complete this method
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Your code here
        if(node == null){
            return result;
        }
        
        //queue for bfs
        Queue<Node> q = new LinkedList<Node>();
        
        //add root node
        q.add(node);
        
        //while q is not empty remove every element of queue and add its left or right child nodes
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                Node current = q.remove();
                result.add(current.data);
                
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
