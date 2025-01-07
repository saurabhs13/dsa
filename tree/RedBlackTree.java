
import java.util.ArrayDeque;

public class RedBlackTree{

    static private class Node{
        int data;
        boolean isRed;
        Node left;
        Node right;
        Node parent;

        Node(int data){
            this.data = data;
            this.isRed = true;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    Node root;

    public void insert(int data){
        Node newNode = new Node(data);
        root = insert(root,newNode);
        fixInsertion(newNode);

    }
    private Node insert(Node root,Node newNode){
        if(null == root)
            return newNode;
        if(newNode.data>root.data){
            root.right = insert(root.right,newNode);
            root.right.parent = root;
        }else{
            root.left = insert(root.left,newNode);
            root.left.parent = root;
        }
        return root;
    }
    private void leftRotate(Node node){

        Node newRoot  = node.right;
        node.right = newRoot.left;
        
        if (newRoot.left != null) {
            newRoot.left.parent = node;
        }
        newRoot.parent = node.parent;

        if (node.parent == null) {
            root = newRoot;
        } else if (node == node.parent.left) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }

        newRoot.left = node;
        node.parent = newRoot;

    }
    private void rightRotate(Node node){

        Node newRoot  = node.left;
        node.left = newRoot.right;
        
        if (newRoot.right != null) {
            newRoot.right.parent = node;
        }
        newRoot.parent = node.parent;

        if (node.parent == null) {
            root = newRoot;
        } else if (node == node.parent.left) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }

        newRoot.right = node;
        node.parent = newRoot;

    }
    private void fixInsertion(Node node){

        while(node !=root && node.parent.isRed){
            Node parent = node.parent;
            Node grandParent = parent.parent;

         
            if(parent == grandParent.left){
                //case when parent is the left child of grandparent
                Node uncle = grandParent.right;

               
                if(uncle!=null&&uncle.isRed){
                //case when parent and uncle are red
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandParent.isRed = true;
                    node = grandParent;
                }else{
                //case when uncle is black or null (as null is also black)

                    if(node == parent.right){
                    //parent is left child of grandparent and node is right child of parent
                        node = parent;
                        leftRotate(node);
                    }
                    parent.isRed = false;
                    grandParent.isRed = true;
                    rightRotate(grandParent);
                }
            }else{
                //case when parent is the right child of grandparent
                Node uncle = grandParent.left;

                if(uncle!=null&&uncle.isRed){
                    //case when parent and uncle are red
                        parent.isRed = false;
                        uncle.isRed = false;
                        grandParent.isRed = true;
                        node = grandParent;
                }else{
                    //case when uncle is black or null (as null is also black)

                    if(node == parent.left){
                        //parent is  grandparent.left --> parent and parent.right --> node
                            node = parent;
                            rightRotate(node);
                        //right rotation on parent converts this case to parent.left --> node
                    }
                    //case when grandparent.left --> parent and parent.left --> node
                    parent.isRed = false;
                    grandParent.isRed  = true;
                    leftRotate(grandParent);
                }
            }
        }
        //If due to above adjustments root becomes red, change it back to black
        root.isRed = false;
    }
    public static void printRBTree(Node root){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.parent!=null){
                System.out.println("Node Data = "+ node.data+" Parent Data= "+node.parent.data+" Node Red = "+node.isRed+" Parent Red = "+node.parent.isRed);
            }else{
                System.out.println("Node Data = "+ node.data+" Node Red = "+node.isRed);
            }
         
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right !=null){
                
                queue.offer(node.right);
            }
               
        } 
        System.out.println("");
      
    }
    public static void main(String[] args){

        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(18);
        rbTree.insert(22);
        rbTree.insert(16);
        rbTree.insert(15);
        rbTree.insert(17);
        rbTree.insert(19);
        rbTree.insert(21);
        rbTree.insert(24);
        rbTree.insert(25);
        printRBTree(rbTree.root);
    }
}