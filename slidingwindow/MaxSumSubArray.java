public class MaxSumSubArray{

 public static int maxSumSubArray(int[] inputArray,int k){
       if(null == inputArray || inputArray.length==0){
            throw new IllegalArgumentException("Input array cannot be null or empty");
       }
       if(k<=0){
            throw new IllegalArgumentException("Subarray size should be greater than 0");
       }
       int windowStart = 0;
       int maxSum = 0;
       int windowSum = 0;
       for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++){
            windowSum+=inputArray[windowEnd];
            if(windowEnd>=k-1){
                maxSum = windowSum>maxSum?windowSum:maxSum;
                windowSum-=inputArray[windowStart];
                windowStart++;
            }
        }
        return maxSum;
}
public static void main(String[] args){
    int[] arr = {1,2,3,4,15,6,7,8,9,10};
    int k = 0;
    System.out.println(maxSumSubArray(arr,k));
}

}