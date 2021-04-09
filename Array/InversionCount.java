//count number of inversions
//if a[i] > a[j] when i < j

//M-1
//bruteforce
//O(n^2)

//method-2
//mergesort
//same as merge sort
//but we have to keep in mind that we have to increment count when the a1[i] is greater than a2[j] in merge function
//we have to add some code in merge function 



class InversionCount{ 
	
	public static void main(String args[]) 	
	{ 
		int a[]= {1, 20, 6, 7, 5, 8, 11, 3};

		int inversionCount = mergesort(a,0,a.length-1);

		// for(int i=a.length-1;i>=0;i--){
		// 	System.out.println(a[i]);
		// } 

		System.out.println("Number of inversion : " + inversionCount);
	} 

	static int merge(int a[],int p,int q,int r){
		int i=0,j=0,k=p; 
		int n1=q-p+1; 
		int n2=r-q; 
		int left[]=new int[n1]; 
		int right[]=new int[n2]; 

		int swaps = 0; //number of inversion count

		for(i=0;i<n1;i++){
			left[i]=a[p+i]; 
		} 
			
		for(j=0;j<n2;j++) {
			right[j]=a[q+1+j]; 
		}
		i=0;j=0;
		while(i<n1 && j<n2){ 
			if (left[i]<=right[j]){ 
				a[k]=left[i]; 
				i++; 
			} 
			else{ 
				a[k]=right[j]; 
				j++; 

				//here we have to add some code

				swaps =+ (q - i + 1);
			} 
			k++; 
		} 

		while(i<n1){ 
			a[k]=left[i]; 
			i++; 
			k++; 
		} 

		while (j<n2){ 
			a[k]=right[j]; 
			j++; 
			k++; 
		} 

		return swaps;
	} 

	static int mergesort(int a[],int p,int r){ 
		int count = 0;
		if (p<r){
			int q=(p+r)/2; 
			
			count += mergesort(a,p,q); 
			count += mergesort(a,q+1,r); 
			count += merge(a,p,q,r); 
		} 
		return count;
	} 
} 

