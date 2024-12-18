
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Program to find the number of paths between two nodes
 * in a directed acyclic graph.
 */
public class CountPathsInDirectedGraph{
    public static int countPaths(GraphLinkedListImplementation g,int source, int destination){
        Deque<Integer> stack  = new ArrayDeque<>(g.numberOfVertices);
        stack.push(source);
        int pathCount = 0;
        while(!stack.isEmpty()){
            int element = stack.pop();
            for(int neighbor:g.adjacencyList[element]){
                if(neighbor==destination){
                    pathCount++;    
                }else{
                    stack.push(neighbor);
                }
                   
            }
        }
        return pathCount;
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(8);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,7);
        g.printGraph();
        System.out.println("Paths b/w 0 & 6: "+countPaths(g,0,6));
       
    }
}