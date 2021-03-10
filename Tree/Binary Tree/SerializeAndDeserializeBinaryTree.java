//serialization of tree means convert tree in a form in which it takes less space than actual tree
//then convert that into actual tree after receiving it at receiver's end
//if node doesn't have child then -1 to list during pre order traversal
class Tree {
	public void serialize(Node root, ArrayList<Integer> a) {

        //if root is null then add -1 to list 
        //base case
	    if(root == null){
	        a.add(-1);
	        return;
	    }
	    
        //add current node's data
	    a.add(root.data);
        //call for left sub tree
	    serialize(root.left, a);
        //call for right sub tree
	    serialize(root.right, a);
	}
	
    //static index for serialized tree for array list
	static int index; 
    public Node deSerialize(ArrayList<Integer> a){
        //reste index to start because we have done preorder in serialization
        index = 0;

        //pass list o function
        Node root = constructTreeFromSerializedArrayList(a);
        return root;
    }
    
    public static Node constructTreeFromSerializedArrayList(ArrayList<Integer> a){

        //if we have reached at the end of the list then return null
        //base case
        if(index == a.size()){
            return null;
        }    
        
        //if it is -1
        //then do nothing just increase index by 1 and return null
        if(a.get(index) == -1){
            index++;
            return null;
        }else{
            //if it is not -1 then create node and increase index
            //call for left sub tree and call for right sub tree
            //return node
            Node newNode = new Node(a.get(index));
            index++;
            newNode.left = constructTreeFromSerializedArrayList(a);
            newNode.right = constructTreeFromSerializedArrayList(a);
            return newNode;
        }
    }
    
};