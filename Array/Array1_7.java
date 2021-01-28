import java.util.Scanner;
class Array1_7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the value of k:"); // for occurence of k 
		int k = sc.nextInt();

		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == k){
				count++;
			}
		}

		System.out.println("occurence:" + count);
		
	}
}