import java.util.Scanner;
class Array1_6{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the value of k:"); // for kth smallest and kth largest element
		int k = sc.nextInt();

		//bubble sort
		for( int i = 0; i < arr.length - 1 ; i++){
			for( int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("Kth smallest element:" + arr[k-1]);
		System.out.println("Kth largest element:" + arr[arr.length-k]);
		
	}
}