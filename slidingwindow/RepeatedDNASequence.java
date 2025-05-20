import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
class RepeatedDNASequence {

    public static List<String> bruteForceFindRepeatedDnaSequences(String s) {

        Set<String> result = new HashSet<>();
        int k = 10;
        if(null ==s || s.length()<10){
            return new ArrayList<>();
        }
        for(int i=0;i<s.length()-9;i++){
            String subStr = s.substring(i,i+10);
            if(result.contains(subStr)){
                continue;
            }
            for(int j=i+1;j<s.length()-k-1;j++){
                String subStr2 = s.substring(j,j+k);
                if(subStr.equals(subStr2)){
                    result.add(subStr);
                    break;
                }
            }
        }
        return new ArrayList<>(result);
    }

    
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<Integer> seenHashes = new HashSet<>();
        if(null ==s || s.length()<10){
            return new ArrayList<>();
        }
        Map<Character,Integer> charToInt = new HashMap<>();
        charToInt.put('A',0);
        charToInt.put('C',1);
        charToInt.put('G',2);
        charToInt.put('T',3);
        int base = 4;
        int k = 10;
        int hash = 0;
        int mod = 1_000_000_007;
        int highBase = (int)Math.pow(base,(k-1))%mod;
    
        char[] sArr = s.toCharArray();
        //calculate hash of 1st window
        for(int i=0;i<k;i++){
            hash = (hash*base + charToInt.get(sArr[i]))%mod;
        }
        seenHashes.add(hash);
       
            // Sliding window
        for(int j = 1; j <= sArr.length - k; j++) {
            // Update hash: remove the outgoing character and add the incoming character
            hash = ((hash - charToInt.get(sArr[j - 1]) * highBase)*base + charToInt.get(sArr[j + k - 1]))%mod;
            // Ensure the hash is non-negative
            if (hash < 0) {
                hash = (hash+mod)%mod;
            }
          
            if (seenHashes.contains(hash)) {
                result.add(s.substring(j, j + k));
            } else {
                seenHashes.add(hash);
            }
        }
      
        return new ArrayList<>(result);
    }
     public static String generateLargeDNAString(int length) {
        char[] chars = {'A', 'C', 'G', 'T'};
        StringBuilder sb = new StringBuilder(length);
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars[rand.nextInt(4)]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = generateLargeDNAString(10000);    
        long startTime = System.currentTimeMillis();      
        findRepeatedDnaSequences(s);
        long endTime = System.currentTimeMillis();  
        System.out.println("Time taken for Rabin Karp: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();     
        bruteForceFindRepeatedDnaSequences(s);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for brute force: " + (endTime - startTime) + "ms");
    }   
}
