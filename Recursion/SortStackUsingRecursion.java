import java.util.*;

//same as SortArrayUsingRecursion

class SortStackUsingRecursion{
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(2);
        s.push(7);
        s.push(0);
        s.push(3);

        System.out.println("Before sorted:");
        
        for(Integer i : s){
            System.out.print(i + " ");
        }

        System.out.println("\nAfter sorting");

        s = sortStack(s);

        for(Integer i : s){
            System.out.print(i + " ");
        }


    }

    public static Stack<Integer> sortStack(Stack<Integer> s){
        if(s.size() == 1){
            return s;
        }

        int poppedElement = s.pop();

        s = sortStack(s);

        s = insertElement(s,poppedElement);

        return s;
    }

    public static  Stack<Integer> insertElement(Stack<Integer> s, int poppedElement){

        if(s.size() == 0 || s.peek() <= poppedElement){
            s.push(poppedElement);
            return s;
        }

        int last = s.pop();

        s = insertElement(s,poppedElement);

        s.push(last);

        return s;
    }
}