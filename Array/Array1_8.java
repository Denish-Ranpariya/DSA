import java.util.Scanner;
class Array1_8{
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

		//DUTCH national flag algo. or 3-way partitioning

		int start = 0; // for 0s
		int current = 0; // for 1s
		int end = arr.length - 1;// for 2s

		while(current <= end){
			if(arr[current] == 1){
				//already at correct index
				current++;
			}else if(arr[current] == 0){
				//swap the current with start
				int temp = arr[start]; 
				arr[start] = arr[current];
				arr[current] = temp;
				current++;
				start++;
			}else{
				//swap the current with end;
				int temp = arr[end]; 
				arr[end] = arr[current];
				arr[current] = temp;
				current++;
				end--;
			}
		}

		for( int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		
	}
}