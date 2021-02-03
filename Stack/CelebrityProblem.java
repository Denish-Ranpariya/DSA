int celebrity(int a[][], int n){
    //first we have to add all the row or column numbers to stack
    Stack<Integer> s = new Stack<Integer>(); 
    
    for(int i = 0;i < a.length; i++){
        s.push(i);
    }
    
    while(s.size() >= 2){
        //pop 2 elememts
        int i = s.pop();
        int j = s.pop();
        
        if(a[i][j] == 1){
            //if i knows j then i is not celebrity
            s.push(j);
            //push it back
        }else{
            //if i doesnt know j then j is not celebrity
            s.push(i);
        }
    }
    
    //after loop only one will be in stack
    //it is potential candidate to become celebrity
    int pot = s.pop();
    
    //we have to check for its row and column
    //its row should be all 0
    //its column should be all 1 except a[pot][pot]
    
    for(int i = 0; i < a.length; i++){
        if(i != pot){
            if(a[pot][i] != 0 || a[i][pot] != 1){
                return -1;
            }
        }
    }
    
    return pot;
}