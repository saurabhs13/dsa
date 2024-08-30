public class MergeSort{

    public static void merge(int[] arr, int low,int mid,int high){
        int n1 = mid-low +1;
        int n2 = high -mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i=0;i<n1;i++){
            leftArr[i] = arr[low+i];
        }
        for(int j=0;j<n2;j++){
            rightArr[j] = arr[mid+1+j];
        }
        int leftIndex= 0;
        int rightIndex = 0;
        int k = low;
        while(leftIndex <n1 && rightIndex <n2){
            if(leftArr[leftIndex]<rightArr[rightIndex]){
                arr[k] = leftArr[leftIndex];
                leftIndex++;
            }else{
                arr[k] = rightArr[rightIndex];
                rightIndex++;
            }
            k++;
        }
        while(leftIndex<n1){
            arr[k] = leftArr[leftIndex];
            leftIndex++;
            k++;
        }
        while(rightIndex<n2){
            arr[k] = rightArr[rightIndex];
            rightIndex++;
            k++;
        }
    }
    public static void sortArray(int[] arr,int low, int high){
        
        if(low<high){

            int mid = (low+high)/2;
            sortArray(arr,low,mid);
            sortArray(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    
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