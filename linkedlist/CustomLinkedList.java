
/**
 * Simple linkedlist implementation in java. 
 *
 **/
public class CustomLinkedList<T>{
    Node head;
    int size;
    public static class Node<T>{
        public T data;
        public Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public Node<T> getHead(){
        return this.head;
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
        size++;
    }
    public void remove(T data){
        if(isEmpty())
            return;
        if(head.data ==data){
            head = head.next;
            size--;
            return;
        }
        Node current = head,prev = null;
        while(current!=null){
            if(current.data==data){
                if(prev!=null){
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }

    }
    public boolean isEmpty(){
        return null==head;
    }
    public int size(){
       return size;
    }
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        for(int i=0;i<25;i++){
            list.add(i);
        }
        list.remove(23);
        CustomLinkedList.Node current = list.getHead();
        while(current!=null){
            System.out.print(current.data);
            current = current.next;
        }
    }

}