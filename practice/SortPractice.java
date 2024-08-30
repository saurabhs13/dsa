
import java.util.Random;

public class SortPractice{
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minElementIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minElementIndex]>arr[j]){
                    minElementIndex = j;
                }
            }
            if(i!=minElementIndex)
                swap(arr,i,minElementIndex);
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean noSwapFlag = true;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    noSwapFlag = false;
                    swap(arr,j,j+1);
                }
            }
            if(noSwapFlag)
                break;
        }
    }
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int position = i;
            int value = arr[i];
           while(position>0 && arr[position-1]>value){
                arr[position] = arr[position-1];
                position--;
           }
           arr[position] = value;
        }
    }
    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex<endIndex){
        int partitionIndex = partition(arr,startIndex,endIndex);
        quickSort(arr, startIndex, partitionIndex-1);
        quickSort(arr, partitionIndex+1, endIndex);
        }
    }
    private static int partition(int[] arr,int startIndex,int endIndex){
        int pivot = arr[endIndex];
        int partition = startIndex;
        for(int i=startIndex;i<=endIndex;i++){
            if(arr[i]<pivot){
                swap(arr,partition,i);
                partition++;
            }
        }
        swap(arr,endIndex,partition);
        return partition;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int[] generateRandomArray(int length){
        int[] arr = new int[length];
        Random random = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(0, length);
        }
        return arr;
    }
    static void printArray(int[] arr){
        System.out.println("\n");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args){
        int[] arr_1 = generateRandomArray(10);
        printArray(arr_1);
        selectionSort(arr_1);
        printArray(arr_1);
        int[] arr_2 = generateRandomArray(10);
        printArray(arr_2);
        bubbleSort(arr_2);
        printArray(arr_2);
        int[] arr_3 = new int[]{8,2,6,1,7,9};
        printArray(arr_3);
        insertionSort(arr_3);
        printArray(arr_3);
        int[] arr_4 = new int[]{8,2,6,1,7,9};
        printArray(arr_4);
        quickSort(arr_4,0,arr_4.length-1);
        printArray(arr_4);
    }
}