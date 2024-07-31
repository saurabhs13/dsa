/**
 * Detect cycle in a linked list using Floyd's Cycle Detection Algorithm.
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LinkedListCycle{

    static class Node{
        int value;
        Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
         Node head = new Node(5);
         head.next = new Node(10);
         Node current = head.next;
         for(int i=11;i<=10000;i++){
            current.next = new Node(i);
            current = current.next;
         }
         current.next = head;
         System.err.println(hasCycle(head));
    }
}