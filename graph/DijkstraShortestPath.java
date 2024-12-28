
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Program for Dijkstra's algorithm to calculate shortest path
 * for graphs with +ve edge weights.
 */
public class DijkstraShortestPath{

    public static int[] findShortestPath(WeightedGraph wg,int source){
        int vertices = wg.getNumberOfVertices();
        int[] dist = new int[vertices];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr->arr[1])); 
        minHeap.offer(new int[]{source,0});
        while(!minHeap.isEmpty()){
            int[] currentEntry = minHeap.poll();
            int currentVertex = currentEntry[0];
            int currentDist = currentEntry[1];

            if(currentDist>dist[currentVertex])
                   continue;
            
            for(Edge edge:wg.getAdjacencyList()[currentVertex]){
                if(dist[edge.getDest()]>dist[currentVertex]+edge.getWeight()){
                    dist[edge.getDest()] = dist[currentVertex]+edge.getWeight();
                    minHeap.offer(new int[]{edge.getDest(),dist[edge.getDest()]});
                }
            }
        }   
        return dist;
    }   
    public static void main(String[] args) {
        WeightedGraph wg = new WeightedGraph(7);
        wg.addEdge(0,1,10);
        wg.addEdge(0,3,2);
        wg.addEdge(1,2,1);
        wg.addEdge(1,4,4);
        wg.addEdge(1,3,1);
        wg.addEdge(2,6,1);
        wg.addEdge(3,5,6);
        wg.addEdge(6,4,1);
      //  g.addEdge(6,1);
        wg.printGraph();
        int i =0;
        for(int dist: findShortestPath(wg, 1)){
            System.out.format("Shortest path from %d to %d is %d \n",1,i,dist);
            i++;
        }
    }
}

