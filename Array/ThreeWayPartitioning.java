import java.util.*;


//three way partition method
//here given range [a,b]
//we have to keep elements less than a to the left side 
//between a and b in between
//greater than b at end


class ThreeWayPartitioning{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of elements:");
		int n = sc.nextInt();

		int[] arr = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the element:");
			arr[i] = sc.nextInt();
		}	

		System.out.println("Enter the value of a:");
		int a = sc.nextInt();

		System.out.println("Enter the value of b:");
		int b = sc.nextInt();



		// int start = 0; // less than a
		// int current = 0; // between a and b
		// int end = n - 1; // greater than b

		// while(current <= end){

		// 	if(arr[current]  < a){

		// 		//swap start and current
		// 		int temp = arr[start];
		// 		arr[start] = arr[current];
		// 		arr[current] = temp;

		// 		start++;
		// 		current++;
		// 	}else if(arr[current] > b){

		// 		//swap current with end
		// 		int temp = arr[end];
		// 		arr[end] = arr[current];
		// 		arr[current] = temp;

		// 		end--;
		// 		current++;
		// 	}else{
		// 		current++;
		// 	}

			
		// }
		int start = 0; // for 0s
		int current = 0; // for 1s
		int end = n - 1;// for 2s

		while(current <= end){
			if(arr[current] < a){
				//swap the current with start
				int temp = arr[start]; 
				arr[start] = arr[current];
				arr[current] = temp;
				current++;
				start++;
			}else if(arr[current] > b){
				//swap the current with end;
				int temp = arr[end]; 
				arr[end] = arr[current];
				arr[current] = temp;
				end--;
			}else{
				current++;
			}
		}

		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}


	}
}