
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Program to classify edges in a directed graph using DFS.
 */
public class DirectedGraphEdgeClassification{
    private static int tick = 0;
    public static int timestamp(){
        return ++tick;
    }
    public static void dfs(GraphLinkedListImplementation g){
        int vertices = g.numberOfVertices;
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] startTime = new int[vertices];
        int[] finishTime = new int[vertices];
        Arrays.fill(startTime,-1);
        Arrays.fill(finishTime,-1);
        List<Integer> dfsResult = new ArrayList<>(vertices);
        List<Integer[]> treeEdges = new ArrayList<>();
        List<Integer[]> backEdges = new ArrayList<>();
        List<Integer[]> forwardEdges = new ArrayList<>();
        List<Integer[]> crossEdges = new ArrayList<>();
        Arrays.fill(parent,-1);
        for(int i=0;i<vertices;i++){
            if(!visited[i]){
                dfsVisit(g,i,visited,parent,dfsResult,startTime,finishTime,
                treeEdges,backEdges,forwardEdges,crossEdges);
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
        System.out.println("Relative Start & Finish Times for nodes");
        for(int i=0;i<vertices;i++){
            System.out.println("Node = "+i+" Start time = "+startTime[i]+" & Finish Time = "+finishTime[i]);
        }
        System.out.println("");
        System.out.println("Tree Edges");
        for(Integer[] arr:treeEdges){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
        System.out.println("");
        System.out.println("Back Edges");
        for(Integer[] arr:backEdges){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Forward Edges");
        for(Integer[] arr:forwardEdges){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
        System.out.println("");
        System.out.println("Cross Edges");
        for(Integer[] arr:crossEdges){
            System.out.print("("+arr[0]+" , "+arr[1]+") ");
        }
        System.out.println("");
    }
    public static void dfsVisit(GraphLinkedListImplementation g,int node,boolean[] visited,
    int[] parent,List<Integer> dfsResult,int[] startTime,int[] finishTime,List<Integer[]> treeEdges,
    List<Integer[]> backEdges,List<Integer[]> forwardEdges,List<Integer[]> crossEdges){
        visited[node] = true;
        dfsResult.add(node);
        startTime[node] = timestamp();
        for(int child:g.adjacencyList[node]){
            if(!visited[child]){
                parent[child] = node;
                treeEdges.add(new Integer[]{node,child});
                dfsVisit(g, child, visited,parent,dfsResult,startTime,finishTime,
                treeEdges,backEdges,forwardEdges,crossEdges);
            }else if(finishTime[child]==-1){
                backEdges.add(new Integer[]{node,child});
            }else if(startTime[node]<startTime[child]){
                forwardEdges.add(new Integer[]{node,child});
            }else{
                crossEdges.add(new Integer[]{node,child});
            }
        }
        finishTime[node] = timestamp();
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
        g.addEdge(6,1);
        g.printGraph();
        System.out.println("");
        dfs(g);
    }
}