

/**
 * Program to implement max heap.
 */
public class MaxHeap{
    
    int[] arr;
    int lastElementIndex;

    public MaxHeap(int capacity){
        this.arr = new int[capacity];
        lastElementIndex = -1;
    }

    public boolean insert(int element){
        if(lastElementIndex<arr.length-1){
            arr[++lastElementIndex] = element;
            int childIndex = lastElementIndex;
            /**
             * Keep comparing with the parent node and if it's 
             * greater than the parent node swap it with parent node
             * to satisfy the max heap property.
             */
            while(childIndex>0){
                int parentIndex  = getParentIndex(childIndex);
                if(arr[parentIndex]<arr[childIndex]){
                    swap(this.arr,parentIndex,childIndex);
                    childIndex = parentIndex;
                }else{
                    break;
                }
               
            }
            return true;
        }else{
            System.out.println("Heap is full, element can't be inserted");
            return false;
        }
    }
    /**
     * Delete method always deletes the largest element i.e. root element 
     * for a max heap.Post deletion the last element in the heap is moved to
     * the root and then it is compared top-down with it's left & right child 
     * until heap property is maintained again.
     * Note: In insert the comparison is bottom-up but in delete it's top-down.
     */
    public boolean delete(){
        if(lastElementIndex>=0){
            if(0==lastElementIndex){
                lastElementIndex--;
                return true;
            }
            swap(this.arr,0,lastElementIndex);
            lastElementIndex--;
            int index = 0;
            int largest = index;
            while(index<lastElementIndex){
                int leftChildIndex = 2*index +1;
                int rightChildIndex = 2*index +2;
                if(leftChildIndex<=lastElementIndex && arr[leftChildIndex]>arr[largest]){
                    largest = leftChildIndex;
                }
                if(rightChildIndex<=lastElementIndex && arr[rightChildIndex]>arr[largest]){
                    largest = rightChildIndex;
                }
                if(index !=largest){
                    swap(this.arr,index,largest);
                    index = largest;
                }else{
                    break;
                }
               
            }

        }else{
            return false;
        }
        return true;
    }
    private static void swap(int[]arr,int parentIndex,int childIndex){
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[childIndex];
        arr[childIndex] = temp;
    }   
    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }
    public static void printHeap(int[] arr,int lastElementIndex){
        System.out.print("Heap Values Start: ");
        for(int i=0;i<=lastElementIndex;i++){
            System.out.print(arr[i]+"-->");
        }
        System.out.println("Heap Values End");
    }
    private static void maxHeapify(int[] arr,int heapSize,int index){
        int largest = index;
        /**
         * This is done is a loop because certain parent nodes are also
         * children of other nodes and hence when their value changes 
         * a re-comparison with their children is required to maintain max heap property.
         * This is the reason the loop in calling method is starting from last parent node index
         * instead of first so that heap is formed in bottom up manner and parent of parent are
         * processed last.
         */
        while(largest<heapSize/2){
            int leftChildIndex = 2*index + 1;
            int rightChildIndex = 2*index +2;

            if(leftChildIndex<heapSize&&arr[leftChildIndex]>arr[largest]){
                largest = leftChildIndex;
            }
            if(rightChildIndex<heapSize&&arr[rightChildIndex]>arr[largest]){
                largest = rightChildIndex;
            }
            if(largest!=index){
                swap(arr,largest,index);
                index = largest;
            }else{
                break;
            }
        }
    }
    public static void convertArrayToMaxHeap(int[] arr,int heapSize){

        for(int i=(heapSize-1)/2;i>=0;i--){

            maxHeapify(arr,heapSize,i);
        }
        
    }
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(40);
        printHeap(maxHeap.arr,maxHeap.lastElementIndex);
        int arr[] = {8,10,20,11,5,6,17,21,33,15,32};
        convertArrayToMaxHeap(arr, arr.length);
        printHeap(arr, arr.length-1);
        maxHeap.delete();
        printHeap(maxHeap.arr,maxHeap.lastElementIndex);
    }
}