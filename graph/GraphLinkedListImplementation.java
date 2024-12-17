import java.util.LinkedList;
import java.util.List;

public class GraphLinkedListImplementation{
    public List<Integer>[] adjacencyList;
    public int numberOfVertices;

    public GraphLinkedListImplementation(int vertices){
        this.numberOfVertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source,int destination){
        if (source < numberOfVertices && destination < numberOfVertices) {
            this.adjacencyList[source].addLast(destination);
        }
    }
    public GraphLinkedListImplementation getTranspose(){
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(this.numberOfVertices);
        for(int i=0;i<numberOfVertices;i++){
            for(int neighbor:this.adjacencyList[i]){
                g.addEdge(neighbor, i);
            }
        }
        return g;
    }
    public void printGraph(){
        for(int i=0;i<this.numberOfVertices;i++){
            System.out.print(i+"->[");
            for(int neighbor:this.adjacencyList[i]){
                System.out.print(neighbor+",");
            }
            System.out.println("NULL]");
        }
    }
    public static void main(String[] args){
        GraphLinkedListImplementation g = new GraphLinkedListImplementation(5);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(1,4);
        g.printGraph();
        GraphLinkedListImplementation gt = g.getTranspose();
        gt.printGraph();
    }
}