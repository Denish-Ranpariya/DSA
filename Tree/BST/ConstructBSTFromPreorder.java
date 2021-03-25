//preorder node-left-right

//M-1
//in preorder array first element will be root
//create node from element at index low
//find just greater index element than low
//left sub tree will be from low + 1 to index - 1
//right sub tree will be from index to high
//TC - O(n^2) because recursion + find just greater element
//SC - O(height of tree) recursion

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        //low - 0 
        //high - length -1
        TreeNode root = solve(preorder, 0, preorder.length - 1);
        return root;
    }
    
    public static TreeNode solve(int[] preorder, int low, int high){
        
        //base condition 
        //attach null
        if(low > high){
            return null;
        }
        
        //create node with value at index low
        TreeNode root = new TreeNode(preorder[low]);
        
        //find index of just greater element
        int justGreaterElementIndex = justGreaterIndex(preorder, low, high);
        
        //left sub tree range will be from low + 1 to index- 1
        root.left = solve(preorder, low + 1, justGreaterElementIndex - 1);

        //right sub tree range will be from index to high
        root.right = solve(preorder, justGreaterElementIndex, high);
        
        //attach newly created node
        return root;
    }
    
    //function to find index of just greater element than element at index low
    public static int justGreaterIndex(int[] arr, int low, int high){
        int i = low;
        for(i = low; i <= high; i++){
            if(arr[i] > arr[low]){
                return i;
            }
        }
        
        return i;
    }
}

//M-2
//using range method
//TC - O(n)
//SC - O(height of tree) recursion

class Solution {
    
    //index of preorder array
    static int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index= 0;
        TreeNode root = solve(preorder,Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    public static TreeNode solve(int[] preorder, int low, int high){

        //base condition
        //if index is overflowed or
        //data is smaller than low range or
        //data is larger than high range
        //then attach null
        if(index >= preorder.length || preorder[index] < low || preorder[index] > high ){
            return null;
        }
        
        //create new node with data at index and increment index by 1
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        
        //left range will be low to root.val - 1
        root.left = solve(preorder, low, root.val - 1);

        //right range will be root.val + 1 to high
        root.right = solve(preorder, root.val  + 1, high);
        
        //attach node
        return root;
    }
    

    
    
}