//program to print all pairs with given sum
import java.util.Scanner;
import java.util.Arrays;

class Array_2_4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the lenght of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the sum:");
		int sum = sc.nextInt();

		Arrays.sort(arr); // sorted array is required

		int low = 0; //pointer from staring
		int high = arr.length - 1;//pointer from ending

		while(low < high){

			if(arr[low] + arr[high] > sum){
				high--;		//decrement the high because the sum is larger 
			}else if(arr[low] + arr[high] < sum){
				low++;
			}else{
				System.out.println(arr[low] + "," + arr[high]);
				low++;
				high--;
			}
		}
		
	}
}