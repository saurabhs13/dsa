
public class SelectionSort{

    public static void sortArray(int[] arr){
      int minElementIndex;
      for(int i=0;i<arr.length;i++){
        minElementIndex = i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[minElementIndex]>arr[j]){
               minElementIndex = j;
            }
        }
        swap(arr,minElementIndex,i);
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