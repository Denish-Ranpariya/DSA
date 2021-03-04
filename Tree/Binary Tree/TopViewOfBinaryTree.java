//same as vertical level traversal
//but print only first node of list of horizontal level

public class Pair{
    Node node;
    int hd; //horizontal distance
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class View
{
    // function should print the topView of the binary tree
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                Pair current = q.remove();
                
                if(hm.containsKey(current.hd)){
                    hm.get(current.hd).add(current.node.data);
                }else{
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    al.add(current.node.data);
                    hm.put(current.hd, al);
                }
                
                if(current.node.left != null){
                    q.add(new Pair(current.node.left, current.hd - 1));
                }
                
                if(current.node.right != null){
                    q.add(new Pair(current.node.right,current.hd + 1));
                }
            }
        }
        
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet());
        
        Collections.sort(sortedKeys);
        
        //include first node only
        for(int key : sortedKeys){
            result.add(hm.get(key).get(0));
        }
        
        return result;
    }
}

