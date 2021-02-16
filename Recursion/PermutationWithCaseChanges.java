import java.util.*;

//input - ab
//output
//ab
//Ab
//aB
//AB

//here we have considered that the input is always in lowercases

//input-output method

class PermutationWithCaseChanges{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");

        //initialize input with given string and output with empty string
        String input = sc.nextLine();
        String output = "";
        solve(input, output);
    }

    public static void solve(String input, String output){

        //base case
        //leaf node
        //when input is empty then print output
        if(input.equals("")){
            System.out.println(output);
            return;
        }

        //remove first character from input string
        char ch = input.charAt(0);
        input = input.substring(1);

        //initialize both outputs with output
        String output1 = output;
        String output2 = output;

        //add removed character as it is
        output1 += Character.toString(ch);

        //add removed character after converting it to uppercase
        output2 += Character.toString(Character.toUpperCase(ch));

        //call recursive function for both outputs
        solve(input,output1);
        solve(input,output2);
    }
}