
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Program to find mother node in a graph i.e. a node that has a path to all the nodes.
 * There can be more than one mother nodes, this program returns any in that case, else returns -1.
 */
public class GraphFindMotherNode{
    /**
     * Naive approach
     * TC- O(V(V+E))
     * SC- O(V)
     */
    public static int findMotherVertex(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        for(int i=0;i<vertices;i++){
            boolean[] visited = new boolean[vertices]; 
            int visitedVerticesCount = performDfs(g,i,visited);
            if(visitedVerticesCount==vertices)
                return i;
        }
        return -1;
    }
    /**
     * Optimized approach using a modified Kosaraju's algorithm.
     * TC- O(V+E)
     */
    public static int findMotherVertexOptimized(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices]; 
        int lastVisited = 0;
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                performDfs(g,i,visited);
                lastVisited = i;
            }
        }
        Arrays.fill(visited,false);
        int visitedVerticesCount = performDfs(g, lastVisited, visited);
        if(visitedVerticesCount==vertices)
            return lastVisited;
        return -1;
    }
    private static int performDfs(GraphLinkedListImplementation g, int node,boolean[] visited){
        Deque<Integer> stack = new ArrayDeque<>();
        int visitedCount = 0;
        stack.push(node);
        visited[node] = true;
        visitedCount++;
        while(!stack.isEmpty()){
            int currentVertex = stack.pop();
            for(int neighbor:g.adjacencyList[currentVertex]){
                if(!visited[neighbor]){
                    visitedCount++;
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return visitedCount;
    }
    public static void main(String[] args) {
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(7);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(2,6);
        g.addEdge(3,5);
        g.addEdge(4,1);
        g.addEdge(6,4);
        g.printGraph();
        System.out.println("");
        System.err.println("Mother Vertex:"+ findMotherVertex(g));
        System.err.println("Mother Vertex:"+ findMotherVertexOptimized(g));
        //System.err.println("Cycle Exists:"+ detectCycleIterative(g));
    } 
}