import java.util.*;
public class LongestSubstringWithKDistinct{

    private static int findLongestSubstringUsingSet(String s,int k){
        int maxSubStringLength = -1;
        Set<Character> uniqueCharSet = new HashSet<Character>();
        int windowEnd = 0;
        int windowStart = 0;
        int distinctCharCount = 0;
        for(windowEnd=0;windowEnd<s.length();windowEnd++){
            uniqueCharSet.add(s.charAt(windowEnd));
            if(uniqueCharSet.size()==k){
                maxSubStringLength = Math.max(maxSubStringLength,windowEnd-windowStart+1);
            }
            if(uniqueCharSet.size()>k){
                uniqueCharSet.remove(s.charAt(windowStart));
                windowStart++;
            }
        }
        return maxSubStringLength == -1?s.length():maxSubStringLength;
    }
    private static int findLongestSubstringUsingMap(String str,int k){
        if(null == str || str.isEmpty()){
            throw new IllegalArgumentException("Input string is null or empty");
        }
        if(k<=0){
            throw new IllegalArgumentException("Number of characters should be greater than equal to 0");
        }
        int maxSubStringLength = -1;
        int windowStart = 0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        char[] strArr = str.toCharArray();
        int windowLength = 0;
        for(int windowEnd=0;windowEnd<strArr.length;windowEnd++){ 
            charFrequencyMap.put(strArr[windowEnd],charFrequencyMap.getOrDefault(strArr[windowEnd],0)+1);
            while(charFrequencyMap.keySet().size()>k){
                if(charFrequencyMap.containsKey(strArr[windowStart])){
                    if(charFrequencyMap.get(strArr[windowStart]) > 1){
                        charFrequencyMap.put(strArr[windowStart],charFrequencyMap.get(strArr[windowStart])-1);
                    }else{
                        charFrequencyMap.remove(strArr[windowStart]);
                    }
                    windowStart++;
                }
            }
            windowLength = windowEnd-windowStart+1;
            maxSubStringLength = windowLength>maxSubStringLength?windowLength:maxSubStringLength;
        }
        return maxSubStringLength;

    }
    public static void main(String[] args){
        String str = "aaaaaaaaaa";
        String str2 = "cbbebi";
        String str3 = "araaci";
        System.out.println(findLongestSubstringUsingSet(str,3));
        System.out.println(findLongestSubstringUsingSet(str2,3));
        System.out.println(findLongestSubstringUsingSet(str3,1));
        System.out.println(findLongestSubstringUsingSet(str3,2));
        System.out.println(findLongestSubstringUsingMap(str,3));
        System.out.println(findLongestSubstringUsingMap(str2,3));
        System.out.println(findLongestSubstringUsingMap(str3,1));
        System.out.println(findLongestSubstringUsingMap(str3,2));
    }

}