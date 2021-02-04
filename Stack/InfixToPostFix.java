//infix to postfix conversion
//only one digit
//only contain () brackets
//no space
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expresion:");
        String str = sc.nextLine();

        //stack for operators and brackets
        Stack<Character> s = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //if it is digit or letter then print it
            if(Character.isLetterOrDigit(ch)){
                System.out.print(ch);
            }else if(ch == '('){
                //if it is '(' then push it
                s.push(ch);
            }else if(ch == ')'){
                //if it is ')' then pop until '(' and print
                while(s.peek() != '('){
                    System.out.print(s.pop());
                }

                //pop '('
                s.pop();
            }else{
                //it is operator
                //pop until the top of stack is having same or large precedence and print it
                //or '(' is detected or stack is not empty
                while(!s.isEmpty() && s.peek() != '(' && precedence(s.peek()) >= precedence(ch)){
                    System.out.print(s.pop());
                }

                //push current ch
                s.push(ch);
            }
        }

        //if is there any element present is stack then pop it and print it
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }

    } 
    
     //this function will give the precedence of operator
     public static int precedence(char operator){
        // + - have same precedence 
        if(operator == '+'){
            return 1;
        }else if(operator == '-'){
            
            return 1;
        }else if(operator == '*'){
            // * / have same precedence but higher
            return 2;
        }else if(operator == '/'){
            return 2;
        }else{
            // ^
            return 3;
        }
    }
}
