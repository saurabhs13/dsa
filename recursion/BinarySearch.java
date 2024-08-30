public class BinarySearch{

    public static int search(int arr[],int element,int low,int high){
        if(low == high){
            if(arr[low]==element){
                return low;
            }else{
                return -1;
            }
        }else{
            int mid = (low+high)/2;
            if(arr[mid]==element){
                return mid;
            }else if(element>arr[mid]){
                return search(arr,element,mid+1,high);
            }else{
                return search(arr,element,low,mid-1);
            }
        }
    }
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,1,13,14,15};
        int index = search(arr,5,0,arr.length-1);
        if(index!=-1){
            System.out.println("Found at index:"+index);
        }else{
            System.out.println("Element not found");

        }
       
    }

}