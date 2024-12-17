
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Program to detetect Cycle in a directed graph.
 */
public class DirectedGraphCycleDetection{
    public static boolean detectCycle(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(detectCycleRecursive(g,i,visited,recursionStack)){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycleRecursive(GraphLinkedListImplementation g,int node,boolean[] visited,boolean[] recursionStack){
        if(recursionStack[node]){
            return true;
        }
        if(visited[node]){
            return false;
        }
        recursionStack[node] = true;
        visited[node] = true;
        for(int neighbor:g.adjacencyList[node]){
            if(detectCycleRecursive(g,neighbor,visited,recursionStack)){
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
    public static boolean detectCycleIterative(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        boolean[] currentPath = new boolean[vertices];
        Deque<Integer> stack = new ArrayDeque<>(vertices);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                stack.push(i);
                currentPath[i] = true;
                while(!stack.isEmpty()){
                    int currentVertex = stack.peek();
                    boolean allneighborsVisited = true;
                    for(int neighbor:g.adjacencyList[currentVertex]){
                        if(currentPath[neighbor]){
                            return true;
                        }
                        if(!visited[neighbor]){
                            currentPath[neighbor] = true;
                            allneighborsVisited = false;
                            stack.push(neighbor);
                            break;
                        }

                    }
                    if(allneighborsVisited){
                        visited[currentVertex] = true;
                        currentPath[currentVertex] = false;
                        stack.pop();
                    }

                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(7);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,6);
        g.addEdge(3,5);
        g.addEdge(6,4);
        g.addEdge(6,1);
        g.printGraph();
        System.out.println("");
        System.err.println("Cycle Exists:"+ detectCycle(g));
        System.err.println("Cycle Exists:"+ detectCycleIterative(g));
    }
}