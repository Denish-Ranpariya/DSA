import java.util.Scanner;
class Array1_10{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];

		System.out.println(":::ARRAY SHOULD ONLY CONTAIN 0/1/2:::");
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		//place negative numbers to left side of array
		//if we place negative numbers on the left side then positive numbers will automatically placed at right side
		//like dutch flag algorithm 

		int start = 0; 
		int current = 0; 
		int end = arr.length - 1;

		while(current <= end){
			if(arr[current] < 0){
				//swap the current with start
				int temp = arr[start]; 
				arr[start] = arr[current];
				arr[current] = temp;
				start++;
			}
			current++;
		}

		for( int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		
	}
}