//same as construction but here we are not constructing the tree
//first see /ConstructBSTFromPostorderTraversal
//we can do it by also first construction and after taking it pre order traversal

//but here we are going to use same terminology with few changes
//m-1 from construction of bst from postorder with few changes

//postorder L R N
//preorder N L R

import java.util.*;

class PrintPreorderFromPostorder {
    public static void main(String[] args) {
        int[] postorder = {35, 30, 100, 80, 40};

        //low will be 0 high wil be n - 1
        solve(postorder, 0, postorder.length - 1);

        //print preorder
        for(int i : result){
            System.out.println(i);
        }
    }

    //list to store preorder
    static ArrayList<Integer> result = new ArrayList<Integer>();
    
    //IMP
    //in this function we are using pre order because we need root at first 
    public static void solve(int[] postorder, int low, int high){
        
        //base condition
        if(low > high){
            return;
        }

        //add element at high to the list
        result.add(postorder[high]);

        //find just greater smaller index from preorder
        int justSmallerElementIndex = findJustSmalllerElementIndex(postorder, low, high);
        
        //left sub tree range will be low to index
        solve(postorder, low, justSmallerElementIndex);

        //right sub tree index will be index + 1 to high - 1
        solve(postorder, justSmallerElementIndex + 1, high -1);
        
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
