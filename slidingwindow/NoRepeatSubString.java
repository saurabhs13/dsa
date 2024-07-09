import java.util.HashMap;
import java.util.Map;
public class NoRepeatSubString{

    public static int findLongestSubstringWithNoRepeat(String str){
        if(null == str || str.isEmpty()){
            throw new IllegalArgumentException("Input string is null or empty");
        }
        int windowStart = 0;
        Map<Character,Integer> charIndexMap = new HashMap<>();
        int windowLength = 0;
        char strArr[] = str.toCharArray();
        int maxSubStringLength = 0;
        for(int windowEnd=0;windowEnd<strArr.length;windowEnd++){
            char currentChar = strArr[windowEnd];
            if(charIndexMap.containsKey(currentChar)){
                windowStart = Math.max(windowStart,charIndexMap.get(currentChar) +1);
            }
            charIndexMap.put(currentChar,windowEnd);
            windowLength = windowEnd-windowStart+1;
            maxSubStringLength = Math.max(windowLength,maxSubStringLength);
        }
        return maxSubStringLength;
    }
    public static void main(String[] args){
        String str1 = "aabccbbsdsdsdsdwqvbhjuterewwrtuioiooooooourfere";
        String str2 = "abbbb";

        System.out.println(findLongestSubstringWithNoRepeat(str1));
        System.out.println(findLongestSubstringWithNoRepeat(str2));

    }
}