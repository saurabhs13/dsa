
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero{

    public static List<List<Integer>> searchTriplets(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            if(arr[i] == arr[i+1])
                continue;
            search(arr,-arr[i],i+1,triplets);
        }
        return triplets;
    }
    private static void search(int[] arr,int sum,int left,List<List<Integer>> triplets){
        int right = arr.length-1;
        while(left<right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == sum){
                triplets.add(Arrays.asList(-sum,arr[left],arr[right]));
                left++;
                right--;
                while(left<right && (arr[left] == arr[left+1]))
                    left++;
                while(left<right && (arr[right] == arr[right-1]))
                    right--;
            }else if(currentSum>sum){
                right--;
            }else{
                left++;
            }
        }
    } 
    public static void main(String[] args){
        System.out.println(searchTriplets(new int[]{3,-4,2,-5,1,0,7,33,2,7,8,-8,9}));

    }

}