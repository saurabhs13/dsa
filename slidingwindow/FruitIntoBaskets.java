import java.util.*;
public class FruitIntoBaskets{

    private static int findLongestSubarrayWithTwoDistinctChars(char[] charArr){
        int windowStart = 0;
        Set<Character> set = new HashSet<Character>();
        int maxSubStringLength = -1;
        int baskets = 2;
        for(int windowEnd=0;windowEnd<charArr.length;windowEnd++){
            set.add(charArr[windowEnd]);
            if(set.size()==baskets){
                maxSubStringLength = Math.max(maxSubStringLength,windowEnd-windowStart+1);
            }
            if(set.size()>baskets){
                set.remove(charArr[windowStart]);
                windowStart++;
            }
        }
       return maxSubStringLength==-1?charArr.length:maxSubStringLength;
    } 
    
    public static void main(String[] args){
        char[] fruit1 = new char[]{'A', 'B', 'C', 'A', 'C'};
        char[] fruit2 = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLongestSubarrayWithTwoDistinctChars(fruit1));
        System.out.println(findLongestSubarrayWithTwoDistinctChars(fruit2)); 
    }
}