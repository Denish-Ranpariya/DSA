import java.util.Scanner;
class Array1_2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the number you want to find:");
		int m = sc.nextInt();

		//linear search
		boolean flag = false ;
		int i = 0;
		for(i = 0;i < n;i++){
			if(arr[i] == m){
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Element found at position: " + i);
		}else{
			System.out.println("Element not found.");
		}
	}
}