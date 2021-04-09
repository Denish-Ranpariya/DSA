//bfs


class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //list to store visited nodes
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        //array to keep track of visited nodes
        boolean visited[] = new boolean[V];
        
        //add 0th node to queue
        q.add(0);
        visited[0] = true; //mark it as visited
        result.add(0);//add it to result list
        
        //while queue is not empty
        while(!q.isEmpty()){

            //remove element from the queue
            int current = q.remove();
            
            //check for all the neighbours, if it is not visited then add it to queue
            for(int i = 0; i < adj.get(current).size(); i++){

                //if node is not visited
                if(visited[adj.get(current).get(i)] == false){
                    
                    //add it to queue
                    q.add(adj.get(current).get(i));
                    
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