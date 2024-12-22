
/**
 * Simple linkedlist implementation in java. 
 *
 **/
public class CustomLinkedList<T>{
    Node head;
    class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public void add(T data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
        }else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = node;
        }
    }
    public void remove(T data){
        if(isEmpty())
            return;
        if(head.data ==data){
            head = head.next;
        }
        Node current = head,prev = null;
        while(current!=null){
            prev = current;
            current = current.next;
            if(current.data==data){
                prev.next = current.next;
                current = null;
            }
        }

    }

    public boolean isEmpty(){

        return null==head;
    }

}