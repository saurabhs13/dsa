import java.util.LinkedList;
import java.util.List;

public class WeightedGraph{
    private int numVertices;
    private List<Edge>[] adjacencyList;

    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src,int dest,int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public WeightedGraph(int numVertices){
        this.numVertices = numVertices;
        this.adjacencyList =  new LinkedList[numVertices];
        for(int i=0;i<numVertices;i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest,int weight){
        Edge edge = new Edge(src, dest, weight);
        adjacencyList[src].add(edge);
    }
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Adjacency list of vertex " + i + ":");
            for (Edge edge : adjacencyList[i]) {
                System.out.print(" -> (" + edge.dest + ", " + edge.weight + ")");
            }
            System.out.println();
        }
    }
   public static void main(String[] args) {
    int vertices = 5;
    WeightedGraph graph = new WeightedGraph(vertices);
    graph.addEdge(0, 1, 4);
    graph.addEdge(0, 4, 7);
    graph.addEdge(1, 2, 8);
    graph.addEdge(1, 3, 5);
    graph.addEdge(2, 3, 9);
    graph.addEdge(3, 4, 10);

    graph.printGraph();
   }
}   