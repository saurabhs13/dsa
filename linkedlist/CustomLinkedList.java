public class CustomLinkedList<T>{
    class Node<T>{
        T data;
        Node next;
    }
    Node<T> head;
    public void insert(T data){
        Node<T> node = new Node();
        node.data = data;
        if(null == head){
            head = node;
        }else{
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = node;
        }
    }
    public void remove(T data){
        if(null == head){
            System.out.println("Linked list is empty");
        }else{
            Node current = head;
            Node prev  = null;
            while(current !=null){
                if(current.data == data){
                    if(prev !=null){
                        prev.next = current.next;
                    }
                    current.next = null;
                    break;
                }
                prev = current;
                current = current.next;
            }
        }
    }
    public void find(T data){
        Node current = head;
        while(current !=null){
            if(current.data == data){
                System.out.println("Found!!");
            }
          current = current.next;
        }
    }
    public void reverse(){
        Node current = this.head;
        Node prev = null;
        Node next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }
    public void print(){
        Node temp = this.head;
        while(temp.next !=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
            System.out.println(temp.data);
    }
    public void printReverseRecursion(Node current){
        if(null == current)
            return;
        printReverseRecursion(current.next);
        System.out.print(current.data+ " ");
    } 
    public void printForwardRecursion(Node current){
        if(null == current)
            return;
        System.out.print(current.data+ " ");
        printForwardRecursion(current.next);
    } 
    public Node reverseRecursion(Node current,Node prev,Node next){
        if(null == current){
            return prev;
        }
        next = current.next;
        current.next = prev;
        prev = current;
        return reverseRecursion(next,prev,next);
    }
    public static void main(String[] args){

        CustomLinkedList<Integer> linkedList  = new CustomLinkedList<Integer>();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
     //   linkedList.remove(20);
      //  linkedList.find(30);
       // linkedList.reverse();
       // linkedList.print();
        linkedList.printReverseRecursion(linkedList.head);
        System.out.println(" ");
        linkedList.printForwardRecursion(linkedList.head);
        linkedList.head = linkedList.reverseRecursion(linkedList.head,null,null);
        linkedList.print();
    }
}