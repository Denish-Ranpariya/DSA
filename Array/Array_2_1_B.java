//program to find the intersection of two sorted list
import java.util.Scanner;

class Array_2_1_B{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the lenght of first list:");
		int n = sc.nextInt();
		int arr1[] = new int[n];

		System.out.println(":::Please enter the array in sorted manner:::");

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr1[i] = sc.nextInt();
		}

		System.out.println("Enter the lenght of second list:");
		int m = sc.nextInt();
		int arr2[] = new int[m];

		System.out.println(":::Please enter the array in sorted manner:::");

		for(int i = 0; i < m; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr2[i] = sc.nextInt();
		}


		int i = 0; // pointer for first array
		int j = 0; // pointer for second array

		while( i != n && j != m){
			if(arr1[i] == arr2[j]){ //both are same 
				System.out.println(arr1[i]);
				i++;
				j++;
			}else if(arr1[i] < arr2[j]){  
				i++;
			}else{
				j++;
			}
		}
	}
}