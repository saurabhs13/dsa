/**
 * Program to recursively multiply two square matrices of same dimension.
 */
public class RecursiveMatrixMultiplication{

    static int[][] recursiveMatrixMultiply(int a[][],int b[][]){
        int dimension = a.length;
        
        if(dimension==1){
            return new int[][] {{a[0][0]*b[0][0]}};
        }
        int[][] a11 = new int[dimension/2][dimension/2];
        int[][] a12 = new int[dimension/2][dimension/2];
        int[][] a21 = new int[dimension/2][dimension/2];
        int[][] a22 = new int[dimension/2][dimension/2]; 

        int[][] b11 = new int[dimension/2][dimension/2];
        int[][] b12 = new int[dimension/2][dimension/2];
        int[][] b21 = new int[dimension/2][dimension/2];
        int[][] b22 = new int[dimension/2][dimension/2]; 

        splitMatrix(a,a11,0,0);
        splitMatrix(a, a12, 0, dimension/2);
        splitMatrix(a,a21,dimension/2,0);
        splitMatrix(a, a22, dimension/2, dimension/2);
        splitMatrix(b,b11,0,0);
        splitMatrix(b, b12, 0, dimension/2);
        splitMatrix(b,b21,dimension/2,0);
        splitMatrix(b, b22, dimension/2, dimension/2);

        int[][] c11 = addMatrices(recursiveMatrixMultiply(a11, b11), recursiveMatrixMultiply(a12, b21));
        int[][] c12 = addMatrices(recursiveMatrixMultiply(a11, b12), recursiveMatrixMultiply(a12, b22));
        int[][] c21 = addMatrices(recursiveMatrixMultiply(a21, b11), recursiveMatrixMultiply(a22, b21));
        int[][] c22 = addMatrices(recursiveMatrixMultiply(a21, b12), recursiveMatrixMultiply(a22, b22));

        int c[][] = new int[dimension][dimension];

        combineMatrices(c, c11, 0, 0);
        combineMatrices(c, c12, 0, dimension/2);
        combineMatrices(c, c21, dimension/2, 0);
        combineMatrices(c, c22, dimension/2, dimension/2);

        return c;
    }

    private static void splitMatrix(int[][] parent, int[][] child, int rowStart, int colStart) {
        for (int i = 0; i < child.length; i++) {
            for (int j = 0; j < child.length; j++) {
                child[i][j] = parent[i + rowStart][j + colStart];
            }
        }
    }

    private static int[][] addMatrices(int[][] a,int[][] b){
        int n = a.length;
        int[][] resultMatrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                resultMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultMatrix;
    }
    private static void combineMatrices(int[][] parent,int[][] child,int rowStart,int colStart){
        for(int i=0;i<child.length;i++){
            for(int j=0;j<child.length;j++){
                parent[i+rowStart][j+colStart] = child[i][j];
            }
        }
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
    public static void main(String[] args){
        int[][] a = {{1,2,},{3,4,}};
        int[][] b = {{7,8},{9,10}};
        int[][] c = recursiveMatrixMultiply(a, b);
        print2DArray(c);
    }
}