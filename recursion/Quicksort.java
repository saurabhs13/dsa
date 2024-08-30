public class Quicksort{

     static void swap(int[] arr, int i, int j)
     {
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
 
    public static int partition(int[] arr,int low, int high){
        int pivot = arr[high];
        int currentIndex = low-1;
        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                currentIndex++;
                if(currentIndex != i)
                    swap(arr,i,currentIndex);
            }
        }
        swap(arr,currentIndex+1,high);
        return currentIndex+1;
    }
    public static void sort(int[] arr,int low,int high){
        if(low < high){

            int pi = partition(arr,low,high);

            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }    
      
    }
     // To print sorted array
     public static void printArr(int[] arr)
     {
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
     }

     public static void main(String[] args){
        int[] arr = {1,2,3,4,5,2,22,45,1,46,8,11,3};
        sort(arr,0,arr.length-1);
        printArr(arr);
     }
}