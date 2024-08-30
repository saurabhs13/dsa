import java.util.*;

public class GraphAdjacencyMatrix{
    Map<String,Integer> vertexPostionMap;
    int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(int numberOfVertices,Map<String,Integer> vertexPostionMap){
        this.adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        for(int i=0;i<numberOfVertices;i++){
            Arrays.fill(this.adjacencyMatrix[i],-1);
        }
        this.vertexPostionMap = vertexPostionMap;
        
    }
    public void addEdge(String sourceVertex,String destinationVertex,int weight,boolean directed){
        int sourceIndex = vertexPostionMap.get(sourceVertex);
        int destinationIndex = vertexPostionMap.get(destinationVertex);
        this.adjacencyMatrix[sourceIndex][destinationIndex] = weight;
        if(!directed){
            this.adjacencyMatrix[destinationIndex][sourceIndex] = weight;
        }
    }
    public boolean edgeExists(String sourceVertex,String destinationVertex){
        int sourceIndex = vertexPostionMap.get(sourceVertex);
        int destinationIndex = vertexPostionMap.get(destinationVertex);
        return (this.adjacencyMatrix[destinationIndex][sourceIndex] > -1);
    }

    public void printAdjacentVertices(String vertex){
        int vertIndex = vertexPostionMap.get(vertex);
        for(int weight:this.adjacencyMatrix[vertIndex]){
            if(weight != -1){
                System.out.println(weight);
            }
        }
    }

}