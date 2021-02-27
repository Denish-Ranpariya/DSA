/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
          ArrayList<Integer> result = new ArrayList<Integer>();
          
          Queue<Node> q = new LinkedList<Node>();
          
          q.add(root);
          
          //represent the current level
          int level = 0;
          
          while(!q.isEmpty()){
              int size = q.size();
              for(int i = 0 ; i < size; i++){
                  Node current = q.remove();

                  //if current level is equal to given level k then add that nodes to list
                  if(level == k){
                      result.add(current.data);
                  }
                  
                  if(current.left != null){
                        q.add(current.left);
                  }
                  
                  if(current.right != null){
                      q.add(current.right);
                  }
              }
              
              //break the while loop
              if(level == k){
                      break;
                }
              level++;
          }
          
          return result;
     }
}

//recursive
class Tree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k){
        result.clear();
        // Your code here
        solve(root,k);
        return result;
    }
    
    public static void solve(Node root,int k){

        //if root node doesn't exists or k is negative
        if(root == null || k < 0){
            return;
        }
        
        //base consition
        if(k == 0){
            result.add(root.data);
            return;
        }

        //call recursive function for left and right subtree for k - 1 level
        solve(root.left, k - 1);
        solve(root.right,k - 1);
    }
}