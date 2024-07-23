/**
 * Program to remove duplicates in place using 2 pointer and return length of final array.
 * nextNonDuplicate represents the next slot where non-duplicate needs to be filled.
 * 
 */
public class RemoveDuplicates{
    public static int removeDuplicates(int[] arr){
        int nextNonDuplicate = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[nextNonDuplicate-1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
    public static void main(String[] args){
        int[] arr = new int[]{2,3,3,4,5,6,6,7,8,9,9,9,9,9,10};
        System.out.println(removeDuplicates(arr));
    }
}