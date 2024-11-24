import java.util.*;
public class GraphRecursiveDFS{

    public static List<Integer> dfs(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<Integer>(vertices);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.out.println("Visit called for = "+i);
                visit(i,visited,result,g);
            }
        }
        return result;
    }
    public static void visit(int i,boolean[] visited,List<Integer> result,GraphLinkedListImplementation g){
        result.add(i);
        visited[i] = true;
        for(int neighbor:g.adjacencyList[i]){
            if(!visited[neighbor]){
                visit(neighbor,visited,result,g);
            }
            
        }
        System.out.println("Rec Stack ended for vertex = "+i);
    }
    public static boolean detectCycle(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.out.println("Visit called for = "+i);
                if(detectCycle(i,visited,recursionStack,g)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean detectCycle(int vertex,boolean[] visited,boolean[] recursionStack,GraphLinkedListImplementation g){
        if(recursionStack[vertex]){
            return true;
        }
        if(visited[vertex]){
            return false;
        }
        visited[vertex] = true;
        recursionStack[vertex] = true;
        for(int i:g.adjacencyList[vertex]){
            if(detectCycle(i,visited,recursionStack,g)){
                return true;
            }
        }
        recursionStack[vertex] = false;
        return false;
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g1 = new GraphLinkedListImplementation(8);
        g1.addEdge(0,2);
        g1.addEdge(0,4);
        g1.addEdge(2,1);
        g1.addEdge(2,3);
        g1.addEdge(1,5);
        g1.addEdge(5,6);
        g1.addEdge(4,7);
        g1.addEdge(7,6);
        g1.printGraph();
        List<Integer> result = dfs(g1);
        System.out.print("Start->");
        for(int i:result){
            System.out.print(i+"->");
        }
        System.out.println("End");
        GraphLinkedListImplementation g2 = new GraphLinkedListImplementation(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        //g2.addEdge(2,0);
        System.out.print("Cycle exists in Graph G2: "+detectCycle(g2));
    }
}