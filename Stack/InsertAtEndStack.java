import java.util.Stack;
public class InsertAtEndStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        addAtEnd(s,5);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }

    public static void addAtEnd(Stack<Integer> s,int data){
        if(s.isEmpty()){
            //base case
            s.push(data);
        }else{

            int a = s.pop();

            //recursion
            addAtEnd(s,data);
            s.push(a);
        }
    }
}
