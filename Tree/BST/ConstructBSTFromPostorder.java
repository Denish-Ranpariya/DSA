//post order left-right-node

//M-1
//in postorder array last element will be root
//create node from element at index high
//find just smaller index element than high
//right sub tree will be from index + 1 to high - 1
//left sub tree will be from low to index
//TC - O(n^2) because recursion + find just smaller element
//SC - O(height of tree) recursion
class GFG
{
    public static Node constructTree(int post[],int n)
    {
        
        Node root = solve(post, 0, n - 1);
        return root;
    }
    
    public static Node solve(int[] post, int low, int high){
        //base condition
        //if low is larger than high
        //attch null
        if(low > high){
            return null;
        }
        
        //create node from data at index high
        Node root = new Node(post[high]);
        
        //find index of just smaller element
        int justSmallerIndex = findJustSmalllerElementIndex(post, low, high);
        
        //first construct right sub tree (because post order)

        //range for right sub tree index + 1 to high - 1 
        root.right = solve(post, justSmallerIndex + 1, high - 1);

        //range for left sub tree low to index
        root.left = solve(post, low, justSmallerIndex);
        
        //attach node 
        return root;
    }
    
    //fuction to find just smaller element index
    public static int findJustSmalllerElementIndex(int[] arr, int low, int high){
        int i = high;
        for(i = high; i >= low; i--){
            if(arr[i] < arr[high]){
                break;
            }
        }
        return i;
    }
}

//M-2
//using range method
//TC - O(n)
//SC - O(height of tree) recursion

class GFG
{
    public static Node constructTree(int post[],int n)
    {
        //set index at last node
        index = n - 1;
        Node root = solve(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
     //index of preorder array
    static int index;
    public static Node solve(int[] post, int low, int high){

        //base condition
        //if index is overflowed or
        //data is smaller than low range or
        //data is larger than high range
        //then attach null
        if(index < 0 || post[index] < low || post[index] > high){
            return null;
        }
        
         //create new node with data at index and decrement index by 1
        Node root = new Node(post[index]);
        index--;
        
        //right range will be root.val + 1 to high    
        root.right = solve(post, root.data + 1, high);

        //left range will be low to root.val - 1
        root.left = solve(post, low, root.data - 1);
        
        //attach node
        return root;
    }
}