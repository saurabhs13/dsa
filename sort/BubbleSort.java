/**
 * Program to demonstrate bubble sort algorithm.
 * In bubble sort every element is compared with its adjacent element and if the elemment at i+1 position is 
 * greater than element at i position then swap the elements.In this way after 1st pass the largest element will move
 * to the last position in the array.
 * Time Complexity: O(n^2) for worst case.Best case can be improved to O(1) by adding a flag logic.
 */
public class BubbleSort{

    private static void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int flag = 0;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag =1;
                }
            }
            if(flag==0)
                break;
        }
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args){

        int[] arr = {3,11,5565,55,3532,5,8,1,4,0,33,898,76};
        sort(arr);
        printArray(arr);
        
    }
}