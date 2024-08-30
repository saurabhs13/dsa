import java.util.*;
public class GraphMapImplemention<T>{

    Map<T,List<T>> map = new HashMap<>();

    public void addVertex(T v){
        map.put(v,new LinkedList<T>());
    }

    public void addEdge(T source,T destination,boolean bidirectional){
        if(!map.containsKey(source)){
            addVertex(source);
        }
        if(map.containsKey(destination)){
            addVertex(destination);
        }
        
        List<T> sourceNeighbors = map.get(source);
        sourceNeighbors.add(destination);

        if(bidirectional){
            List<T> destNeighbors = map.get(destination);
            destNeighbors.add(source);
        }
          
    }

    public boolean hasVertex(T v){
        return map.containsKey(v);  
    }

    public int getEdgesCount(boolean bidirectional){

        int count = 0;
        for (T vertex : map.keySet()) {
            count += map.get(vertex).size();
        }
        if (bidirectional == true) {
            count = count / 2;
        }

        return count;
    }

    public int getVertexCount(){
        return map.keySet().size();
    }
}