//implement double stack 
class Stacks
{
    // sq is the object of class TwoStack

    /* The method push to push element into the stack 2 */
    void push1(int x, TwoStack sq)
    {
        if(sq.top1 + 1 == sq.top2){
            System.out.println("Stack Overflow.");
            System.exit(0);
        }else{
            sq.top1++;
            sq.arr[sq.top1] = x;
        }
    }

    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
        if(sq.top1 + 1 == sq.top2){
            System.out.println("Stack Overflow.");
            System.exit(0);
        }else{
            sq.top2--;
            sq.arr[sq.top2] = x;
        }
    }

    /* The method pop to pop element from the stack 1 */
    //Return the popped element
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1){
            return -1;
        }
        return sq.arr[sq.top1--];
    }

    /* The method pop to pop element from the stack 2 */
    //Return the popper element
    int pop2(TwoStack sq)
    {
        if(sq.top2 == sq.size){
            return -1;
        }
        return sq.arr[sq.top2++];
    }
}