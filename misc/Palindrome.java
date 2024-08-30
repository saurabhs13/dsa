class Palindrome {
    
 
 public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
    public static boolean  isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode reverseHead = null;
        ListNode prev = null;
        boolean palindrome = true;
        int listSize = 0;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            listSize = listSize+2;
        }
        if(fastPointer!=null && fastPointer.next==null){
            liseSize = listSize +1;
        }
        while(current!=null){
            
            current = current.next;
        }
        while(current!=null){
            reverseHead = new ListNode(current.val);
            reverseHead.next = prev;
            current = current.next;
            prev = reverseHead;
        }
        ListNode reverseCurrent = reverseHead;
        current  = head;
        while(current !=null){
            System.out.println("Current Val = "+current.val);
            System.out.println("Reverse Current Val = "+reverseCurrent.val);
            if(current.val !=reverseCurrent.val){
                palindrome = false;
                break;
            }
            current = current.next;
            reverseCurrent = reverseCurrent.next;
        }
        return palindrome;
    }

    public static void main(String args[]){
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode();
        head.next.val = 1;
        head.next.next = new ListNode();
        head.next.next.val = 2;
        head.next.next.next = new ListNode();
        head.next.next.next.val = 1;
        System.out.println(isPalindrome(head));
    }
}