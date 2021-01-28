import java.util.Scanner;
class Array1_9{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}

		System.out.println("Max:" + max);
		System.out.println("Min:" + min);
		System.out.println("Range:" + (max - min));
	}
}