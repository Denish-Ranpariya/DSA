//remove leaf nodes and create doubly linked list of them
class Tree{
    static Node head;
    static Node tail;
    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root)
    {
        // Code here
        head = null;
	    tail = null;
	    
	    if(root == null){
	        return null;
	    }
	    
	    removeLeaves(root);
	    
	    return head;
    }
    
    //function which will remove leaf nodes and add it to doubly linkedlist
    //watch pepcoding video for remove leaf nodes
    public static Node removeLeaves(Node root){

        //if node is null then return null
        if(root == null){
            return null;
        }
        
        //if node is leaf node then add it to doubly linked list and return null
        if(root.left == null && root.right == null){
            insertToDLL(root.data);
            return null;
        }
        
        //call for left sub tree and attach it to left
        root.left = removeLeaves(root.left);

        //call for right sub tree and attach it to right
        root.right = removeLeaves(root.right);
        
        //return node
        return root;
    }
    
    public static void insertToDLL(int data){
        
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
    }
}