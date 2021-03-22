//do inorder traversal and store in arraylist
//return element at k-1 index
//TC O(n)
//SC O(n) (arraylist + recursion stack)

class Solution
{
    static ArrayList<Integer> inorderTree;
    public int KthSmallestElement(Node root, int K) 
    {
        inorderTree = new ArrayList<>();
        inorder(root);
        
        return K > inorderTree.size() ? -1 : inorderTree.get(K-1);
        
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        inorderTree.add(root.data);
        inorder(root.right);
    }
    
}


//inorder traversal
//TC O(n)
//SC O(height of tree) (recursion stack)

class Solution
{
    static int count;
    static int kthSmallest;
    public int KthSmallestElement(Node root, int K) 
    {
        
        //count node's visited
        count = 0;
        kthSmallest = -1;
        
        solve(root,K);
        
        return kthSmallest;
    }
    
    public static void solve(Node root, int k){
        
        if(root == null){
            return;
        }
        
        solve(root.left, k);
        
        //increment count
        count++;

        //check wether current node is kth smallest node or not
        if(count == k){
            kthSmallest = root.data;
            return;
        }
        solve(root.right, k);
        
    }
}

//using morris inorder traversal
//where we were printing the node data in traversal
//instead of printing count++ and check count == k

class Solution
{
    static int count;
    static int kthSmallest;
    public int KthSmallestElement(Node root, int K) 
    {
        
        count = 0;
        kthSmallest = -1;
        // Write your code here
        morrisInorder(root, K);
        
        return kthSmallest;
    }
    
    public static void morrisInorder(Node root, int k){

        Node current = root;

        while(current != null){
            
            if(current.left == null){

                //here
                count++;
                if(count == k){
                    kthSmallest = current.data;
                }

                current = current.right;
            }else{
                Node  predecesor = findPredecesor(current);

                if(predecesor.right == null){
                    predecesor.right = current;
                    current = current.left;
                }else{
                    predecesor.right = null;
                    
                    //here
                    count++;
                    if(count == k){
                        kthSmallest = current.data;
                    }
                    
                    current = current.right;
                }
            }
        }
    }
    public static Node findPredecesor(Node node){
        Node current = node.left;

        while(current.right != node && current.right != null){
            current = current.right;
        }

        return current;
    }
    
    
}