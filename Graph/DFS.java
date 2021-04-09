//dfs 
//recursive approach
//adjacency list representation 

class Solution
{
    static ArrayList<Integer> result;
    static boolean[] visited;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //to store visited nodes
        result  = new ArrayList<>();

        //to keep track of visited nodes
        visited = new boolean[V];
        
        //start with 0th node
        dfs(0, adj);

        //return result list
        return result;
    }
    
    //recursive function for dfs
    public static void dfs(int current, ArrayList<ArrayList<Integer>> adj){

        //mark current node as visited
        visited[current] = true;

        //add it to result
        result.add(current);
        
        //check for all it's neighbour 
        //if it is not visited then call the recursive function for it
        for(int i = 0; i < adj.get(current).size(); i++){
            if(visited[adj.get(current).get(i)] == false){
                dfs(adj.get(current).get(i), adj);
            }
        } 
    }
}

//iterative approach
class Solution
{
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //stack 
        Stack<Integer> s = new Stack<>();

        //list to store visited nodes
        ArrayList<Integer> result = new ArrayList<>();

        //array to keep track of visited
        boolean[] visited = new boolean[V];
        
        s.push(0); //push 0th node to the stack
        visited[0] = true; //mark it as visited
        result.add(0); //add it to result list
        

        //while stack is not empty
        while(!s.isEmpty()){
            
            //pop an element
            int current = s.pop();
            
            //check all the neighbour of current node and add it to stack not visited
            for(int i = 0; i < adj.get(current).size(); i++){

                //if node is not visited
                if(visited[adj.get(current).get(i)] == false){
                    
                    //push it ot the stack
                    s.push(adj.get(current).get(i));

                    //mark it as visited
                    visited[adj.get(current).get(i)] = true;
                    
                    //add it to result list
                    result.add(adj.get(current).get(i));
                }
            }
        }
        return result;
    }
}