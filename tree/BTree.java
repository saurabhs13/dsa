
import java.util.ArrayDeque;

public class BTree{
    private static class Node{
        int[] keys;
        Node[] children;
        int n;
        boolean isLeaf;

        Node(int order,boolean isLeaf){
            keys = new int[order*2-1];
            children = new Node[order*2];
            n = 0;
            this.isLeaf = isLeaf;
        }
    }
    Node root;
    int order;

    public BTree(int order){
        this.root = null;
        this.order = order;
    }

    /**
     * Method to insert key into BTree.
     */
    public void insert(int key){

        //Check if root is null, if yes create root and insert key into root.
        if(null == root){
            root = new Node(order,true);
            root.keys[0] = key;
            root.n = 1;
        }else{
            //Check if root is full
            if(root.n == order*2 -1){

                //split the root.
                Node newRoot = new Node(order,false);
                newRoot.children[0] = root;
                splitChild(newRoot,0,root);

                int i=0;
                if(newRoot.keys[i]<key){
                    i++;
                }
                insertNonFull(newRoot.children[i],key);
                root = newRoot; 
            }else{
                insertNonFull(root,key);
            }
        }
    }
    private void splitChild(Node parent,int childIndex,Node fullChild){

        //create new child
        Node newChild = new Node(order,fullChild.isLeaf);

        //Populate last t-1 entries from full child to new child
        for(int i=0;i<order-1;i++){
            newChild.keys[i] = fullChild.keys[order+i];
        }

        //update number of entries in new child & full child
        newChild.n = order-1;
       
    
        //Copy the children from order to 2*order -1 index from full child to new child
        if(!fullChild.isLeaf){
            for(int i=0;i<order;i++){
                newChild.children[i] = fullChild.children[order+i];
            }
        }

        fullChild.n = order-1;
        //Update parent's children pointers
       
        for(int j=parent.n;j>childIndex;j--){
            parent.children[j+1] = parent.children[j];
        }

        //Populate new child to childIndex +1 as it has values larger than median value
        parent.children[childIndex+1] = newChild;

        //Move all parent keys until childIndex by 1
        for(int i=parent.n-1;i>=childIndex;i--){
            parent.keys[i+1] = parent.keys[i];
        }

        //Move the median value to parent node
        parent.keys[childIndex] = fullChild.keys[order-1];
        parent.n++;
        
    }
    private void insertNonFull(Node node,int key){
        int  i = node.n-1;

        //Check if node is a leaf node
        if(node.isLeaf){

            //Navigate to the slot to insert the key so that monotonical order is maintained
            while(i>=0&&node.keys[i]>=key){
                node.keys[i+1] = node.keys[i];
                i--;
            }
            i++;
            node.keys[i] = key;
            node.n++;
        }else{

            while(i>=0&&node.keys[i]>=key){
                i--;
            }
            i++;
            if(node.children[i].n==2*order-1){

                splitChild(node, i, node.children[i]);

                //Find the correct child to insert the key
                if(node.keys[i]<key){
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }
    public static void printBTree(Node root){
        
        if(null == root){
            System.out.println("Tree is empty");
            return;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
    
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
    
                // Print the keys of the current node
                System.out.print("[");
                for (int j = 0; j < currentNode.n; j++) {
                    System.out.print(currentNode.keys[j]);
                    if (j < currentNode.n - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("] ");
    
                // Add children to the queue for the next level
                if (!currentNode.isLeaf) {
                    for (int j = 0; j <= currentNode.n; j++) {
                        if (currentNode.children[j] != null) {
                            queue.offer(currentNode.children[j]);
                        }
                    }
                }
            }
    
            // Move to the next level
            System.out.println();
        }
        
    }
    public static void main(String[] args){

        BTree btree = new BTree(2);
        btree.insert(10);
        btree.insert(20);
        btree.insert(30);
        btree.insert(40);
        btree.insert(50);
        btree.insert(35);
        btree.insert(45);
        btree.insert(55);
        btree.insert(15);
        btree.insert(25); 
        btree.insert(5);
        btree.insert(60);
        btree.insert(70);
        btree.insert(80);
        btree.insert(90);
        btree.insert(100);
        printBTree(btree.root);
    }

}