class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }

        //queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        //add root node
        q.add(root);
        
        //while queue is not empty
        while(!q.isEmpty()){

            //calculate size of queue
            int size = q.size();
            
            TreeNode current = null;
            
            //remove nodes of current level and add nodes of next level if exists
            for(int i = 0; i < size; i++){
                current = q.remove();
                
                if(current.left != null){
                    q.add(current.left);
                }
                
                if(current.right != null){
                    q.add(current.right);
                }
            }
            
            //add last node of queue because it is right most node of current level
            result.add(current.val);
        }
        
        return result;
    }
}