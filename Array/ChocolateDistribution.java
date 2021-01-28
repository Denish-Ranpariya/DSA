import java.util.*;


//chocolate distribution problem
//we have to use sliding window as we have to minimize the difference between max and min
//to use sliding window we have to sort the array
//time complexity will be O(nlogn)
class ChocolateDistribution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array:");
		int n = sc.nextInt();

		int[] a = new int[n];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the element:");
			a[i] = sc.nextInt();
		}

		System.out.println("Enter the number of student:");
		int numberOfStudent = sc.nextInt();

		Arrays.sort(a);

		int minDifference = Integer.MAX_VALUE;

		for(int i = 0; i < n - numberOfStudent + 1; i++){
			if(a[i + numberOfStudent - 1] - a[i] < minDifference){
				minDifference = a[i + numberOfStudent - 1] - a[i];
			}
		}

		System.out.println("Min difference: " + minDifference);
	}
}