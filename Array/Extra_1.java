import java.util.Scanner;
class Extra_1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the " + (i + 1) + ":");
			arr[i] = sc.nextInt();
		}

		//program to count the frequency of numbers in array

		boolean[] status = new boolean[arr.length]; // for the status of visited or not
		for(int i = 0; i < arr.length; i++){

			if(status[i]){
				continue; // if element is already visited then skip 
			}

			int count = 1; //default will be one and we will increment it if occurs again 
			for(int j = i + 1; j < arr.length; j++){ 
				if( arr[j] == arr[i] ){
					status[j] = true; //this node is visited 
					count++;  
				} 
			}

			System.out.println("Occurence of " + arr[i] + " is: " + count);
		}
		
		
	}
}