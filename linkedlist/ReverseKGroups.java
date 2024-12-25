public class ReverseKGroups{

    public static CustomLinkedList.Node<Integer> reverseKGroups(CustomLinkedList.Node<Integer> head,int k){
        if (k <= 1 || head == null) 
            return head;

        CustomLinkedList.Node<Integer> dummy = new CustomLinkedList.Node<>(0);
        dummy.next = head;
        CustomLinkedList.Node<Integer> previousGroupEnd = dummy;
        CustomLinkedList.Node<Integer> current = head;

        while(current!=null){

            //Find the start and end node for given k
            CustomLinkedList.Node<Integer> startNode  = current;
            CustomLinkedList.Node<Integer> endNode = getKthNode(current, k);

            //Check if there were less than k nodes left and hence break
            if(endNode == null)
                break;

            //Update start of next group
            CustomLinkedList.Node<Integer> nextGroupStart = endNode.next;

            //Reverse current group based on start and end node
            reverseGroup(startNode,endNode);

            //Connect reversed group back to the list 
            startNode.next = nextGroupStart;
            previousGroupEnd.next = endNode;

            //Update previous group end and current for next iteration
            previousGroupEnd = startNode;
            current = nextGroupStart;
            
        }
        
        return dummy.next;
    }
    public static CustomLinkedList.Node getKthNode(CustomLinkedList.Node current,int k){
     
        while(current!=null && k>1){
            current = current.next;
            k--;
        }
        return current;
    }
    public static void reverseGroup(CustomLinkedList.Node start,CustomLinkedList.Node end){
        CustomLinkedList.Node current = start,prev = null,next;
        while(prev!=end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
    public static void main(String[] args){
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        int  k =3;
        for(int i=0;i<25;i++){
            list.add(i);
        }
        CustomLinkedList.Node<Integer> current = reverseKGroups(list.getHead(),k);
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
            k--;
            if(k==0){
                k = 3;
                System.out.println("");
            }
        }
    }
}