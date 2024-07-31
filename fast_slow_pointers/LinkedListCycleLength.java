/*
 * Program to find the length of cycle in a linked list.
 * Time Complexity: O(n+m) where m is length of cycle.
 * Space Complexity: O(1)
 */
public class LinkedListCycleLength{

    static class Node{
        int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static int calculateCycleLength(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return calculateLength(slow);
            }
        }
      return -1;
    }
    private static int calculateLength(Node slow){
        Node current = slow;
        int length = 0;
        do { 
            current  = current.next;
            length++;
        } while (current != slow);
        return length;
    }
    public static void main(String[] args){
         Node temp = null;
         Node head = new Node(5);
         head.next = new Node(10);
         Node current = head.next;
         for(int i=11;i<=10000;i++){
            current.next = new Node(i);
            if(i==5000){
                temp = current;
            }
            current = current.next;
         }
         current.next = temp;
         System.err.println(calculateCycleLength(head));
    }
}