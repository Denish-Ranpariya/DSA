//do inorder traversal and add it to sum
//then set data of node to sum
//easy peasy

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}


public class SumOfAllSmallerKey{
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 8);
        root = insert(root, 3);
        root = insert(root, 10);
        root = insert(root, 1);
        root = insert(root, 6);
        root = insert(root, 14);
        root = insert(root, 4);
        root = insert(root, 7);
        root = insert(root, 13);

        System.out.println("before conversion");

        inorder(root);

        System.out.println();

        //convert BST to Smaller Sum BST
        convertToSmallerSumTree(root);

        System.out.println("before conversion");

        inorder(root);
    }

    public static Node insert(Node root, int key)
    {
        // your code here
        if(root == null){
            Node newNode = new Node(key);
            return newNode;
        }
        
        if(root.data == key){
            return root;
        }
        
        if(root.data > key){
            root.left = insert(root.left, key);
        }
        
        if(root.data < key){
            root.right = insert(root.right, key);
        }
        
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //keep track of sum till current node
    static int sum = 0;
    public static void convertToSmallerSumTree(Node root){

        //base condition
        if(root == null){
            return;
        }

        //recursive call to left sub tree
        convertToSmallerSumTree(root.left);

        //add current node's data to sum
        sum += root.data;
        //change current node's data to sum
        root.data = sum;

        //recursive call to right sub tree
        convertToSmallerSumTree(root.right);
    }
}