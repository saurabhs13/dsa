
import java.util.ArrayList;
import java.util.List;

public class SubarrayWithProductLessThanTarget{

    public static List<List<Integer>> findSubArrays(int[] arr,int target){
        
        List<List<Integer>> subArrays = new ArrayList<>();
        

            int windowStart = 0;
            int product = 1;
            for(int windowEnd=windowStart;windowEnd<arr.length;windowEnd++){
                product*=arr[windowEnd];
                while(product<=target){
                    List<Integer> list = new ArrayList<>();
                    for(int i=windowStart;i<=windowEnd;i++){
                        list.add(arr[i]);
                    }
                    subArrays.add(list);
                }
            }
        
        

        return subArrays;
    }
    public static void main(String[] args) {
        
    }
}