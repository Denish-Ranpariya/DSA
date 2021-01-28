// program to find minimum element in rotated sorted array

//if the problem is of serching in sorted array then it is always binary search
//we will use binary search for this program
//the only difference is we have to find the unsorted part
//for example 4,5,6,0,1,2
//we have to find the part 6,0

//we will not consider sorted part in every iteration
import java.util.*;

class Array_2_17{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}

		int left = 0; //start
		int right = n - 1; //end

		int result = -1;

		if(n == 0){
			System.out.println("Answer: " + result);
			return;
		}

		if(n == 1){
			System.out.println("Answer: " + arr[0]);
			return;
		}

		if( arr[left] < arr[right] ){
			System.out.println("Answer: " + arr[0]);
			return;
		}

		while(left < right){
			int mid = left + (right - left)/2;//smarter way to do it //always use this
			

			if(arr[mid] < arr[mid - 1] && mid > 0){ //to find the glitch mentioned above
				result = arr[mid];
				break;
			}else if(arr[left] < arr[mid]){ //left part is sorted so neglect it
				left = mid + 1;
			}else{ //right part is sorted so neglect it
				right = mid - 1;
			}	
		}
		
		System.out.println("Answer: " + result);
		
	}
}