import java.util.*;

//problem to merge the intervals which are overlapping

class MergeIntervals{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of intervals:");
		int n = sc.nextInt();

		int[][] intervals = new int[n][2];

		for(int i = 0; i < n; i++){
			System.out.println("Enter the interval starting:");
			intervals[i][0] = sc.nextInt();
			System.out.println("Enter the interval ending:");
			intervals[i][1] = sc.nextInt();
		}

		List<int[]> outputIntervals = new ArrayList<int[]>();

		//if the list of intervals are already sorted than it will be easy 
		//but here lets consider the intervas are not sorted in ascending order
		//we will sort the intervals in the ascending order according to their starting values

		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] a,int[] b){
				return Integer.compare(a[0],b[0]);
			}
		});

		//now we have to check wether current interval starting is less than previous interval ending (i.e. overlapping)

		int temp[] = intervals[0];

		for(int i = 1; i < n; i++){
			if(temp[1] >= intervals[i][0]){ //merge if first ending is larger than or equal to second starting
				temp[1] = Math.max(temp[1], intervals[i][1]);
			}else{
				outputIntervals.add(temp); //add it to list 
				temp = intervals[i]; //update temp
			}
		}

		//add last time current
		outputIntervals.add(temp);

		// int[][] resultArray = outputIntervals.toArray(int[outputIntervals.size()][]);

		for(int i = 0; i < outputIntervals.size(); i++){
			int[] interval = outputIntervals.get(i);
			System.out.print(interval[0] + " ");
			System.out.print(interval[1]);
			System.out.println();
		}

	}
}