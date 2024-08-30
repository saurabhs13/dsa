public class QuickSort2{

    public static void swap(int[] arr,int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr,int low,int high){

        if(low<high){
            int pivot = arr[high];
            int pi = low;
            
            for(int i=low;i<high;i++){
                if((arr[i]<=pivot)){
                    swap(arr,pi,i);
                    pi++;
                }
            }
            swap(arr,pi,high);
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }

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
        sort(arr,0,arr.length-1);
        printArray(arr);

    }
}