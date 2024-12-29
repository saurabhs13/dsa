
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of Bellman-Ford algorithm to find shortest path in a graph
 * that can have negaive weights & negaove cycles.
 */
public class BellmanFordShortestPath{

    public static int[] findShortestPath(WeightedGraph wg,int source){
        int vertices = wg.getNumberOfVertices();
        int[] dist = new int[vertices];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        Set<Integer> affectedNodes = new HashSet<>();
        
        for(int i=1;i<vertices;i++){
            for(int u=0;u<vertices;u++){
                    int parentVertex = u;
                    for(Edge edge:wg.getAdjacencyList()[parentVertex]){
                       relaxEdge(edge,dist,parentVertex);
                    }
                }
        }

        boolean edgeRelaxed = false;
        for(int u=0;u<vertices;u++){
            int parentVertex = u;
            for(Edge edge:wg.getAdjacencyList()[parentVertex]){
               edgeRelaxed =  relaxEdge(edge,dist,parentVertex);
               if(edgeRelaxed)
                    affectedNodes.add(edge.getDest());
            }
        }
        if(!affectedNodes.isEmpty()){
            System.out.println("Negative Cycle Detected");
            for(int node:affectedNodes){
                System.out.print(node + " ");
            }
            System.out.println("");
        }
        return dist;

    }
    private static boolean relaxEdge(Edge edge,int[] dist,int parentVertex){
                int destVertex = edge.getDest();
                int weight = edge.getWeight();
                if(dist[parentVertex]!= Integer.MAX_VALUE && dist[destVertex]>dist[parentVertex]+weight){
                    dist[destVertex] = dist[parentVertex]+weight;
                    return true;
                }
            return false;
    }
    public static void main(String[] args){
        WeightedGraph wg = new WeightedGraph(7);
        wg.addEdge(0,1,10);
        wg.addEdge(0,3,2);
        wg.addEdge(1,2,1);
        wg.addEdge(1,4,4);
        wg.addEdge(1,3,1);
        wg.addEdge(2,6,1);
        wg.addEdge(3,5,6);
        wg.addEdge(6,4,1);
        wg.addEdge(5,0,-9);
        wg.addEdge(6,1,1);
      //  wg.printGraph();
        int i =0;
        for(int dist: findShortestPath(wg, 1)){
            System.out.format("Shortest path from %d to %d is %d \n",1,i,dist);
            i++;
        }
    }
}