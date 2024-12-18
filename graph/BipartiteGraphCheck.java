
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Program to check if an undirected graph is bipartite.
 */
public class BipartiteGraphCheck{
    public static boolean isBipartite(GraphLinkedListImplementation g){

        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        boolean[] color  = new boolean[vertices];
        Queue<Integer> queue = new ArrayDeque<>(vertices);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int parent = queue.poll();
                    color[parent] = true;
                    for(int child:g.adjacencyList[parent]){
                        if(!visited[child]){
                            color[child] = !color[parent];
                            visited[child] = true;
                            queue.add(child);
                        }
                    }
                }
            }
        }

    }
}