import java.util.HashMap;
import java.util.Map;

/**
 * Program to find longest sub-string with same letters after replacement.
 */
public class LongestSubStringWithSameLetters{

    public static int findLongestSubStringWithSameLetters(String str,int k){
        if(null == str || str.isEmpty()){
            throw new IllegalArgumentException("Null or empty string not allowed");
        }
        if(k<0){
            throw new IllegalArgumentException("k must be greater than equal to zero");
        }
        int windowStart = 0;
        int maxSubStringLength = 0;
        char[] strArr = str.toCharArray();
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        int maxRepeatLetterCount = 0;
        for(int windowEnd = 0;windowEnd<strArr.length;windowEnd++){
            char currentChar = strArr[windowEnd];
            charFrequencyMap.put(currentChar,charFrequencyMap.getOrDefault(currentChar,0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount,charFrequencyMap.get(currentChar));
            if(windowEnd-windowStart+1-maxRepeatLetterCount>k){
               char startChar = strArr[windowStart];
               charFrequencyMap.put(startChar,charFrequencyMap.get(startChar)-1);
               windowStart++;
            }
            maxSubStringLength = Math.max(maxSubStringLength,windowEnd-windowStart+1);
        }
        return maxSubStringLength;
    }
    public static void main(String[] args) {
        System.out.println(findLongestSubStringWithSameLetters("aabccbb",2));
        System.out.println(findLongestSubStringWithSameLetters("aabcddddgddddocbb",4));
    }
}