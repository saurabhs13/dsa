
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UndirectedGraphEdgeClassification{
    public static void dfs(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        List<Integer[]> treeEdge = new ArrayList<>();
        List<Integer[]> backEdge = new ArrayList<>();
        List<Integer> dfsResult = new ArrayList<>(vertices);
        Arrays.fill(parent,-1);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                System.out.println("DFS Visit");
                dfsVisit(g,i,visited,parent,treeEdge,backEdge,dfsResult);
                System.err.println("");
            }
        }
        for(int i=0;i<vertices;i++){
            System.out.println("Parent of "+i+" is"+parent[i]);
        }
        System.out.println("DFS Exploration");
        for(int node:dfsResult){
            System.out.print(node+" ");
        }
        System.out.println("");
        System.out.println("Tree Edges");
        for(Integer[] arr:treeEdge){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
        System.out.println("");
        System.out.println("Back Edges");
        for(Integer[] arr:backEdge){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
    }
    public static void dfsVisit(GraphLinkedListImplementation g,int node,boolean[] visited,
    int[] parent,List<Integer[]> treeEdge,List<Integer[]> backEdge,List<Integer> dfsResult){
        visited[node] = true;
        dfsResult.add(node);
        System.out.println("Exploration of node = "+node+" started");
        for(int child:g.adjacencyList[node]){
            if(!visited[child]){
                parent[child] = node;
                treeEdge.add(new Integer[]{node,child});
                dfsVisit(g, child, visited,parent,treeEdge,backEdge,dfsResult);
            }else if(child !=parent[node]){
                backEdge.add(new Integer[]{node,child});
            }
        }
        System.out.println("Exploration of node = "+node+" finished");
    }
    public static void main(String[] args) {
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(8);
        g.addEdge(0,1);
        g.addEdge(1,0);
        g.addEdge(0,5);
        g.addEdge(5,0);
        g.addEdge(1,2);
        g.addEdge(2,1);
        g.addEdge(1,3);
        g.addEdge(3,1);
        g.addEdge(2,4);
        g.addEdge(4,2);
        g.addEdge(3,7);
        g.addEdge(7,3);
        g.addEdge(4,5);
        g.addEdge(5,4);
        g.addEdge(6,5);
        g.addEdge(5,6);
        dfs(g);
    }
}