import java.util.Scanner;
class PrintNToOne{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        printNToOne(n);
    }

    public static void printNToOne(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printNToOne(n - 1);
    }
}