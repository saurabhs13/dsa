import java.util.*;
public class BinarySearchTree{
    Node rootNode;
    int gstValue = 0;
    class Node{
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
    public Node addNode(Node rootNode,int data){
        if(null == rootNode){
            return getNewNode(data);
        }
        if(data <= rootNode.data){
         rootNode.left =  addNode(rootNode.left,data);
        }else{
          rootNode.right = addNode(rootNode.right,data);
        }
        return rootNode;
    }
    public Node removeNode(Node rootNode, int data){
        if(null == rootNode)
            return null;
        if(data>rootNode.data){
            rootNode.right = removeNode(rootNode.right, data);
        }else if(data<rootNode.data){
            rootNode.left = removeNode(rootNode.left, data);
        }else{
            if(rootNode.left==null&&rootNode.right==null){
                return null;
            }else if(rootNode.left!=null && rootNode.right ==null){
                return rootNode.left;
            }else if(rootNode.right!=null&& rootNode.left ==null){
                return rootNode.right;
            }else{
                Node minNode = findMin(rootNode.right);
                rootNode.data = minNode.data;
                rootNode.right = removeNode(rootNode.right, minNode.data);
            }
        }
        return rootNode;
    }
    public static int findHeight(Node rootNode){
        if(null == rootNode){
            return -1;
        }
       return Math.max(findHeight(rootNode.left),findHeight(rootNode.right)) + 1;
    }
    public static int findMax(Node rootNode){
        if(rootNode == null){
            return -1;
        }
        while(rootNode.right != null){
            rootNode = rootNode.right;
        }
        return rootNode.data;
    }
    public static Node findMin(Node rootNode){
        if(rootNode == null){
            return null;
        }
        while(rootNode.left != null){
            rootNode = rootNode.left;
        }
        return rootNode;
    }
    public static void  preOrderTraversal(Node rootNode){
        if(null == rootNode){
            return;
          }else{
            System.out.print(rootNode.data+" "); 
          }
        preOrderTraversal(rootNode.left);
        preOrderTraversal(rootNode.right);
      
    }
    public static void  inOrderTraversal(Node rootNode){
        if(null == rootNode){
            return;
          }
        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data+" ");
        inOrderTraversal(rootNode.right);
      
    }
    public static void  postOrderTraversal(Node rootNode){
        if(null == rootNode){
            return;
          }
        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.print(rootNode.data+" ");
      
    }
    public static void levelOrderTraversal(Node rootNode){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootNode);
        Node current;
        while(!queue.isEmpty()){
            current = queue.remove();
            System.out.print(current.data+" ");
            if(current.left !=null){
                queue.add(current.left);
            }
            if(current.right !=null){
                queue.add(current.right);
            }
        }
            

    }
    public static boolean isSubtreeLesser(Node rootNode,int value){
        if(null == rootNode)
            return true;
        if(rootNode.data <= value && isSubtreeLesser(rootNode.left,value) 
            && isSubtreeLesser(rootNode.right,value)){
                return true;
            }else{
                return false; 
            }    
            
    }
    public static boolean isSubtreeGreater(Node rootNode,int value){
        if(null == rootNode)
            return true;
        if(rootNode.data > value && isSubtreeGreater(rootNode.left,value)
            && isSubtreeGreater(rootNode.right,value)){
                return true;
            }else{
                return false; 
            }    
    }
    public static boolean isBinarySearchTree(Node rootNode){
        if(null == rootNode){
            return true;
        }
        if(isSubtreeLesser(rootNode.left,rootNode.data) && isSubtreeGreater(rootNode.right,rootNode.data)
        && isBinarySearchTree(rootNode.left) && isBinarySearchTree(rootNode.right)){
            return true;
        }else{
            return false;
        }   
    }
    public static boolean isBinarySearchTreeEfficient(Node rootNode){
        return isBinarySearchTreeUtil(rootNode,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBinarySearchTreeUtil(Node rootNode,int min,int max){
        if(null == rootNode){
            return true;
        }
        if(rootNode.data>=min && rootNode.data < max &&
         isBinarySearchTreeUtil(rootNode.left,min,rootNode.data) && 
         isBinarySearchTreeUtil(rootNode.right,rootNode.data,max)){
            return true;
         }else{
            return false;
         }
    }
    /**
     * Not a known order, just trying to get tree elements in reverse sorted order.
     */
    public static void  reverseInOrderTraversal(Node rootNode){
        if(null == rootNode){
            return;
          }
        reverseInOrderTraversal(rootNode.right);
        System.out.print(rootNode.data+" ");
        reverseInOrderTraversal(rootNode.left);
      
    }
    /**
     * Convert BST to GST(Greater sum tree).
     * Value of every node is sum of all values greater than the node.
     */
  /*  public static void  bstToGst(Node rootNode){
        if(null == rootNode){
            return;
        }
        bstToGst(rootNode.right);
        gstValue = gstValue+ rootNode.val;
        rootNode.val = gstValue;
        System.out.print(rootNode.data+" ");
        bstToGst(rootNode.left);
      
    } */
    
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.rootNode = bst.addNode(bst.rootNode,15);
        bst.rootNode = bst.addNode(bst.rootNode,10);
        bst.rootNode = bst.addNode(bst.rootNode,20);
        bst.rootNode = bst.addNode(bst.rootNode,8);
        bst.rootNode = bst.addNode(bst.rootNode,12);
        bst.rootNode = bst.addNode(bst.rootNode,17);
        bst.rootNode = bst.addNode(bst.rootNode,25);

        System.out.println(bst.rootNode.data);
        System.out.println(bst.rootNode.left.data);
        System.out.println(bst.rootNode.right.data);
        System.out.println(bst.rootNode.left.right.data);   
        System.out.println(findHeight(bst.rootNode));   
        System.out.println(findMax(bst.rootNode));   
        System.out.println(findMin(bst.rootNode));  
        System.out.println("Level-order Traversal");
        levelOrderTraversal(bst.rootNode);
        System.out.println("\n Pre-order Traversal");
        preOrderTraversal(bst.rootNode);
        System.out.println("\n In-order Traversal");
        inOrderTraversal(bst.rootNode);
        System.out.println("\n Post-order Traversal");
        postOrderTraversal(bst.rootNode);
        System.out.println("");
        System.out.println(isBinarySearchTree(bst.rootNode));
        System.out.println(isBinarySearchTreeEfficient(bst.rootNode));
        System.out.println("\n Post-order Traversal");
        reverseInOrderTraversal(bst.rootNode);

        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.rootNode = bst1.addNode(bst.rootNode,20);
        bst1.rootNode = bst1.addNode(bst.rootNode,18);
        bst1.rootNode = bst1.addNode(bst.rootNode,22);
        bst1.rootNode = bst1.addNode(bst.rootNode,16);
        bst1.rootNode = bst1.addNode(bst.rootNode,15);
        bst1.rootNode = bst1.addNode(bst.rootNode,17);
        bst1.rootNode = bst1.addNode(bst.rootNode,19);
        bst1.rootNode = bst1.addNode(bst.rootNode,21);
        bst1.rootNode = bst1.addNode(bst.rootNode,24);
        bst1.rootNode = bst1.addNode(bst.rootNode,25);
        System.out.println("\n In-order Traversal");
        inOrderTraversal(bst1.rootNode);
        bst1.removeNode(bst1.rootNode,24);
        System.out.println("\n In-order Traversal");
        inOrderTraversal(bst1.rootNode);
    }   
}