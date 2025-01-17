
import java.util.ArrayList;
import java.util.List;

public class CustomHashtable{

    private static class HashEntry{
        String key;
        int value;
        HashEntry next;

        public HashEntry(String key, int value){
            this.key = key;
            this.value = value;
        }

    }
    List<HashEntry> hashtable;
    int slots;
    int size;
    private static double LOAD_FACTOR = 0.6;

    public CustomHashtable(int numberOfEntries){
        this.slots = getSlots(numberOfEntries);
        initializeTable();
        this.size = 0;
    }
    public CustomHashtable(){
        this.slots = 11;
        initializeTable();
        this.size = 0;
    }
    private int getSlots(int numberOfEntries){

        for(int i=numberOfEntries;i<Integer.MAX_VALUE;i++){
                if(isPrime(i)){
                    return i;
                }
        }
        return numberOfEntries;
    }
    private boolean isPrime(int n){
        if(n<=1) 
            return false;
        if(n<=3)
            return true;
        if(n%2 ==0 || n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i ==0 || n%(i+2)==0)
                return false;
        }
        return true;
    }
    private void initializeTable() {
        hashtable = new ArrayList<>(slots);
        for (int i = 0; i < slots; i++) {
            hashtable.add(null);
        }
    }

    private int getIndex(String key){

        return (key.hashCode() % this.slots);

    }
    public void insert(String key,int value){

        int index = getIndex(key);
        System.out.println(key+" is "+" at index = "+index);
        HashEntry head = hashtable.get(index);
        HashEntry newEntry = new HashEntry(key,value);
        newEntry.next = head;
        hashtable.set(index,newEntry);
        size++;

        if((double)(size/slots) >= LOAD_FACTOR ){

            resize();
        }
    }
    private void resize() {
        List<HashEntry> oldTable = hashtable;
        slots = getSlots(2 * slots);
        initializeTable();
        size = 0;

        for (HashEntry head : oldTable) {
            while (head != null) {
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }
    public int search(String key){

        int index = getIndex(key);
        HashEntry current = hashtable.get(index);

        while(current !=null){
            if(current.key.equalsIgnoreCase(key)){
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }
    public boolean delete(String key){
        int index = getIndex(key);

        HashEntry prev = null;
        HashEntry current = hashtable.get(index);
        
        while(current !=null){

            if(current.key.equalsIgnoreCase(key)){
                if(null != prev){
                    prev.next = current.next;
                }else{
                    hashtable.set(index,current.next);
                }
                size--;
                return true;   

            }
            prev = current;    
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {

        CustomHashtable hashtable = new CustomHashtable();
        hashtable.insert("Apple",5);
        hashtable.insert("Ball",4);
        hashtable.insert("Cat",3);
        hashtable.insert("Bat",3);
        hashtable.insert("Sun",3);
        hashtable.insert("Moon",4);
        hashtable.insert("Eratosthenes",12);
        System.out.println(hashtable.search("Eratosthenes"));
    }
}