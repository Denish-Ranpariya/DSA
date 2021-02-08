import java.util.Scanner;
import java.util.Stack;

// what if we want to check duplicates inside sub expression??
// while popping until opening bracket found, we will count the number of operators(+,-,*,/).
// if the number of operators is 0, then we can say that it has duplicates inside the sub expression.
// i.e.((a)+b)

class DuplicateBrackets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a balanced expression:");
        String str = sc.nextLine();

        if(isContainsDuplicateParenthesis(str)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static boolean isContainsDuplicateParenthesis(String str){

        Stack<Character> s = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ')'){
                //if it is closing bracket or operand or operator
                s.push(str.charAt(i));
            }else{
                //if it is closing bracket 
                //then check the top of stack if it i opening bracket it means that there where same contain for two pairs of brackets
                if(s.peek() == '('){
                    //it contains duplicate brackets
                    return true;
                }else{
                    //pop until opening bracket is found
                    while(s.peek() != '('){
                        s.pop();
                    }

                    //pop opening bracket
                    s.pop();
                }
            }
            
        }
        return false;
    }
}