public class StackArrayImpl{
    int[] arr;
    int top = -1;
    public StackArrayImpl(){
        this.arr = new int[100]; 
    }
    public StackArrayImpl(int capacity){
        this.arr = new int[capacity]; 
    }
    public void push(int element){
        if(top >= this.arr.length-1){

            int[] newarr = new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                newarr[i] = arr[i];
            }
            this.arr = newarr;
        }
        this.top++;
        this.arr[top] = element;
    }
    public int pop(){
        if(top != -1)
            return this.arr[this.top--];
        return -1;      
    }
    public int top(){
        if(top!=-1)
            return this.arr[this.top];
        return -1;
    }
    public static void main(String[] args){

        StackArrayImpl stack = new StackArrayImpl();
        for(int i=0;i<=102;i++){
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }

}