import java.util.Scanner;
class Array1_5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}


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

		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}