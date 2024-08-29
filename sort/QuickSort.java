public class QuickSort{

    public static void sortArray(int[] arr,int startIndex,int endIndex){
        if(startIndex<endIndex){
        int partitionIndex = partition(arr,startIndex,endIndex);
        sortArray(arr, startIndex, partitionIndex-1);
        sortArray(arr, partitionIndex+1, endIndex);
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
    public static  void printArray(int[] arr){
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args){
        int[] arr = new int[25];
        for(int i=0;i<=24;i++){
            arr[i] = (int)((Math.random()*100)+1);
        }
        sortArray(arr,0,arr.length-1);
        printArray(arr);
    }

}