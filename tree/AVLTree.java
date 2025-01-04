
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class AVLNode {
     int value, height;
     AVLNode left, right;

    public AVLNode(int value) {
        this.value = value;
    }

}

public class AVLTree{

    AVLNode root;

    // Helper method to get the height of a node
    private static int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Helper method to calculate the balance factor of a node
    public static int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private static AVLNode getNewNode(int value){
        AVLNode node = new AVLNode(value);
        return node;
    }
    public AVLNode insert(int value){
        this.root = insert(this.root,value);
        return this.root;
    }
    public AVLNode remove(int value){
        this.root = remove(this.root,value);
        return this.root;
    }
    private AVLNode insert(AVLNode rootNode,int value){
        if(null==rootNode)
            return getNewNode(value);
        if(value>rootNode.value){
            rootNode.right = insert(rootNode.right,value);
        }else{
            rootNode.left = insert(rootNode.left,value);
        }
        return rebalance(rootNode);
    }
    private AVLNode remove(AVLNode rootNode,int value){
        if(null==rootNode)
            return null;
        if(value>rootNode.value){
            rootNode.right = remove(rootNode.right,value);
        }else if(value<rootNode.value){
            rootNode.left = remove(rootNode.left,value);
        }else{
            if(rootNode.left==null && rootNode.right==null){
                return null;
            }else if(rootNode.left ==null && rootNode.right!=null){
                return rootNode.right;
            }else if(rootNode.left !=null && rootNode.right ==null){
                return rootNode.left;
            }else{
                AVLNode minNode = findMinNode(rootNode.right);
                rootNode.value = minNode.value;
                remove(rootNode.right,minNode.value);
            }
        }
        return rebalance(rootNode);
    }
    public AVLNode rebalance(AVLNode node){ 
        updateHeight(node);
        if(getBalance(node)>1 && getBalance(node.left)>=0){
            node =  rightRotate(node);
        }else if(getBalance(node)<-1 && getBalance(node.right)<=0){
            node =  leftRotate(node);
        }else if(getBalance(node)>1&&getBalance(node.left)<0){
           node.left = leftRotate(node.left);
           node = rightRotate(node);
        }else if(getBalance(node)<-1 && getBalance(node.right)>0){
            node.right = rightRotate(node.right);
            node =  leftRotate(node);
        }
        return node;
    }
    /**
     * Perform left rotation when balance factor for a node is less than -1.
     * i.e. the node is right heavy.
     */
    private AVLNode leftRotate(AVLNode node){
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        /**
         * First update height of node and then newRoot
         * as height of node affects the height of newRoot.
         */
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }
     /**
     * Perform right rotation when balance factor for a node is more than +1.
     * i.e. the node is left heavy..
     */
    private AVLNode rightRotate(AVLNode node){
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        /**
         * First update height of node and then newRoot
         * as height of node affects the height of newRoot.
         */
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }
    private AVLNode findMinNode(AVLNode rootNode){

        AVLNode current  = rootNode;
        while(current !=null && current.left!=null){
            current = current.left;
        }
        return current;
    }
    public static void inOrderTraversal(AVLNode root){
        if(null == root){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println("Value = "+ root.value+" Height = "+root.height+" Balance Factor = "+getBalance(root));
        inOrderTraversal(root.right);
    }
    public static void printAVLTree(AVLNode root){
        ArrayDeque<AVLNode> queue = new ArrayDeque<>();
        Map<Integer,Integer> childParentMap = new HashMap<>();
        queue.offer(root);
        childParentMap.put(root.value,-1); 
        while(!queue.isEmpty()){
            AVLNode node = queue.poll();
            System.out.println("Value = "+ node.value+" Parent = "+childParentMap.get(node.value)+" Height = "+node.height+" Balance Factor = "+getBalance(node));
            if(node.left!=null){
                childParentMap.put(node.left.value,node.value);
                queue.offer(node.left);
            }
            if(node.right !=null){
              childParentMap.put(node.right.value,node.value);
              queue.offer(node.right);
            }
               
        } 
        System.out.println("");
      
    }
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(20);
        avlTree.insert(18);
        avlTree.insert(22);
        avlTree.insert(16);
        avlTree.insert(15);
        avlTree.insert(17);
        avlTree.insert(19);
        avlTree.insert(21);
        avlTree.insert(24);
        avlTree.insert(25);
        printAVLTree(avlTree.root);
        inOrderTraversal(avlTree.root);
    }
}