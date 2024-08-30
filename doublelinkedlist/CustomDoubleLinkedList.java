public class CustomDoubleLinkedList<T>{
    Node head;
    Node tail;
    class Node<T>{
        T data;
        Node prev;
        Node next;
    }
    public void insert(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        if(null == head){
            node.prev = null;
            node.next = null;
            this.head = node;
            this.tail = node;
        }else{
            if(this.tail!=null){
                this.tail.next = node;
                node.prev = this.tail;
                node.next = null;
                this.tail = node;
            }
        }
    }
    public void remove(T data){
        
        Node startPointer = head;
        Node endPointer = tail;
        while(startPointer != null && endPointer!=null){
          if(startPointer!=null && startPointer.data == data){
            if(startPointer.prev !=null)
                startPointer.prev.next = startPointer.next;
            if(startPointer.next !=null)
                startPointer.next.prev = startPointer.prev;
            break;
          }
          if(endPointer!=null && endPointer.data == data){
            if(endPointer.prev !=null)
                endPointer.prev.next = endPointer.next;
            if(endPointer.next !=null)
                endPointer.next.prev = endPointer.prev;
            break;
          }
          startPointer = startPointer.next;
          endPointer = endPointer.prev;
        }
    }
    public void print(){
        Node current = this.head;
        System.out.println("");
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public static void main(String[] args){
        CustomDoubleLinkedList<Integer> doubleLinkedList = new CustomDoubleLinkedList<Integer>();
        doubleLinkedList.insert(10);
        doubleLinkedList.insert(20);
        doubleLinkedList.insert(30);
        doubleLinkedList.insert(40);
        doubleLinkedList.print();
        doubleLinkedList.remove(20);
        doubleLinkedList.print();
    }
}