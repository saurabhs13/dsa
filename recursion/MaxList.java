import java.util.*;
public class MaxList{

    public static int getMaxElement(List<Integer> list,int lastIndex,int maxElement){

        if (lastIndex==0){
            return maxElement;
        }else if(list.get(lastIndex) > maxElement){
            maxElement = list.get(lastIndex);
            return getMaxElement(list,lastIndex-1,maxElement);
        }else{
            return getMaxElement(list,lastIndex-1,maxElement);
        }
        
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(333);
        list.add(1010);
        list.add(879);
        list.add(999);
        System.out.println(getMaxElement(list,list.size()-1,list.get(0)));
    }

}