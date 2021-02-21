class Solution
{
    static List<Integer> person = new ArrayList<Integer>();
    static int answer = -1;
    public int josephus(int n, int k){
        
        //reset global static variables
        person.clear();
        answer = -1;
        
        //Your code here
        for(int i = 1; i <= n; i++){
            person.add(i);
        }
        
        //k - 1 : because we have to count the current person also
        //passing 0 as swordIndex because person at index 0 has sword
        killThePerson(n, k - 1, 0);
        
        return answer;
        
    }
    
    public static void killThePerson(int n, int k, int swordIndex){
        //if last person is left
        //base case
        if(person.size() == 1){
            answer = person.get(0);
            return;
        }
        
        //now calculate person at which index is to be killed 
        int personToBeRemovedAtindex = (swordIndex + k) % person.size();//because we have to maintain circular nature
        
        //kill the person at personToBeRemovedAtindex
        person.remove(personToBeRemovedAtindex);
        
        //call recursive function for n - 1 persons left
        //passing swordIndex = personToBeRemovedAtindex because we have removed perosn at personToBeRemovedAtindex
        //so person after personToBeRemovedAtindex will take place of it and he has sword now
        killThePerson(n - 1, k, personToBeRemovedAtindex); 
        
    }

}