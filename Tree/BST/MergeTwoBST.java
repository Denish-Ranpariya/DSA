//with space

//given two BST 
//return inorder of merged BST


//do inorder traversals of both BST
//store them in two arraylists
//merge these two sorted arraylist
//that will be inorder traversal of Merged BST

class Solution{
    // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
    static ArrayList<Integer> inorderTree1;
    static ArrayList<Integer> inorderTree2;
    
    public List<Integer> merge(Node root1,Node root2)
    {
        inorderTree1 = new ArrayList<>();
        inorderTree2 = new ArrayList<>();
        
        //inorder of two BSTs
        inorder(root1, inorderTree1);
        inorder(root2, inorderTree2);
        
        //merge two sorted list
        int p1 = 0;
        int p2 = 0;
        
        ArrayList<Integer> merged = new ArrayList<>();
        
        while(p1 < inorderTree1.size() && p2 < inorderTree2.size()){
            int nodeData1 = inorderTree1.get(p1);
            int nodeData2 = inorderTree2.get(p2);
            
            if(nodeData1 < nodeData2){
                merged.add(nodeData1);
                p1++;
            }else{
                merged.add(nodeData2);
                p2++;
            }
        }
        
        while(p1 < inorderTree1.size()){
            merged.add(inorderTree1.get(p1));
            p1++;
        }
        
        while(p2 < inorderTree2.size()){
            merged.add(inorderTree2.get(p2));
            p2++;
        }
        
        return merged;
        
    }
    
    public static void inorder(Node root, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right, al);
    }
}