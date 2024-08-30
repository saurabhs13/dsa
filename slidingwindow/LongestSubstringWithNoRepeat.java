import java.util.HashMap;
import java.util.Map;
public class LongestSubstringWithNoRepeat{
    private static int findLongestSubstringWithNoRepeat(String str){
        int maxSubStringLength = 1;
        int windowStart = 0;
        Map<Character,Integer> charIndexMap = new HashMap<>();

        for(int windowEnd = 0;windowEnd<str.length();windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(charIndexMap.containsKey(rightChar)){
                windowStart = Math.max(windowStart,charIndexMap.get(rightChar)+1);
            }
            maxSubStringLength = Math.max(maxSubStringLength,windowEnd-windowStart+1);
            charIndexMap.put(rightChar,windowEnd);
        }
        return maxSubStringLength;
    }
    public static void main(String[] args){
        String str1 = "aabccbb";
        String str2 = "abbbb";

        System.out.println(findLongestSubstringWithNoRepeat(str1));
        System.out.println(findLongestSubstringWithNoRepeat(str2));

    }
}