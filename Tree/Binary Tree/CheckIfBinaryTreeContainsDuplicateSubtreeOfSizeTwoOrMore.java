// Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

//if node is null then take 'X'
//represent every subtree with string
//store this all subtree strings in a hashmap (only add strings with length > 3 to hashmap)
//because representation of a node is of length 3 ('data'XX)
//if count for string becomes 2 then add it to result because it is duplicate subtree
class Solution {
    static HashMap<String, Integer> hm;
    static ArrayList<Integer> result;
    int dupSub(Node root) {
        hm = new HashMap<String, Integer>();
        result = new ArrayList<Integer>();
        
        solve(root);
        
        //sort result list (mentioned in question)
        Collections.sort(result);
        
        //if result list is empty then print -1
        return result.size() == 0 ? 0 : 1;
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
        
        //add only strings with length > 3
        if(str.length() > 3){
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
        }
        
        //return combined string
        return str;
    }
}