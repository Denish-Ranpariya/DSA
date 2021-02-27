//this code contains multiple functions check them all in detail

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data,Node left,Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

//Node with state
//if state is 1 then attach node at left side
//if state is 2 then attach node at right side
//if state is 3 then both sides have nodes so pop it
class Pair{
    Node node;
    int state;

    Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

class CreateBinaryTree{
    public static void main(String[] args) {

        //preorder of binary tree is given
        Integer[] arr = {50, 15, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        //stack 
        Stack<Pair> st = new Stack<Pair>();

        //create root node
        Node rootNode = new Node(arr[0], null, null);

        //push it to the stack with state 1
        st.push(new Pair(rootNode, 1));

        int index = 0;

        //while stack doesn't becomes empty check the top of the stack and work according to its state
        while(!st.isEmpty()){
            Pair top = st.peek();

            //if state is 1 then attach node at left side
            if(top.state == 1){
                index++;

                //if data is not null
                if(arr[index] != null){
                    //create node
                    Node leftNode = new Node(arr[index], null, null);

                    //attach it to left side
                    top.node.left = leftNode;

                    //push it to the stack with status 1
                    st.push(new Pair(leftNode, 1));
                }else{
                    top.node.left = null;
                }

                //increase state of it by 1 for both cases
                top.state++;

            }else if(top.state == 2){
                //if state is 1 then attach node at right side

                index++;

                //if data is not null
                if(arr[index] != null){

                    //create the node
                    Node rightNode = new Node(arr[index], null, null);

                    //attach it to right
                    top.node.right = rightNode;

                    //push it to the stack with status 1
                    st.push(new Pair(rightNode, 1));
                }else{
                    top.node.right = null;
                }

                //increase state of it by 1 for both cases
                top.state++;
            }else{

                //if status is 3 then pop it because both children are attached
                st.pop();
            }
        }

        display(rootNode);
        System.out.println("size(number of nodes): " + size(rootNode));
        System.out.println("Sum: "+ sum(rootNode));
        System.out.println("Max Node: " + max(rootNode));
        System.out.println("Height: " + height(rootNode));
        pathToRoot(rootNode, 37);
        System.out.println("Path from 37 to root: " + result);
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str +=  node.left == null ? "." : node.left.data;
        str += "<-" + Integer.toString(node.data) + "->";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        int numberOfNodesInLeftSubtree = size(node.left);
        int numberOfNodesInRightSubtree = size(node.right);

        return (numberOfNodesInLeftSubtree + numberOfNodesInRightSubtree + 1);
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int leftSubTreeSum = sum(node.left);
        int rightSubTreeSum = sum(node.right);

        return (leftSubTreeSum + rightSubTreeSum + node.data);
    }

    public static int max(Node node){
        if(node == null){
            //identity for max operation
            return Integer.MIN_VALUE;
        }

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(node.data, Math.max(leftMax,rightMax));
    }

    public static int height(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    //we want to find the path from node with given key to root node
    //for this function see the video of pepcoding on youtube
    //when node is found for the first time then all the way to the root it will return true so when true is returned then print it
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static boolean pathToRoot(Node root,int key){

        //if tree doesn't exist then return false
        if(root == null){
            return false;
        }

        //if root itsefl is the node with given key then return true
        if(root.data == key){
            result.add(root.data);
            return true;
        }

        //find in left subtree 
        //if found then return true
        boolean left = pathToRoot(root.left, key);
        if(left){
            result.add(root.data);
            return true;
        }

        //find in right subtree
        //if found then return true
        boolean right = pathToRoot(root.right, key);
        if(right){
            result.add(root.data);
            return true;
        }

        //if in all the above cases node is not found then node doesn't exists in the tree
        //so return false
        return false;

    }
}