//same as construction but here we are not constructing the tree
//first see /ConstructBSTFromPreorderTraversal
//we can do it by also first construction and after taking it post order traversal

//but here we are going to use same terminology with few changes
//m-1 from construction of bst from preorder with few changes


//preorder N L R
//postorder L R N

import java.util.*;

class PrintPostorderFromPreorder {
    public static void main(String[] args) {
        int[] preorder = {40,30,35,80,100};

        //low will be 0 high wil be n - 1
        solve(preorder, 0, preorder.length - 1);

        //print postorder
        for(int i : result){
            System.out.println(i);
        }
    }

    //list to store postorder
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    //IMP
    //in this function we are using post order because we need root at last 
    public static void solve(int[] preorder, int low, int high){
        
        //base condition
        if(low > high){
            return;
        }

        //find just greater element index from preorder
        int justGreaterElementIndex = justGreaterIndex(preorder, low, high);
        
        //left sub tree will be from low+1 to index - 1
        solve(preorder, low + 1, justGreaterElementIndex - 1);

        //right sub tree will be from index to high
        solve(preorder, justGreaterElementIndex, high);
        
        //add element at index low to result
        result.add(preorder[low]);
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
