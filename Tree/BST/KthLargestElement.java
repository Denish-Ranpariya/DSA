//inorder traversal
//save to list
//return element at index n - k
//TC O(n)
//SC O(n) (list + recursion stack)
class Solution
{
    static ArrayList<Integer> inorderTree;
    public int kthLargest(Node root,int K)
    {
        inorderTree = new ArrayList<>();
        inorder(root);
        
        int n = inorderTree.size();
        
        return (n - K) < 0 ? -1 : inorderTree.get(n - K);
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

//reverse inorder traversal (right node left)
//TC O(n)
//SC O(height of BST) (recursion stack)

class Solution
{
    static int count;
    static int kthLargest;
    public int kthLargest(Node root,int K)
    {
       //count node's visited
        count = 0;
        kthLargest = -1;
        
        solve(root,K);
        
        return kthLargest;
    }
    
    public static void solve(Node root, int k){
        
        if(root == null){
            return;
        }
        
        solve(root.right, k);
        
        //increment count
        count++;

        //check wether current node is kth largest node or not
        if(count == k){
            kthLargest = root.data;
            return;
        }
        solve(root.left, k);
        
    }
}

//using reverse inorder morris traversal
//in inorder morris traversal replace left with right and vice verca
//replace inorder predecessor with inorder successor
//TC O(n)
//SC O(1)
class Solution
{
    static int count;
    static int kthLargest;
    public int kthLargest(Node root,int K)
    {
        count = 0;
        kthLargest = -1;
        // Write your code here
        morrisInorder(root, K);
        
        return kthLargest;
    }
    
    public static void morrisInorder(Node root, int k){

        Node current = root;

        while(current != null){
            
            if(current.right == null){

                //here
                count++;
                if(count == k){
                    kthLargest = current.data;
                }

                current = current.left;
            }else{
                Node  successor = findSuccessor(current);

                if(successor.left == null){
                    successor.left = current;
                    current = current.right;
                }else{
                    successor.left = null;
                    
                    //here
                    count++;
                    if(count == k){
                        kthLargest = current.data;
                    }
                    
                    current = current.left;
                }
            }
        }
    }
    public static Node findSuccessor(Node node){
        Node current = node.right;

        while(current.left != node && current.left != null){
            current = current.left;
        }

        return current;
    }
}