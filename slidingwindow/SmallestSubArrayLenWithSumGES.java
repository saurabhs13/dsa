public class SmallestSubArrayLenWithSumGES{

 public static int maxSumSubArray(int[] inputArray,int s){

    if(null == inputArray || inputArray.length==0){
        throw new IllegalArgumentException("Input array cannot be null or empty");
    }
    int windowStart=0;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;
    for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++){
        windowSum+=inputArray[windowEnd];
        while(windowSum>=s){
            int windowLength = windowEnd-windowStart+1;
            minLength = windowLength<minLength?windowLength:minLength;
            windowSum-=inputArray[windowStart];
            windowStart++;
        }
    }

    return minLength;
}
public static void main(String[] args){
    int[] arr = {1,2,3,4,15,6,7,8,9,10};
    int s = 19;
    int subArrayLength = maxSumSubArray(arr,s);
    if(Integer.MAX_VALUE==subArrayLength){
        System.out.println("No contiguous sub-array has sum s");
    }else{
        System.out.println("Smallest sub-array length: "+subArrayLength);
    }
}

}