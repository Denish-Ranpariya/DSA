import java.util.Scanner;

class Stack{
    int maxSize;
    char[] stack;
    int top;

    Stack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new char[maxSize];
        this.top = -1;
    }

    public void push(char data){
        if(top == maxSize - 1){
            System.out.println("Stack Overflow");
            return;
        }else{
            top++;
            stack[top] = data;
        }
    }

    public char pop(){
    
        char temp = stack[top];
        top--;
        return temp;
        
    }

    public char peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(top == maxSize - 1){
            return true;
        }else{
            return false;
        }
    }

    public void printStack(){
        if(isEmpty()){
            return;
        }
        for(int i = top; top >= 0; i--){
            System.out.println(pop());
        }
    }
}

public class ReverseString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string you want to reverse:");
        String str = sc.nextLine();

        Stack s = new Stack(str.length());

        for(int i = 0; i < str.length(); i++){
            s.push(str.charAt(i));
        }

        String reversedString = "";
        for(int i = 0; i < str.length(); i++){
            String poppedChar = Character.toString(s.pop());
            reversedString = reversedString.concat(poppedChar); 
            // System.out.println(poppedChar);
        }

        System.out.println("Reversed String is: " + reversedString);

    }
}