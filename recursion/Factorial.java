public class Factorial{

    public static long recursiveFactorial(int n){
            return n==1?1:n*recursiveFactorial(n-1);
    }
    public static long iterativeFactorial(int n){
        long factorial = n;
        for(int i=n-1;i>1;i--){
            factorial = factorial *i;
        }
        return factorial;
    }
    public static long tailRecursiveFactorial(int n,long accumulator){
        if(n==0){
            return accumulator;
        }else{
            return tailRecursiveFactorial(n-1,n*accumulator);
        }
    }
    public static void main(String[] args){
        System.out.println(recursiveFactorial(5));
        System.out.println(iterativeFactorial(5));
        System.out.println(tailRecursiveFactorial(5,1));
    }

}