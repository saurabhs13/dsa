
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.
 */
public class WindowMaximum{
    /**
     * Brute force approach with TC- O((n-w+1)*w) ~ O(n*w)
     */
    public static int[] windowMaximum(int[] nums,int w){
        int n = nums.length;
        int[] result = new int[n-w+1];
        for(int i=0;i<n-w+1;i++){
            int max = nums[i];
            for(int j=i+1;j<i+w;j++){
                if(nums[j]>max)
                    max = nums[j];
            }
            result[i] = max;
        }
        return result;
    }
    /**
     * sliding window approach
     */
    public static int[] findMaxSlidingWindow(int[] nums, int w){
        int n = nums.length;
        if(n<w)
            return new int[0];
        int[] result = new int[n-w+1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for(int i=0;i<w;i++){
            cleanup(nums,i,currentWindow);
            currentWindow.add(i);
        }
        result[0] = nums[currentWindow.getFirst()];

        for(int i=w;i<n;i++){
            cleanup(nums, i, currentWindow);
            if(!currentWindow.isEmpty()&&currentWindow.getFirst()<=i-w)
                currentWindow.removeFirst();
            currentWindow.add(i);
            result[i-w+1] = nums[currentWindow.getFirst()];
        }
        return result;
    } 
    
    public static void cleanup(int[] nums, int i,Deque<Integer> currentWindow){
        while (!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.getLast()]) {
			currentWindow.removeLast();
		}
    }
    public static void main(String[] args){
        int[] arr = {2,4,3,6,5,4,1,10};
        int k = 3;
        for(int i:findMaxSlidingWindow(arr, k)){
            System.out.print(i+" ");
        }
    }
}