public class MaxSubArray{

    public static int maxSumSubArray(int[] nums){
        if(null ==nums || 0 == nums.length){
            throw new RuntimeException("Invalid Input");
        }
        int currentMax = nums[0];
        int globalMax = currentMax;
        for(int i=1;i<nums.length;i++){
            if(currentMax<0){
                currentMax = nums[i];
            }else{
                currentMax+=nums[i];
            }
            if(globalMax<currentMax){
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
    public static void main(String[] args){
        int[] nums1 = {1,-4,3,5,6,-9,8,10};
        System.out.println(maxSumSubArray(nums1));
    }
}