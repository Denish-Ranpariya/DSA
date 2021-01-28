//leet code 121

//m-1 brute force 
//O(n^2)
//m-2 simple

class BuyAndSellStock{
	public static void main(String[] args) {
		int a[] = {1,4,2};
		int result = maxProfit(a);
		System.out.println(result);
	}

	public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
        
    }
}