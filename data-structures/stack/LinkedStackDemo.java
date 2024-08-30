class Node{
    int data;
    Node next;

    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}
class LinkedStack{
        
    Node head;

    /**
     * Methos to create and return a new node; 
     */
    Node createNode(int data){

        Node node = new Node(data,null);
        return node;
    }
    public void push(int data){
        Node current = createNode(data);
        if(isEmpty()){
            head = current;
        }else{
            current.next = head;
            head = current;
        }
    }  
    public int pop(){

        if(isEmpty()){
            System.out.println("Stack is empty !!");
            throw new RuntimeException("Empty Stack");
        }else{
            int data = head.data;
            head = head.next;
            return data;
        }
        
    } 

    public boolean isEmpty(){

        return (null==head);
    }

}

public class LinkedStackDemo{
   
    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        for(int i=0;i<100;i++){
            stack.push(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(stack.pop());
        }
    }
}