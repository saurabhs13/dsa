public class Exponentiation{
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;
    public static long exponent(int number,int power){
        count1++;
       return power==0?1:number*exponent(number,power-1);
    }
  public static long betterExponent(int number,int power){
        count2++;
        if(power ==0){
            return 1;
        }else if(power %2 ==0){
            return square(betterExponent(number,power/2));
        }else{
            return number*betterExponent(number,power-1);
        }
          
    }
    public static long square(long number){
        return number * number;
    }
    public static long iterativeExponent(int number, int power){
        long result = 1;
        while(power != 1){
            count3++;
           if(power %2 ==0){
                result = result * square(iterativeInternal(number,power/2));
                power = power/2;

           }else{
                result = result * number;
                power = power -1;

           }
        }
        return result;
    }

    public static long iterativeInternal(int number,int power){
            long result = 1;

            while(power!=0){
                count3++;
                result = result*number;
                power--;
            }
            return result;
    }
    public static void main(String[] args){
    
        System.out.println(exponent(10,10));
        System.out.println(betterExponent(10,10));
        System.out.println(iterativeExponent(10,10));
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}