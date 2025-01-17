
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Digits{

    public static List<Integer> extractDigits(int n){

        List<Integer> digits = new ArrayList<>();
        while(n>0){
            digits.add(n%10);
            n = n/10;
        }
        return digits;
    }
    /**
     * Method to reverse a number excluding leading zeros.
     */
    public static int reverseNumber(int n){

        int reverseNumber = 0;
        int digit;
        while(n>0){
            digit = n %10;
            reverseNumber = reverseNumber*10 + digit;
            n = n/10;
        }
        return reverseNumber;
    }

    public static boolean isArmstrongNumber(int n){
        int nCopy = n;
        int digit = 0, sum = 0;
        while(n>0){
            digit = n %10;
            sum = sum + (digit*digit*digit);
            n = n/10;
        }
        
        return sum==nCopy;
    } 
    public static void printDvisisors(int n){
        Set<Integer> sortedSet = new TreeSet<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                sortedSet.add(i);
                if((n/i)!=i)
                    sortedSet.add(n/i);
            }
        }
        for(int i:sortedSet){
            System.out.print(i+" ");
        }
    }
    public static boolean isPrimeNumber(int n){
        int count = 0;
        for(int i =1;i*i<=n;i++){
            if(n%i==0)
                count++;
        }
        return n<=2;
    } 
    public static int findGCD(int n1,int n2){

        while(n1>0&&n2>0){
            if(n1>n2)
                n1= n1%n2;
            else
                n2 = n2 % n1;
        }
        return n1==0?n2:n1;
    }
    public static void main(String[] args) {

        List<Integer> digits = extractDigits(10364545);
        for(int i:digits){
            System.out.print(i + " ");
        }
        System.out.println(reverseNumber(78900));
        printDvisisors(36);
        System.out.println(findGCD(36, 35));
    }
}