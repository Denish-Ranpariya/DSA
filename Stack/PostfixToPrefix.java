//postfix to prefix conversion
//no space
//only one digit or letter

//ab- to -ab
import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  a Postfix expression:");
        String str = sc.nextLine();

        //here we have to create a stack of type string because after concatination we have to push it agin to the stack
        Stack<String> s = new Stack<String>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                //if its letter or digit then push it to the stack
                s.push(Character.toString(ch));
            }else{
                //if it is operator then pop two time from the stack
                String v2 = s.pop();
                String v1 = s.pop();

                //imp
                //now push operator + v1 + v2  
                String tobePushed = Character.toString(ch) + v1 + v2;
                s.push(tobePushed);
            }
        }

        //after the loop only one element will remain in stack which will be final result

        System.out.println(s.pop());

        

    }
}
