//program to revrese a stack using recursion
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        reverse(s);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }

    private static void reverse(Stack<Integer> s) {
        if(s.isEmpty()){
            //do nothing 
            //just to stop recursion
            //base case
        }else{

            //remove top element
            int a = s.pop();

            //reverse remaining stack
            reverse(s);

            //add removed element at last
            addAtEnd(s,a);
        }
    }

    public static void addAtEnd(Stack<Integer> s,int data){

        //if stack is empty then just push it to the stack
        if(s.isEmpty()){
            s.push(data);
        }else{

            //remove top element 
            int a = s.pop();
            
            //add data to remaining stack
            addAtEnd(s,data);
            
            //push the removed element
            s.push(a);
        }
    }

}
