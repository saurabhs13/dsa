
import java.util.LinkedList;

public class BinarySearchTreeNew{
    Node root;

    public class Node{
        int data;
        Node left;
        Node right;
    }
    public Node getNewNode(int data){
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    } 
    public Node add(Node root,int data){
        if(null == root){
            root = getNewNode(data);
            return root;
        }else{
           if(data<=root.data){
                root.left = add(root.left,data);
           }else{
                root.right = add(root.right,data);
           }
        } 
        return root;
    }
    public void preOrderTraversal(Node root){
        if(null == root)
            return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void inOrderTraversal(Node root){
        if(null == root)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(null == root)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public void levelOrderTraversal(Node root){
        LinkedList<Node> queue = new LinkedList<>();
    }
    
    public static void main(String[] args) {
        BinarySearchTreeNew bst = new BinarySearchTreeNew();
         bst.root = bst.add(bst.root, 8);
         bst.root = bst.add(bst.root, 5);
         bst.root = bst.add(bst.root, 12);
         bst.root = bst.add(bst.root, 10);
         bst.root = bst.add(bst.root, 6);
         System.out.println(bst.root.data);
         bst.preOrderTraversal(bst.root);
         bst.inOrderTraversal(bst.root);
         bst.postOrderTraversal(bst.root);
    }
}