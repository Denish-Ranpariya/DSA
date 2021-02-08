// Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

// The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

// For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].


//just like next greater element 
//here next greater element on left side
//so we will go from left to right  and pop element until small element is found
import java.util.Scanner;
import java.util.Stack;

class StockSpanning{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter the element:");
            arr[i] = sc.nextInt();
        }

        int result[] = getSpan(arr);

        for(int i = 0; i < n; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static int[] getSpan(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(s.isEmpty()){
                s.push(i);
                result[i] = 1;
            }else{
                while(arr[s.peek()] <= arr[i] && !s.isEmpty()){
                    s.pop();
                }

                if(s.isEmpty()){
                    result[i] = i + 1;
                }else{
                    result[i] = i - s.peek();
                }
                s.push(i);
            }
        }
        return result;
    }
}