import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
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
        Set<Integer> addedToResult = new HashSet<>();
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
          
            if (seenHashes.contains(hash) && !addedToResult.contains(hash)) {
                result.add(s.substring(j, j + k));
                addedToResult.add(hash);
            } else {
                seenHashes.add(hash);
            }
        }
      
        return new ArrayList<>(result);
    }
    public static List<String> bitwiseFindRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }

        Map<Character, Integer> charToBits = Map.of(
                'A', 0,
                'C', 1,
                'G', 2,
                'T', 3
        );

        int k = 10;
        int hash = 0;
        int mask = (1 << (2 * k)) - 1;  // To retain only 20 bits

        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            // Add new character's bits
            hash = ((hash << 2) | charToBits.get(s.charAt(i))) & mask;

            // Start checking only when we have the first 10-letter substring
            if (i >= k - 1) {
                if (seen.contains(hash)) {
                    result.add(s.substring(i - k + 1, i + 1));
                } else {
                    seen.add(hash);
                }
            }
        }

        return new ArrayList<>(result);
    }
    public static List<String> fasterBitwiseFindRepeatedDnaSequences(String s){
        int k = 10;
        int n = s.length();
        if (n < k) return Collections.emptyList();

        /**
         * Here we have used an array of size 26 instead of a hashmap.
         * This saves CPU with hashing and has lower memory footprint
         * as no objects, collections are involved.
         * This also has a deterministic way to find number for any char
         * because it stores them as 'char' - 'A' so it's 0 for A, 1 for B n so on
         * hence it has codified the logic to retrieve from this array without
         * iterating the
         */
        int[] charToBits = new int[26]; // 'A' to 'Z'
        charToBits['A' - 'A'] = 0; // 00
        charToBits['C' - 'A'] = 1; // 01
        charToBits['G' - 'A'] = 2; // 10
        charToBits['T' - 'A'] = 3; // 11

        int hash = 0;
        int mask = (1 << (2 * k)) - 1; // 20-bit mask: 0xFFFFF

        System.out.println("mask: " + mask);
        // Use bitsets for performance: 1M size is enough (4^10 = 1,048,576)
        BitSet seen = new BitSet(1 << 20);
        BitSet added = new BitSet(1 << 20);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            hash = ((hash << 2) | charToBits[s.charAt(i) - 'A']) & mask;

            if (i >= k - 1) {
                if (seen.get(hash)) {
                    if (!added.get(hash)) {
                        result.add(s.substring(i - k + 1, i + 1));
                        added.set(hash);
                    }
                } else {
                    seen.set(hash);
                }
            }
        }

        return result;
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
        String s = generateLargeDNAString(100_000);    
        /**long startTime = System.currentTimeMillis();      
        findRepeatedDnaSequences(s);
        long endTime = System.currentTimeMillis();  
        System.out.println("Time taken for Rabin Karp: " + (endTime - startTime) + "ms"); */
      /**  startTime = System.currentTimeMillis();     
        bruteForceFindRepeatedDnaSequences(s);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for brute force: " + (endTime - startTime) + "ms");*/ 
     /**   startTime = System.currentTimeMillis();     
        bitwiseFindRepeatedDnaSequences(s);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for bitwise repeated dna seq: " + (endTime - startTime) + "ms");
         */
        long startTime = System.currentTimeMillis();     
        fasterBitwiseFindRepeatedDnaSequences(s);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for faster bitwise repeated dna seq: " + (endTime - startTime) + "ms");
    }   
}
