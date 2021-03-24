//count median of BST
//inorder of BST is sorted data

//M-1
//inorder traversal using recursion
//save data to arraylist
//TC - O(n) (visiting all nodes)
//SC - O(n) (saving inorder to arraylist)

//M-2
//count number of nodes using morris inorder traversal
//take half of it
//according to even or odd again do  morris  inorder traversal and find median
//TC - O(n) morris inorder 
//SC - O(1) because we are not using arraylist or not using recursion

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class MedianOfBST{

    static int numberOfNodes;
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
        // root = insert(root, 13);

        numberOfNodes = 0;
        
        countNodes(root);

        int middle1 = -1, middle2 = -1;

        if(numberOfNodes % 2 != 0){
            middle1 = numberOfNodes/2 +  1;
            middle2 = -1;

            int sum = getSum(root, middle1, middle2);

            System.out.println("median: " + sum);
        }else{
            middle1 = numberOfNodes/2;
            middle2 = numberOfNodes/2 + 1;

            int sum = getSum(root, middle1, middle2);

            System.out.println("median: " + (double)sum/2);
        }


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

    //function to count nodes in tree using morris inorder traversal
    public static void countNodes(Node root){
        
        Node current = root;

        while(current != null){
            if(current.left == null){
                numberOfNodes++;
                current = current.right;
            }else{
                Node predecesor = findPredecesor(current);
                if(predecesor.right == null){
                    predecesor.right = current;
                    current = current.left;
                }else{
                    predecesor.right = null;
                    numberOfNodes++;
                    current = current.right;
                }
            }
        }
        
    }

    //find sum of nodes which are middle nodes using morris inorder traversal
    public static int getSum(Node root, int middle1, int middle2){
        Node current = root;
        int sum = 0;
        int count = 0;

        while(current != null){
            if(current.left == null){
                // numberOfNodes++;
                count++;

                if(count == middle1 || count == middle2){
                    sum += current.data;
                }

                current = current.right;
            }else{
                Node predecesor = findPredecesor(current);
                if(predecesor.right == null){
                    predecesor.right = current;
                    current = current.left;
                }else{
                    predecesor.right = null;
                    // numberOfNodes++;
                    count++;

                    if(count == middle1 || count == middle2){
                        sum += current.data;
                    }
                    current = current.right;
                }
            }
        }

        return sum;
    }

    //function to find inorder predecesor in BST
    public static Node findPredecesor(Node node){
        Node current = node.left;

        while(current.right != node && current.right != null){
            current = current.right;
        }

        return current;
    }

     
}   