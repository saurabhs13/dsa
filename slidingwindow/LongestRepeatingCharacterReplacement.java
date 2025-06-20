import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    /**
     * Brute force approach to solve the problem.
     * @param s
     * @param k
     * @return
     */
    public static int longestRepeatingCharacterReplacementBF(String s, int k) {
        char[] sArr = s.toCharArray();
        int maxLen = -1;
        for(int i=0;i<s.length();i++){
            char baseChar = sArr[i];
            int diffCharCount = 0;
            for(int j=i+1;j<s.length();j++){
                if(sArr[j]!=baseChar)
                    diffCharCount++;
                if(diffCharCount<=k){
                    if(j-i+1>maxLen)
                        maxLen = j-i+1;
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
    /**
     * Optimized solution using sliding window.
     * Approach is to track the most freq. character in the window and
     * shrink the window when windoiw size-max count>k as that many characters
     * have to be replaced.
     * @param s
     * @param k
     * @return
     */
    public static int longestRepeatingCharacterReplacement(String s,int k){
        int maxLen = -1;
        char[] sArr = s.toCharArray();
        Map<Character,Integer> charCount = new HashMap<>();
        int maxCount = 0;
        int ws = 0;
        for(int we=0;we<s.length();we++){
            charCount.put(sArr[we],charCount.getOrDefault(sArr[we], 0)+1);
            maxCount = Math.max(maxCount,charCount.get(sArr[we]));
            while(we-ws+1-maxCount>k){
                charCount.put(sArr[ws],charCount.get(sArr[ws])-1);
                ws++;
            }
            maxLen = Math.max(we-ws+1,maxLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aabccbb";
        int k = 2;
        System.out.println(longestRepeatingCharacterReplacement(s, k));
    }
}
