//infix to prefix conversion
//only one digit
//only contain () brackets
//no space

//same as infix to postfix
//reverse the string or traverce from last
//replace '(' by ')'
//replace ')' by '('
//result result
import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a expresion:");
        String str = sc.nextLine();

        
        //result
        String result = "";

        //stack for operators and brackets
        Stack<Character> s = new Stack<Character>();

        //reversed string
        String reversedString = "";

        //reverse the string and replace '(' with ')' and vice versa
        for(int i = str.length() - 1; i >= 0 ; i--){
            if(str.charAt(i) == '('){
                reversedString += ')';
            }else if(str.charAt(i) == ')'){
                reversedString += '(';
            }else{
                reversedString += str.charAt(i);
            }
        }

        
        for(int i = 0 ; i < reversedString.length() ; i++){
            char ch = reversedString.charAt(i);

            //if it is digit or letter then print it
            if(Character.isLetterOrDigit(ch)){
                result += ch;
            }else if(ch == '('){
                //if it is '(' then push it
                s.push(ch);
            }else if(ch == ')'){
                //if it is ')' then pop until '(' and print
                while(s.peek() != '('){
                    result += s.pop();
                }

                //pop '('
                s.pop();
            }else{
                //it is operator
                //pop until the top of stack is having same or large precedence and print it
                //or '(' is detected or stack is not empty
                while(!s.isEmpty() && s.peek() != '(' && precedence(s.peek()) >= precedence(ch)){
                    result += s.pop();
                }

                //push current ch
                s.push(ch);
            }
        }

        //if is there any element present is stack then pop it and print it
        while(!s.isEmpty()){
            result += s.pop();
        }

        //print result in reverse
        for(int i = result.length() - 1; i >= 0 ; i--){
            System.out.print(result.charAt(i));
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
