class ImplementStack{
    int maxSize;
    int[] stack;
    int top;

    ImplementStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public void push(int data){
        if(top == maxSize - 1){
            System.out.println("Stack Overflow");
            return;
        }else{
            top++;
            stack[top] = data;
        }
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack underflow");
            return -1;
        }else{
            int temp = stack[top];
            top--;
            return temp;
        }
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(top == maxSize - 1){
            return true;
        }else{
            return false;
        }
    }

    public void printStack(){
        if(isEmpty()){
            return;
        }
        for(int i = top; top >= 0; i--){
            System.out.println(pop());
        }
    }

    public static void main(String[] args) {
        ImplementStack s = new ImplementStack(10);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.isEmpty());
    }
}