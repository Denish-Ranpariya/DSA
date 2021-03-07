class Solution
{
    static Node head;
    static Node tail;
    Node bToDLL(Node root)
    {
	//  Your code here	
	
	    head = null;
	    tail = null;
	    
	    if(root == null){
	        return null;
	    }
	    
        //inorder traversal
	    inorder(root);
	    
	    return head;
	
    }
    
    //inorder traversal
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        
        //insert to doubly linked list
        insertToDLL(root.data);
        
        inorder(root.right);
    }
    

    //method to insert new node to the tail of doubly linkedlist
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