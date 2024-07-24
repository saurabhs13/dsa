
import java.util.Arrays;

public class TripletWithSumCloseToTarget{
    public static int findTriplets(int[] arr,int sum){
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right  = arr.length-1;
            while(left<right){
                int diff = sum - arr[i] - arr[left] -arr[right];
                if(diff == 0){
                    return sum;
                }
                if(Math.abs(diff) < Math.abs(minDiff) || (Math.abs(diff) == Math.abs(minDiff) && minDiff>diff)){
                    minDiff = diff;
                }
                if(diff > 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return sum-minDiff;
    }
    public static void main(String[] args){
        System.out.println(findTriplets(new int[]{1,2,3,4,5,9,7,0,-10,5,-1,-2,-3,-5},-20));
    }
}