
import java.util.Arrays;
import java.util.LinkedList;

public class MergeOverlappingIntervals {
    
    public static int[][] mergeIntervals(int[][] intervals){
        LinkedList<int[]> output = new LinkedList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        output.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=output.getLast()[1]){
                if(intervals[i][1]>output.getLast()[1])
                    output.getLast()[1] = intervals[i][1];
            }else{
                output.addLast(intervals[i]);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
    public static void main(String[] args) {
        //Insert test code here
    }
}
