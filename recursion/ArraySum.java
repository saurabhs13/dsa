public class ArraySum{

 public static long arraySum(int[] arr,int lastIndex){
        return lastIndex==0?arr[0]:arr[lastIndex]+arraySum(arr,lastIndex-1);
    }

public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(arraySum(arr,arr.length-1));
}
 
}