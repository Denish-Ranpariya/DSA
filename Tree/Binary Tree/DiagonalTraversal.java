// If there are multiple nodes passing through a vertical line, 
// then they should be printed as they appear in pre order traversal of the tree.

//because here level order is given in problem so we are going to use level order traversal

class Tree
{
    //hashmap
    //key - horizontal distance
    //value - list of nodes with same horizontal distance
    static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    public ArrayList<Integer> diagonal(Node root){
           
        //clear global statics
        hm.clear();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //call recursive function for preorder traversal also pass horizontal distance
        traverse(root, 0);
        
        //now here our hashmap will be filled
        //sort keys of hashmap
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet());
        
        Collections.sort(sortedKeys);
        
        //add arraylists of keys one by one to result arraylist
        for(int key : sortedKeys){
            result.addAll(hm.get(key));
        }
        return result;
    }
    
    //pre order traversal
    public static void traverse(Node root,int horizontalDistance){
        if(root == null){
            return;
        }
        
        //if hashmap already contains horizontal level as key 
        //then add node's value to arraylist according to key(horizontal distance) 
        if(hm.containsKey(horizontalDistance)){
            hm.get(horizontalDistance).add(root.data);
        }else{
            //otherwise create new arraylist 
            //add node's value to arraylist 
            //add that arraylist to hashmap
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(root.data);
            hm.put(horizontalDistance, al);
        }
        
        //leftnode will be have +1 horizontal distance
        traverse(root.left, horizontalDistance + 1);

        //leftnode will be have same horizontal distance
        traverse(root.right, horizontalDistance);
    }
}