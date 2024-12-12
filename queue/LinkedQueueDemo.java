class Node<E>{
    E data;
    Node<E> next;
}

/**
 * Linkedlist implementation of Queue.
 */
class CustomLinkedQueue<E>{

    Node<E> first,last;
    
    public CustomLinkedQueue(){
        first = last = null;
    }
    public boolean isEmpty(){
        return first==null&&last==null;
    }
    Node createNode(E data){
        Node<E> n = new Node();
        n.data = data;
        n.next = null;
        return n;
    }
    public void enqueue(E data){
        Node<E> n =  createNode(data);
        if(this.isEmpty()){
            first = last = n;
        }else{
            last.next = n;
            last = n;
        }
    }
    public void dequeue(){
        if(!isEmpty()){
            first = first.next;
            if(null == first)
                last = null;
        }
    }
    public E peek(){
        if(this.isEmpty()){
            return null;
        }
        return first.data;
    }
    public E peekLast(){
        if(this.isEmpty()){
            return null;
        }
        return last.data;
    }

}
public class LinkedQueueDemo{
    public static void main(String[] args) {
        CustomLinkedQueue<Integer> queue = new CustomLinkedQueue<>();
        for(int i=1;i<=100;i++){
            queue.enqueue(i);
            if(i%11==0){
                queue.dequeue();
            }
        }
        System.out.println("First element = "+queue.peek());
        System.out.println("Last element = "+queue.peekLast());

    }
}