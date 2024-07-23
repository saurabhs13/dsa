public class PairWithTargetSum{

    public static int[] findPairWithSumS(int[] arr,int s){
        int startPointer = 0;
        int endPointer = arr.length -1;
        while(startPointer<endPointer){
            if(s > (arr[startPointer] +arr[endPointer])){
                startPointer++;
            }else if(s < (arr[startPointer] +arr[endPointer])){
                endPointer--;
            }else{
                return new int[]{startPointer,endPointer};
               
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        
        int[] result =findPairWithSumS(new int[]{1,3,4,5,6,7,8,10},12);
        for(int i:result){
            System.out.println(i);
        }
    }
}