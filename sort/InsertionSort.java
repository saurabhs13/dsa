public class InsertionSort{
    /**
     * Implementation 1
     */
    public static void sortArray(int[] arr){
        int sortedArrayBoundary;
         for(int i=1;i<=arr.length;i++){
             sortedArrayBoundary = i-1;
             while(sortedArrayBoundary>0 && arr[sortedArrayBoundary]<arr[sortedArrayBoundary-1]){
                 swap(arr,sortedArrayBoundary,sortedArrayBoundary-1);
                 sortedArrayBoundary--;
             }
        }    
     }
     /**
      * Implementation 2
      */
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
     public static void swap(int[] arr,int i, int j){
         int temp  = arr[i];
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
         int[] arr = new int[26];
         for(int i=0;i<=25;i++){
             arr[i] = (int)((Math.random()*100)+1);
         }
         sortArray(arr);
         printArray(arr);
     }
}
