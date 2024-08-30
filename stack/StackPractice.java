public class StackPractice<T>{

    Element<T> head;

    class Element<T>{
        T data;
        Element<T> next;
    }
    /**
     * Push method has O(1) time complexity.
     */
    public void push(T element){
        Element<T> e = new Element<T>();
        e.data = element;
        
        if(head == null){
            head = e;
        }
    }

    /*
     * Pop has a complexity of O(n).
     */
    public T pop(){
        Element<T> tail = head;
        Element<T> secondLast = tail;
        T data;
        while(tail.next != null){
            secondLast = tail;
            tail = tail.next;
        }
        data = tail.data;
        secondLast.next = null;
        return data;
    }

    public static void main(String[] args){
        StackPractice<String> stackPractice = new StackPractice<>();
        stackPractice.push("Sam");
        stackPractice.push("Roger");
        stackPractice.push("John");
        System.out.println(stackPractice.pop());
        System.out.println(stackPractice.pop());
    }

}