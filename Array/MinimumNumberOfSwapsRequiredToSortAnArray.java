// Given an array of n distinct elements. 
// Find the minimum number of swaps required to sort the array in strictly increasing order.

class Solution
{   
    //Pair class 
    public class Pair{
        int val;
        int index;
        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    
    public int minSwaps(int nums[])
    {
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        //create arraylist of pair with value and index
        for(int i = 0; i < nums.length; i++){
            pairs.add(new Pair(nums[i], i));   
        }
        
        //sort arraylist according to value
        Collections.sort(pairs, (a,b) -> a.val - b.val);
        
        //count
        int count = 0;
        
        //try convert sorted arraylist in given array
        for(int i = 0; i < nums.length; i++){

            //if index of element at index i in pairs list is not equal to i
            //then swap it and increase count
            //i-- because after swapping it may be possible that element at index i is not at corrent position 
            if(i != pairs.get(i).index){
                count++;
                
                Collections.swap(pairs, i, pairs.get(i).index);
                
                i--;
            }
        }
        
        return count;
    }
}