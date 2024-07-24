
import java.util.Arrays;

public class TripletWithSumLessThanTarget{
    public static int countTripletsLessThanTargetSum(int[] arr,int targetSum){
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length -1;
            while(left < right){
                int currentSum = arr[i] + arr[left] + arr[right];
                if(currentSum < targetSum){
                    count+=right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countTripletsLessThanTargetSum(new int[]{1,2,3,4,5,6,7,8,9,0,-1,-2}, 0));
    }
}