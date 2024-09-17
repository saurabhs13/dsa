public class StandardMatrixMultiplicationDemo{
 
    public static int[][] calculateDotProduct(int[][] a,int[][] b){
       int[][] c = new int[a.length][b[0].length];
       for(int i=0;i<a.length;i++){
            for(int k=0;k<a.length;k++){
                c[i][k] = 0;
                for(int j=0;j<b.length;j++){
                    c[i][k] += (a[i][j]*b[j][k]);
                }
            }
       }
       return c;
    }
    public static void print2DArray(int[][] c){
        System.out.print("\n");
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                System.out.print(c[i][j]+ " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{7,8},{9,10},{11,12}};
        System.out.print("\n Matrix a");
        print2DArray(a);
        System.out.print("\n Matrix b");
        print2DArray(b);
        System.out.print("\n Matrix c");
        print2DArray(calculateDotProduct(a, b));
    }
}