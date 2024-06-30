public class BinarySearch{

    public static  Integer findItemIndex(int[] arr,int item){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int guess;
        while(low <=high){
            mid = (low+high)/2;
            guess = arr[mid];
            if(guess==item){
                return mid;
            }else if(guess>item){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int item = 66;

        Integer index = findItemIndex(arr,item);

        if(index == -1){
            System.out.println("Item not found");
        }else{
            System.out.println("Item found at index = "+index);
        }

    }

}