import java.util.*;
import java.util.Stack;

class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class MergableList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pairs.");
        int n = sc.nextInt();

        Interval intervals[] = new Interval[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter the start for " + (i + 1) + ":");
            int start = sc.nextInt();
            System.out.println("Enter the end for " + (i + 1) + ":");
            int end = sc.nextInt();
            intervals[i] = new Interval(start, end);
        }

        //create stack of type interval
        Stack<Interval> s = new Stack<Interval>();

        //sort the array of intervals according to the starting point
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if(a.start > b.start){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        

        for(int i = 0; i < n; i++){
            //if stack is empty then push interval to the stack
            if(s.isEmpty()){
                s.push(intervals[i]);
            }else{
                //check if current interval's starting is less than top intervals ending
                //if it is then merge both intervals by setting top's ending to the max of top's ending and current's ending
                Interval top = s.peek();
                if(intervals[i].start <= top.end){
                    top.end = Math.max(top.end,intervals[i].end);
                }else{
                    //otherwise simply push to the stack
                    s.push(intervals[i]);
                }
            }
        }

        //now we have result in stack but it is in reverse order 
        //so we will take another stack and push all elements of stack to the another stack 
        //then pop all the elements from another stack and print it
        Stack<Interval> rs = new Stack<Interval>();

        while(!s.isEmpty()){
            rs.push(s.pop());
        }

        while(!rs.isEmpty()){
            Interval poppedInterval = rs.pop();
            System.out.println(poppedInterval.start + " " + poppedInterval.end);
        }
    }
}

