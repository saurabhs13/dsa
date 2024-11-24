import java.util.*;
/**
 * This program implements DFS & BFS for graph using stack & queue respectively.
 */
public class GraphTraversal{

    public static List<Integer> dfsTraversal(GraphLinkedListImplementation g){
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[g.numberOfVertices];
        int source = 0;
        stack.push(source);
        while(!stack.isEmpty()){
            int current = stack.pop();
            result.add(current);
            visited[current] = true;
            List<Integer> adjacentNodes = g.adjacencyList[current];
            for(int i:adjacentNodes){
                if(!visited[i]){
                    stack.push(i);
                }
            }
        }
        return result;

    }
    public static List<Integer> bfsTraversal(GraphLinkedListImplementation g){
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[g.numberOfVertices];
        int source = 0;
        queue.offer(source);
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            visited[current] = true;
            List<Integer> adjacentNodes = g.adjacencyList[current];
            for(int i:adjacentNodes){
                if(!visited[i]){
                    queue.offer(i);
                }
            }
        }
        return result;

    }

    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(7);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,3);
        g1.addEdge(1,5);
        g1.addEdge(3,6);
        g1.addEdge(6,5);
        g1.addEdge(2,4);
        g1.printGraph();
        List<Integer> result = dfsTraversal(g1);
        System.out.print("DFS Start->");
        for(int i:result){
            System.out.print(i+"->");
        }
        System.out.println("DFS End");
        result = bfsTraversal(g1);
        System.out.print("BFS Start->");
        for(int i:result){
            System.out.print(i+"->");
        }
        System.out.println("BFS End");

    }
}