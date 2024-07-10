public class LongestSubArrayWithOnes{

    public static int findLongestSubArrayWithOnes(int[] arr,int k){

        if(null == arr || arr.length==0){
            throw new IllegalArgumentException("Null or empty array not allowed");
        }
        if(k<0){
            throw new IllegalArgumentException("k must be greater than equal to zero");
        }
        int windowStart = 0;
        int maxSubArraySize = 0;
        int zeroCount = 0;
        for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){
            int currentWindowEndItem = arr[windowEnd];
            if(currentWindowEndItem ==0){
                zeroCount++;
            }
            while(zeroCount > k && windowStart<=windowEnd){
                int windowStartItem = arr[windowStart];
                if(windowStartItem==0){
                    zeroCount--;
                }
                windowStart++;
            }
            maxSubArraySize = Math.max(maxSubArraySize,windowEnd-windowStart+1);
        }
        return maxSubArraySize;
    } 
    public static void main(String[] args) {
      
        System.out.println(findLongestSubArrayWithOnes(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2));
        System.out.println(findLongestSubArrayWithOnes(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
    }
    
}