import java.util.Scanner;
class PrintOneToN{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        printOneToN(n);
    }

    public static void printOneToN(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        printOneToN(n - 1);
        System.out.print(n + " ");
    }
}