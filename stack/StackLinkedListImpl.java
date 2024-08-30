public class StackLinkedListImpl<T>{
    Node<T> head;

   class Node<T>{
        T data;
        Node next;
    }

    public void push(T data){
        Node<T> node = new Node<T>();
        node.data = data;
        node.next = head;
        head = node;
    }
    public T pop(){
        if(null == head){
            System.out.println("Stack is empty");
            return null;
        }else{
            Node<T> top = head;
            head = head.next;
            return top.data;
        }
    }
    public T top(){
        if(null == head){
            System.out.println("Stack is empty");
            return null;
        }else{
            return head.data;
        }
    }
    public boolean isEmpty(){
        if(null==this.top())
            return true;
        else    
            return false;
    }
    public static void main(String[] args){
        StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
        for(int i=0;i<=102;i++){
            stack.push(i);
        }
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}