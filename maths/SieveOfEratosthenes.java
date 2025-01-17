
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes{

    public static List<Integer> findAllPrimes(int n){
        List<Integer> primeList = new ArrayList<>();

        /**
         * Precomputation for the prime check.
         */
        int[] prime = new int[n+1];
        Arrays.fill(prime,1);
        for(int i=2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        /**
         * Prime check.
         */
        for(int i=2;i<=n;i++){
            if(prime[i]==1)
                primeList.add(i);
        }
        return primeList;
    }
    public static void main(String[] args) {
        
        for(int i:findAllPrimes(36)){
            System.out.println(i+" ");
        }
        
    }
}