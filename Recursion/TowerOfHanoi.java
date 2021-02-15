import java.util.Scanner;

class TowerOfHanoi{
    public static void main(String[] args) {
        String source = "source";
        String destination = "destination";
        String helper = "helper";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of disks:");
        int n = sc.nextInt();
        towerOfHanoi(n,source,destination,helper);
    }

    public static void towerOfHanoi(int n, String source,String destination,String helper){

        //base case
        if(n == 1){
            System.out.println(source + " to " + destination);
            return;
        }

        //move n - 1 disks to helper
        //source will be source
        //destination will be helper
        //helper will be destination
        towerOfHanoi(n - 1, source, helper, destination);

        //move largest disk to destination
        System.out.println(source + " to " + destination);

        //move those n - 1 disks from helper to destination
        //source will be helper
        //destination will be destination
        //helper will be source
        towerOfHanoi(n-1, helper,destination, source);
    }
}