//boundary of a binary tree
//left boundary
//leaf nodes
//right boundary

class Solution
{
    
    static ArrayList<Integer> leftBoundary = new ArrayList<Integer>();
    static ArrayList<Integer> rightBoundary = new ArrayList<Integer>();
    static ArrayList<Integer> leafNodes = new ArrayList<Integer>();
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    if(node == null){
	        return result;
	    }
	    
        //clear global statics
	    leftBoundary.clear();
	    rightBoundary.clear();
	    leafNodes.clear();
	    
        //add root node's data
	    result.add(node.data);
	    
        //find left boundary for left node of root
	    getLeftBoundary(node.left);

        //find all the leaf nodes
	    getLeafNodes(node);

        //find right boundary fro right node of root
	    getRightBoundary(node.right);
	    
	    //remove last node's data in both left and right boundaries because they are leaf nodes
        //which are included in leafnodes list
	    if(leftBoundary.size() != 0){
	        leftBoundary.remove(leftBoundary.size() - 1);
	    }
	    
	    if(rightBoundary.size() != 0){
	        rightBoundary.remove(rightBoundary.size() - 1);
	    }
	    
        //reverse the list of righ boundary
	    Collections.reverse(rightBoundary);
	    
        //add left boundary then leafnodes than right boundary
	    result.addAll(leftBoundary);
	    result.addAll(leafNodes);
	    result.addAll(rightBoundary);
	    
	    return result;
	}
	
    //function to find left boundary
	public static void getLeftBoundary(Node node){
        //base case
	    if(node == null){
	        return;
	    }
	    
        //add data of node
	    leftBoundary.add(node.data);
	    
        //first priority is left child node
        //so if left child exists then goto left child
	    if(node.left != null){
	        getLeftBoundary(node.left);
	    }else if(node.right != null){
            //otherwise goto right child
	        getLeftBoundary(node.right);
	    }
	}
	
    //functions to find right boundary
	public static void getRightBoundary(Node node){\

        //base case
	    if(node == null){
	        return;
	    }
	    
        //add node data
	    rightBoundary.add(node.data);

        //priority of right is higher
        //if right child exists then goto right chil 
	    if(node.right != null){
	        getRightBoundary(node.right);
	    }else if(node.left != null){
            //otherwise go to left child
	        getRightBoundary(node.left);
	    }
	}
	
    //function to find leaf nodes
    //pre order traversal
	public static void getLeafNodes(Node node){
	    
        //base case
        if(node == null){
	        return;
	    }
	    
        //if both children are null then it is a leaf node 
        //so add it to the list
	    if(node.left == null && node.right == null){
	        leafNodes.add(node.data);
	    }
	    
	    //left subtree
	    getLeafNodes(node.left);

        //right subtree  
	    getLeafNodes(node.right);
	}
	
}