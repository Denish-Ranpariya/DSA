class Tree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> inOrder(Node root)
    {
        result.clear();
        traverse(root);
        
        return result;
    }
    
    public static void traverse(Node root){
        if(root == null){
            return;
        }
        
        //left subtree
        //visit node
        //right subtree
        traverse(root.left);
        result.add(root.data);
        traverse(root.right);
        
    }
    
}