import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class UndirectedGraphCutVerticesDetection{
    private static int tick = 0;
    public static int getCurrentTimestamp(){
        return ++tick;
    }
    public static List<Integer> findCutVertices(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        //Array to record discovery time for each vertex
        int[] disc = new int[vertices];
        //Array to record vertex with lowest discovery time reachable from current vertex
        int[] low = new int[vertices];
        Arrays.fill(parent,-1);
        List<Integer> cutVertices = new ArrayList<>(vertices-2);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                deepDive(g,i,visited,cutVertices,parent,disc,low);
            }
        }
        return cutVertices;
    }
    private static void deepDive(GraphLinkedListImplementation g, int node,
    boolean[] visited,List<Integer> cutVertices,int[] parent,int[] disc,int[] low){
        visited[node] = true;
        disc[node] = getCurrentTimestamp();
        low[node] = disc[node];
        int childrenCount = 0;
        for(int neighbor:g.adjacencyList[node]){
            if(!visited[neighbor]){
                childrenCount++;
                parent[neighbor] = node;
                deepDive(g, neighbor, visited, cutVertices, parent,disc,low);
                /**
                 * Below condition is checking that low[neighbor] i.e. lowest discovery time 
                 * reachable by neighbor is greater or equal to discovery time of node 
                 * and parent[node] is -1 checks that there are vertices that were disciovered before node 
                 * i.e. it's not a root vertex for this DFS.So essentially it means that neighbor can only 
                 * access the vertices discovered before node via node. Hence,removing node will disconnect
                 * the graph i.e. node is a cut vertex.
                 */
                if(low[neighbor]>=disc[node]&&parent[node]!=-1){
                    cutVertices.add(node);
                }
                /**
                 * This ensures that low of "node" accounts for any back edges that "neighbor" or it's descendants might have
                 * to the ancestor of "node" as all that will affect the lowest discovery reachable for node via it's child.
                 * This is done after recursively visiting the neighbor node i.e. child node of node.
                 */
                low[node] = Math.min(low[node],low[neighbor]);
            }else if(parent[node]!=neighbor){
                /**
                 * Node has encountered a backedge to a previously visited vertex neighbor which is not it's parent.
                 * So this way low[node] accounts for all direct back edges to ancestors of node.
                 */
                low[node] = Math.min(low[node],disc[neighbor]);
            }
        }
        /**
         * This condition checks if node is a root vertex for this DFS and has 2 or more children.
         * In this case it's a cut vertex as removing it will divide the graph into two disconnected 
         * components.
         */
        if(parent[node]==-1&&childrenCount>1){
            cutVertices.add(node);
        }
    }  
    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(4);
        g1.addEdge(0,1);
        //g1.addEdge(0,2);
        g1.addEdge(1,0);
        g1.addEdge(1,2);
        g1.addEdge(2,1);
       // g1.addEdge(2,0);
        g1.addEdge(2,3);
        g1.addEdge(3,2);
        g1.printGraph();
        System.out.println("Cut Vertices:");
        for(int vertex:findCutVertices(g1)){
            System.out.println(vertex);
        }
    } 
}