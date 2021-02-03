//get minimum element from stack
//this solution is with O(1) time coplexity and O(n) space complexity
import java.util.Stack;

class SpecialStack {
    // main stack
    Stack<Integer> s = new Stack<Integer>();

    // to keep the track of min element
    // min element of main stack will be always on the top of minStack
    Stack<Integer> minStack = new Stack<Integer>();

    // when we push an element to main stack we will compare it with top element of
    // minstack
    // if the element is less than the top element of minstack then push it to
    // minstack else push previous element to the minstack
    void push(int data) {
        if(s.isEmpty() || minStack.isEmpty() ){
            s.push(data);
            minStack.push(data);
            return;
        }
        if (minStack.peek() > data) {
            s.push(data);
            minStack.push(data);
        } else {
            s.push(data);
            int temp = minStack.peek();
            minStack.push(temp);
        }
    }

    // in pop operation we will pop from both stack with out any comparison
    int pop() {
        int temp = s.pop();
        minStack.pop();
        return temp;
    }

    int getMin() {
        return minStack.peek();
    }
}

public class GetMinElementWithExtraSpace {
    public static void main(String[] args){
        SpecialStack s = new SpecialStack();
        s.push(18);
        s.push(19);
        s.push(29);
        s.push(15);
        s.push(16);
        s.push(0);
        s.pop();
        System.out.println("Min element is: " + s.getMin());
    }
}
