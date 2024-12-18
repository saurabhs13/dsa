
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Program to print connected components in an undirected graph.
 */
public class PrintConnectedComponents{

    public static void printConnnectedComponents(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        Deque<Integer> stack =  new ArrayDeque<>(vertices);
        int connectedComponentCount = 0;
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.err.println("");
                connectedComponentCount++;
                System.out.print("Connected Component "+connectedComponentCount+": -->");
                stack.push(i);
                visited[i] = true;
                while(!stack.isEmpty()){
                    int currentVertex = stack.pop();
                    System.out.print(currentVertex);
                    for(int neighbor:g.adjacencyList[currentVertex]){
                        if(!visited[neighbor]){
                            stack.push(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
        System.out.println("");
        
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(7);
        g1.addEdge(0,1);
        g1.addEdge(1,0);
        g1.addEdge(1,2);
        g1.addEdge(2,1);
        g1.addEdge(3,4);
        g1.addEdge(4,3);
        g1.addEdge(5,3);
        g1.addEdge(3,5);
        g1.addEdge(5,6);
        g1.addEdge(6,5);
        g1.addEdge(3,6);
        g1.addEdge(6,3);
        g1.printGraph();
        printConnnectedComponents(g1);
    }

}