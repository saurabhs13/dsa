import java.util.*;
public class GraphTest{

    public static void main(String[] args){
        Map<String,Integer> vertexPostionMap = new HashMap<String,Integer>();
        vertexPostionMap.put("Indore",0);
        vertexPostionMap.put("Ujjain",1);
        vertexPostionMap.put("Bhopal",2);
        vertexPostionMap.put("Nagpur",3);
        vertexPostionMap.put("Hyderabad",4);
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(10,vertexPostionMap);
        graph.addEdge("Indore","Ujjain",60,false);
        graph.addEdge("Indore","Bhopal",200,false);
        graph.addEdge("Indore","Nagpur",450,false);
        graph.addEdge("Bhopal","Nagpur",350,false);
        graph.addEdge("Ujjain","Nagpur",490,false);
        graph.addEdge("Nagpur","Hyderabad",500,false);

        System.out.println(graph.edgeExists("Indore","Bhopal"));
        System.out.println(graph.edgeExists("Indore","Hyderabad"));
        graph.printAdjacentVertices("Indore");
    }
}