//find root to node path for both the nodes
//in both list start from last(which means start from root)
//as soon as different node encountered break the loop
//increment both counter in order to find lowest common ancestor
//return sum of both index

class GfG {
    ArrayList<Node> nodeToRoot1;
    ArrayList<Node> nodeToRoot2;
    int findDist(Node root, int n1, int n2) {
        // Your code here
        nodeToRoot1 = new ArrayList<Node>();
	    nodeToRoot2 = new ArrayList<Node>();
	    
        //find node to root path for node 1
	    boolean b1 = pathToRoot(root, n1, nodeToRoot1);

        //find node to root path for node 2
	    boolean b2 = pathToRoot(root, n2, nodeToRoot2);
	    
        //if one of then is not present
	    if(b1 == false || b2 == false){
	        return -1;
	    }
	    
        //both pointer points to last
        //i.e. root node
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
        
        //increment both pointer to reach at lowest common ancestor
	    i++;
	    j++;
	    
        //return sum of both index
	    return i + j;
    }
    
    //function to find node to root path
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