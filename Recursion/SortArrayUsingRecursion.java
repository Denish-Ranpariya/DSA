//not a working code
import java.util.*;

class SortArrayUsingRecursion{

    ArrayList<Integer> a = new ArrayList<Integer>();


    public static void main(String[] args) {

        SortArrayUsingRecursion s = new SortArrayUsingRecursion();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter the number:");
            s.a.add(sc.nextInt());
        }
        System.out.println(s.a);
        s.sortArray();
        System.out.println(s.a);

    }

    public void sortArray(){

        //base condition
        //if size is 1 then already sorted
        if(a.size() == 1){
            return;
        }

        //remove last element from array and sort remaining array
        int lastElement = a.get(a.size() - 1);

        a.remove(a.size() - 1);

        sortArray();

        //add removed element at its true position
        //for this we will use another recursive function 
        insertElement(lastElement);
    }

    public void insertElement(int lastElement){
        
        //base condition
        //if size is zero then simply add it to the array
        //or if element to be inserted is larger or equal than last element of array then add it to the last
        if(a.size() == 0 || lastElement >= a.get(a.size() - 1)){
            a.add(lastElement);
            return;
        }

        //remove last element from array and insert given element 
        int removedElement = a.get(a.size() - 1);
        a.remove(a.size() - 1);
        insertElement(lastElement);

        //insert removed element again at last
        a.add(removedElement);
    }
}