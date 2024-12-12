
import java.util.ArrayDeque;

/**
 * Program to replace every element with the next greater element in an array.
 */
public class NextGreaterElement{
    public static void nextGreaterElement(int[] arr){
        if(null == arr || arr.length==0){
            System.out.println("Null or empty array passed to the method");
            return;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>(arr.length);
        int temp;
        for(int i=arr.length-1;i>=0;i--){
            temp = -1;
            while(!stack.isEmpty()&&stack.peek()<=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                temp = stack.peek();
            }
            stack.push(arr[i]);
            arr[i] = temp;
        }
    }
    public static void printArray(int[] arr){
        System.out.println("");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,5,2,13,15,9,2,16};
        printArray(arr);
        nextGreaterElement(arr);
        printArray(arr);
    }
}