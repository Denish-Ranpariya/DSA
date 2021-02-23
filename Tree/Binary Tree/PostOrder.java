class Tree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    /* Computes the number of nodes in a tree. */
    static ArrayList<Integer> postOrder(Node root)
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
        //right subtree
        //visit node
        traverse(root.left);
        traverse(root.right);
        result.add(root.data);
    }
}
