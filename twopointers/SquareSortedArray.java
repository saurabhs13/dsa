
/**
 * Program to square a sorted array and return squared sorted array.
 */
public class SquareSortedArray{

    public static int[] sortedSquaredArray(int[] arr){
        int[] resultArr = new int[arr.length];
        int highestValueIndex = resultArr.length-1;
        int startPointer = 0;
        int endPointer = arr.length-1;
        while(startPointer<endPointer){
            int startSquare = arr[startPointer] * arr[startPointer];
            int endSquare = arr[endPointer] * arr[endPointer];
            if(startSquare >= endSquare){
                resultArr[highestValueIndex--] = startSquare;
                startPointer++;
            }else{
                resultArr[highestValueIndex--] = endSquare;
                endPointer--;
            }
        }
        return resultArr;
    }
    public static void main(String[] args){
        int[] resultArr = sortedSquaredArray(new int[]{-3,-2,-1,0,5,6,10});
        for(int element:resultArr){
            System.out.print(element+" ");
        }
        System.out.println("");
    }

}