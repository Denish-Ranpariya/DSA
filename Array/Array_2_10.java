
//program to find the three largest elements form an array which contains all distinct element
// here the requirement is the time complexity should be O(n) and space complexity should be O(1)
import java.util.*;

class Array_2_10{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int n = sc.nextInt();
		int arr[] = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the number at " + (i+1) + ":");
			arr[i] = sc.nextInt();
		}

		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdLargest  = Integer.MIN_VALUE;

		for(int i = 0;i < n; i++){
			if(arr[i] > firstLargest){ //element is larger than first largest element
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = arr[i];
			}else if(arr[i] > secondLargest){// element is larger than second largest element
				thirdLargest = secondLargest;
				secondLargest = arr[i];
			}else if(arr[i] > thirdLargest){// element is larger than third largest element 
				thirdLargest = arr[i];
			}
		}

		System.out.println(firstLargest);
		System.out.println(secondLargest);
		System.out.println(thirdLargest);
		
		// we can also do it by sorting but it will take O(nlogn) complexity
	}
}