
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestPathDAG{
    public static int findShortestPath(WeightedGraph wg,int source,int dest){
       
        boolean[] visited = new boolean[wg.getNumberOfVertices()];
        Deque<Integer> stack = new ArrayDeque<>();
        int vertex = 0;
        topologicalSort(wg,vertex,visited,stack);

        int[] dist = new int[wg.getNumberOfVertices()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;

        while(!stack.isEmpty()){
            int currentVertex = stack.pop();
            if(dist[currentVertex]!=Integer.MAX_VALUE){
                for(Edge edge:wg.getAdjacencyList()[currentVertex]){
                    if(dist[edge.getDest()]>dist[currentVertex]+edge.getWeight()){
                        dist[edge.getDest()] = dist[currentVertex]+edge.getWeight();
                    }
                }
            }
        }

        return dist[dest];
    }
    private static void topologicalSort(WeightedGraph wg,int vertex,boolean[] visited, Deque<Integer> stack){
        
        visited[vertex] = true;

        for(Edge edge:wg.getAdjacencyList()[vertex]){
            if(!visited[edge.getDest()]){
                topologicalSort(wg, edge.getDest(), visited, stack);
            }
        }

        stack.push(vertex);
    }
    public static void main(String[] args) {
        WeightedGraph wg = new WeightedGraph(7);
        wg.addEdge(0,1,10);
        wg.addEdge(0,3,2);
        wg.addEdge(1,2,1);
        wg.addEdge(1,4,4);
        wg.addEdge(2,6,1);
        wg.addEdge(3,5,6);
        wg.addEdge(6,4,1);
      //  g.addEdge(6,1);
        wg.printGraph();
        System.out.print("Shortest Path b/w 1 & 4 = "+findShortestPath(wg, 1, 4));
    }
}