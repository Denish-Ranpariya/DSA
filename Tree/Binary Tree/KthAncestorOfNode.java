class Tree
{
    static ArrayList<Node> pathToRootNode = new ArrayList<Node>();
    public int kthAncestor(Node root, int k, int node)
    {
        //reset global static
        pathToRootNode.clear();
        
        if(root == null){
            return -1;
        }
        
        //call this function to find path from node to root
        //it will store all the ancestor in pathToRootNode list
        getPathToRootNode(root, node);

        //if node is not found or k is ghrater than size of pathToRootNode list then return -1
        if(pathToRootNode.size() == 0 || k > pathToRootNode.size() - 1){
            return -1;
        }

        //otherwise return node at kth index in pathToRootNode list because it is kth ancestor
        return pathToRootNode.get(k).data;
    }
    
    public static boolean getPathToRootNode(Node root,int target){

        if(root == null){
            return false;
        }
        
        if(root.data == target){
            pathToRootNode.add(root);
            return true;
        }
        
        boolean left = getPathToRootNode(root.left, target);
        if(left){
            pathToRootNode.add(root);
            return true;
        }
        
        boolean right = getPathToRootNode(root.right, target);
        if(right){
            pathToRootNode.add(root);
            return true;
        }
        
        return false;
    }
}