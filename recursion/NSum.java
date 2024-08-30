public class NSum{

    public static int sum(int n){
        return n==0?0:n+sum(n-1);
    }
    public static void main(String[] args){
        int n =10;
        System.out.println(sum(10));
    }
}