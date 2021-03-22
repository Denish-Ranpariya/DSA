//same as binary tree   

class BST
{   
    static ArrayList<Node> path1;
    static ArrayList<Node> path2;
	Node LCA(Node root, int n1, int n2)
	{
	    path1 = new ArrayList<>();
	    path2 = new ArrayList<>();
	    
	    pathToRoot(root, n1, path1);
	    pathToRoot(root, n2, path2);
	    
	    int p1 = path1.size() - 1;
	    int p2 = path2.size() - 1;
	    
	    while(p1 >= 0 && p2 >= 0){
	        if(path1.get(p1) != path2.get(p2)){
	            break;
	        }
	        p1--;
	        p2--;
	    }
	    
	    return path1.get(p1 + 1);
    }
    
    
    public static boolean pathToRoot(Node node, int key, ArrayList<Node> al){
        if(node == null){
            return false;
        }
        
        if(node.data == key){
            al.add(node);
            return true;
        }
        
        boolean left = pathToRoot(node.left, key, al);
        if(left){
            al.add(node);
            return true;
        }
        
        boolean right = pathToRoot(node.right, key, al);
        if(right){
            al.add(node);
            return true;
        }
        
        return false;
    }
}