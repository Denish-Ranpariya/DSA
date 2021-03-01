/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
// If there are multiple nodes passing through a vertical line, 
// then they should be printed as they appear in level order traversal of the tree.

//because here level order is given in problem so we are going to use level order traversal

public class Pair{
    Node node;
    int horizontalDistance;
    Pair(Node node, int horizontalDistance){
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

class BinaryTree
{
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //queue because we are doing level order traversal here
        Queue<Pair> q = new LinkedList<Pair>();
        
        //hashmap to store arraylist with perticular horizontal distance
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        
        //add root to the queue
        //root have horizontal distance 0
        //left side negative
        //right side positive
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair current = q.remove();
                
                //if hashap already contains arraylist with current pair's node's horizontal distance then add it to that arraylist
                if(hm.containsKey(current.horizontalDistance)){
                    hm.get(current.horizontalDistance).add(current.node.data);
                }else{
                    //otherwise create new arraylist and add it to hashmap with givem horizontal distance as key
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    al.add(current.node.data);
                    hm.put(current.horizontalDistance, al);
                }
                
                //add left child if exists
                //horizontal distance will be -1 than current node
                if(current.node.left != null){
                    q.add(new Pair(current.node.left, current.horizontalDistance - 1));
                }
                
                //add right child if exists
                //horizontal distance will be +1 than current node
                if(current.node.right != null){
                    q.add(new Pair(current.node.right, current.horizontalDistance + 1));
                }
            }
        }
        
        //now we have our hashmap ready with arraylists of particular horizintal distances
        //sort it according to keys (horizontal distance)

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet()); 
          
        Collections.sort(sortedKeys);
        
        //add arraylists one by one to result list
        for(int key : sortedKeys){
            result.addAll(hm.get(key));
        }
        
        return result;
        
    }
}
