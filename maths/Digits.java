
import java.util.ArrayList;
import java.util.List;

public class Digits{

    public static List<Integer> extractDigits(int n){

        List<Integer> digits = new ArrayList<>();
        while(n>0){
            digits.add(n%10);
            n = n/10;
        }
        return digits;
    }
    public static void main(String[] args) {

        List<Integer> digits = extractDigits(10364545);
        for(int i:digits){
            System.out.print(i + " ");
        }

    }
}