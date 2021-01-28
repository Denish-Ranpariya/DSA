class ArrayRotation{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int d = 4;
		
		// using temp array
		//int temp[] = new int[d];
		// for(int i = 0; i < d; i++){
		// 	temp[i] = arr[i];
		// }
		// for(int i = 0; i < arr.length - 2; i++){
		// 	arr[i] = arr[i+d];
		// }
		// for(int i = 0; i < d; i++){
		// 	arr[arr.length + i - d] = temp[i];
		// }


		//using one rotation per time
		// for(int i = 0; i < d; i++){
		// 	int temp = arr[0];
		// 	for(int j = 0; j < arr.length - 1; j++){
		// 		arr[j] = arr[j+1];
		// 	}
		// 	arr[arr.length - 1] = temp;
		// }

		//with o(n) complexity
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			arr1[i] = arr[(arr.length - d + i + 1) % arr.length]; // most imp formula
		}

		for(int i = 0; i < arr.length; i++){
			System.out.println(arr1[i]);
		}
	}
}