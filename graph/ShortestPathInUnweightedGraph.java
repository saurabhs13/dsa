import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
public class ShortestPathInUnweightedGraph{

    public static int findShortestPathLength(GraphLinkedListImplementation g,int source,int destination){
        
        int vertices = g.numberOfVertices;
        if(vertices<2)
            return -1;
        boolean[] visited = new boolean[vertices];
        int[] pathLength = new int[vertices];
        Arrays.fill(pathLength,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited[source] = true;
        pathLength[source] = 0;
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(int child:g.adjacencyList[parent]){
                if(!visited[child]){
                    queue.add(child);
                    visited[child] = true;
                    pathLength[child] = pathLength[parent]+1;                
                }
                if(child==destination){
                    return pathLength[child];
                }
            }

        }
        return -1;
        
    }   
    public static List<Integer> findShortestPath(GraphLinkedListImplementation g,int source,int destination){
        int vertices = g.numberOfVertices;
        if(vertices<2){
            return new ArrayList<>();
        }
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int parentVertex = queue.poll();
            for(int childVertex:g.adjacencyList[parentVertex]){
                if(!visited[childVertex]){
                    visited[childVertex] = true;
                    queue.add(childVertex);
                    parent[childVertex] = parentVertex;
                }
                if(childVertex==destination){
                    return reconstructPath(source,destination,parent);
                }
            }
        }
        return new ArrayList<>();

    }
    public static List<Integer> reconstructPath(int source,int destination,int[] parent){
        List<Integer> path = new ArrayList<>();
        for(int i=destination;i!=-1;i=parent[i]){
            path.add(i);
        }
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(17);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,3);
        g1.addEdge(1,4);
        g1.addEdge(1,5);
        g1.addEdge(2,6);
        g1.addEdge(2,7);
        g1.addEdge(2,8);
        g1.addEdge(8,9);
        g1.addEdge(7,10);
        g1.addEdge(7,11);
        g1.addEdge(6,12);
        g1.addEdge(5,13);
        g1.addEdge(4,14);
        g1.addEdge(3,15);
        g1.addEdge(3,16);
        g1.addEdge(15,16);
        g1.addEdge(14,16);
        g1.addEdge(6,16);
        g1.printGraph();
        System.out.println("Length of shortest path b/w 0 and 16 Graph G1 ?: "+findShortestPathLength(g1,0,16));
        System.out.print("Shortest path b/w 0 and 16 Graph G1 ?: ");
        System.out.print("Start: ");
        for(int vertex:findShortestPath(g1,0,16)){
            System.out.print(vertex+"-->");
        }
        System.out.println("End");
    }
}