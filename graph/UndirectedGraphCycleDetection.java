import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
/**
 * Program to detect cycle in an undirected graph.
 */
public class UndirectedGraphCycleDetection{

    public static boolean detectCycle(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.out.println("Detect Cycle invoked from main for vertex = "+ i);
                if(detectCycle(i,visited,g,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean detectCycle(int vertex,boolean[] visited,GraphLinkedListImplementation g,int parent){
        visited[vertex] = true;
        List<Integer> adjacentNodes = g.adjacencyList[vertex];
        for(int i:adjacentNodes){
            if(!visited[i]){
                if(detectCycle(i,visited,g,vertex)){
                    return true;
                }
            }else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycleIterative(GraphLinkedListImplementation g){
        boolean[] visited = new boolean[g.numberOfVertices];
        int[] parent = new int[g.numberOfVertices];
        Arrays.fill(parent,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<g.numberOfVertices;i++){
            if(!visited[i]){
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int currentVertex = queue.poll();
                    for(int childVertex:g.adjacencyList[currentVertex]){
                        if(!visited[childVertex]){
                            queue.add(childVertex);
                            visited[childVertex] = true;
                            parent[childVertex] = currentVertex;
                        }else{
                            if(childVertex!=parent[currentVertex]){
                                return true;
                            }
                        }
                    }
                }
            }
        }
       
        return false;
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(4);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,0);
        g1.addEdge(1,2);
        g1.addEdge(2,1);
        g1.addEdge(2,0);
        g1.addEdge(2,3);
        g1.addEdge(3,2);
        g1.printGraph();
        System.out.println("Cycle exists in Graph G1 ?: "+detectCycle(g1));
        GraphLinkedListImplementation g2 = new GraphLinkedListImplementation(6);
        g2.addEdge(0,1);
        g2.addEdge(1,0);
        g2.addEdge(1,2);
        g2.addEdge(2,1);
        g2.addEdge(3,4);
        g2.addEdge(4,3);
        g2.printGraph();
        System.out.println("Cycle exists in Graph G2 ?: "+detectCycle(g2));
        System.out.println("Cycle exists in Graph G1, G2 ?: "+detectCycleIterative(g1)+","+detectCycleIterative(g2));
    }
}