import java.util.ArrayDeque;

/**
 * Program to reverse first k elements of a Queue.
 */
public class ReverseFirstKElements{

    public static  void reverseFirstKElement(ArrayDeque<Integer> queue,int k){
        if(null==queue){
            System.out.println("Queue is null");
            return;
        }
        int n = queue.size();
        if(k>n){
            System.out.println("k is greater than n. k = "+k+" n = "+n);
            return;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        for(int i=0;i<n-k;i++){
            queue.add(queue.poll());
        }
    }
    public static void printElements(ArrayDeque<Integer> queue){
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+ " ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        System.out.println("In main");
        ArrayDeque<Integer> queue = new ArrayDeque<>(50);
        for(int i=1;i<=50;i++){
            queue.add(i);
        }
       // printElements(queue);
        reverseFirstKElement(queue,10);
        printElements(queue);
    }
}