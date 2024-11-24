import java.util.*;
/**
 * Program to find shortest path from source,destination.
 */
public class UndirectedGraphShortestPathDetection{
    /**
     *  Finds the shortest path between two vertices in an undirected graph.
     */
    public static List<Integer> findShortestPath(GraphLinkedListImplementation g,int source,int destination){
        int vertices = g.numberOfVertices;
        Queue <List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        path.add(source);
        queue.offer(path);
        visited[source] = true;
        while(!queue.isEmpty()){
            List<Integer> currentPath  = queue.poll();
            int lastNode = currentPath.get(currentPath.size()-1);
            if(lastNode==destination){
                return currentPath;
            }

            List<Integer> adjacentNodes = g.adjacencyList[lastNode];
            for(int node:adjacentNodes){
                if(!visited[node]){
                   visited[node] = true;
                   List<Integer> newPath = new ArrayList<>(currentPath);
                   newPath.add(node);
                   queue.offer(newPath);
                }
            }
        }
        return new ArrayList<>();
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(6);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,0);
        g1.addEdge(1,2);
        g1.addEdge(1,5);
        g1.addEdge(2,1);
        g1.addEdge(2,0);
        g1.addEdge(2,3);
        g1.addEdge(3,2);
        g1.addEdge(3,4);
        g1.addEdge(4,3);
        g1.addEdge(4,5);
        g1.addEdge(5,4);
        g1.addEdge(5,1);
        g1.printGraph();
        List<Integer> result = findShortestPath(g1,0,3);
        System.out.print("Result Start->");
        for(int i:result){
            System.out.print(i+"->");
        }
        System.out.println("Result End");
        result = findShortestPath(g1,0,5);
        System.out.print("Result Start->");
        for(int i:result){
            System.out.print(i+"->");
        }
        System.out.println("Result End");

    }
}