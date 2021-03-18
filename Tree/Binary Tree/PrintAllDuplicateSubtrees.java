// Given a binary tree of size N, your task is to complete the function printAllDups(), 
// that finds and prints all duplicate subtrees from the given binary tree.
// For each duplicate subtrees, you only need to print the root node value of any one of them.
// Two trees are duplicate if they have the same structure with same node values.

//if node is null then take 'X'
//represent every subtree with string
//store this all subtree strings in a hashmap
//if count for string becomes 2 then add it to result because it is duplicate subtree

class Solution {
    
    static HashMap<String, Integer> hm;
    static ArrayList<Integer> result;
    public void printDup(Node root){
        
        hm = new HashMap<String, Integer>();
        result = new ArrayList<Integer>();
        
        solve(root);
        
        //sort result list (mentioned in question)
        Collections.sort(result);
        
        //if result list is empty then print -1
        if(result.size() != 0){
            for(int i = 0; i < result.size(); i++){
                System.out.print(result.get(i) + " ");
            }
        }else{
            System.out.print("-1");
        }
        
        
        System.out.println();
    }
    
    public static String solve(Node node){

        //base case
        //if null then return 'X'
        if(node == null){
            return "X";
        }
        
        //take string of left sub tree
        String left = solve(node.left);

        //take string of right sub tree
        String right = solve(node.right);
        
        //combine (node data) + left sub tree + right sub tree
        String str = Integer.toString(node.data) + left + right;
        
        //if hashmap already contains sring then increment count
        if(hm.containsKey(str)){
            hm.put(str, hm.get(str) + 1);
        }else{
            //else put it with count 1
            hm.put(str, 1);
        }
        
        //if count of a string is 2 then include it to result
        if(hm.get(str) == 2){
            result.add(node.data);
        }
        
        //return combined string
        return str;
    }
}