public class MergeSort2{

    public static void sort(int[] arr){
        int n = arr.length;
        if(n<2){
            return;
        }
        int mid = n/2;
        int n1 = mid;
        int n2 = n-mid;
        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        for(int i=0;i<n1;i++){
            larr[i] = arr[i];
        }
        for(int j=0;j<n2;j++){
            rarr[j] = arr[mid+j];
        }

        sort(larr);
        sort(rarr);
        merge(larr,rarr,arr);
    }

    public static void merge(int[] larr,int[] rarr,int[] arr){
        int k=0;
        int l = 0;
        int r = 0;
        while(l<larr.length&&r<rarr.length){
            if(larr[l]<rarr[r]){
                arr[k]  = larr[l];
                l++;
            }else{
                arr[k] = rarr[r];
                r++;
            }
            k++;
        }
        for(int i =l;i<larr.length;i++){
            arr[k] = larr[i];
            k++;
        }
        
        for(int j =r;j<rarr.length;j++){
            arr[k] = rarr[j];
            k++;
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
        sort(arr);
        printArray(arr);
    }
}