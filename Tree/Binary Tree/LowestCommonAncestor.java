//find paths from node to root for both nodes
//check in reverce in both arraylist


class Tree
{

    ArrayList<Node> nodeToRoot1;
    ArrayList<Node> nodeToRoot2;
	Node lca(Node root, int n1,int n2)
	{
	    nodeToRoot1 = new ArrayList<Node>();
	    nodeToRoot2 = new ArrayList<Node>();
	    
        
	    
        //set both pointers at last in both lists because we are checking from root
	    int i = nodeToRoot1.size() - 1;
	    int j = nodeToRoot2.size() - 1;
	    
	    while(i >= 0 && j >= 0){

            //as nodes are different then break the loop
	        if(nodeToRoot1.get(i) != nodeToRoot2.get(j)){
	            break;
	        }
	        i--;
	        j--;
	    }
	    
        //return node at i+1 or j+1 index because it was last common node in both list
	    return nodeToRoot1.get(i+1);
	    
	    
		
	}
	
    //function to find path from node to root
	public static boolean pathToRoot(Node node, int target, ArrayList<Node> list){
	    if(node == null){
	        return false;
	    }
	    
	    if(node.data == target){
	        list.add(node);
	        return true;
	    }
	    
	    boolean left = pathToRoot(node.left, target, list);
	    if(left){
	        list.add(node);
	        return true;
	    }
	    
	    boolean right = pathToRoot(node.right, target, list);
	    if(right){
	        list.add(node);
	        return true;
	    }
	    
	    return false;
	}
}