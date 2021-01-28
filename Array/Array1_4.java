import java.util.Scanner;
class Array1_4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		int start = 0;
		int end = arr.length - 1;

		//apply for both even number of elements and odd number of elements
		while(start < end){
			int temp = arr[start]; // swapping
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
			
		}
	}
}