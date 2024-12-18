
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Program to topologically sort a graph.
 */
public class DirectedGraphTopologicalSort{

    public static void topologicalSort(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                topologicalSort(g,i,visited,stack);
            }
        }
        System.out.println("Topologically Sorted DAG");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    private static void topologicalSort(GraphLinkedListImplementation g, int node, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;
        for(int child:g.adjacencyList[node]){
            if(!visited[child]){
                topologicalSort(g,child,visited,stack);
            }
            
        }
        stack.push(node);
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(7);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,6);
        g.addEdge(3,5);
        g.addEdge(6,4);
      //  g.addEdge(6,1);
        g.printGraph();
        System.out.println("");
        topologicalSort(g);
    }

   
}