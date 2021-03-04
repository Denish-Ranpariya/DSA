//find the root of second tree in first tree using level order traversal
//if found then check if trees are identical or not

class Tree {
    public static boolean isSubtree(Node node, Node S) {
        // add code here.
        if(node == null){
            return false;
        }
        
        //level order traversal
        Queue<Node> q = new LinkedList<Node>();
        
        q.add(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                Node current = q.remove();
                
                //if current node is same as root of second tree
                if(current.data == S.data){
                    //check if these two trees are identical or not
                    if(isIdenticle(current, S)){
                        return true;
                    }
                }
                
                if(current.left != null){
                    q.add(current.left);
                }
                
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
        
        return false;
    }
    
    //function to check if two binary trees are identical or not
    public static boolean isIdenticle(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        
        if((root1 != null && root2 == null) || (root1 == null && root2 != null)){
            return false;
        }
        
        if(root1.data != root2.data){
            return false;
        }
        
        boolean left = isIdenticle(root1.left, root2.left);
        boolean right = isIdenticle(root1.right, root2.right);
        
        if(left && right){
            return true;
        }else{
            return false;
        }
    }
    
}

