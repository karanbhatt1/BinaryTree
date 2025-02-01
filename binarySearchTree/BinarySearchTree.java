package binarySearchTree;
import java.util.Scanner;
class BST{
    static class Node{
        int val;
        Node lchild;
        Node rchild;

        private Node(int value){
            this.val = value;
            this.lchild = this.rchild = null;
        }
    }
    public Node createRoot(){
        System.out.println("enter the root node value:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        Node root = new Node(value);
        return root;
    }
    public  Node insert(int value,Node root){
        Scanner sc = new Scanner(System.in);
        if(root==null){
            Node node = new Node(value);
            return node;
        }
        if(value<root.val){
            root.lchild = insert(value,root.lchild);
        }
        if(value>root.val){
            root.rchild = insert(value,root.rchild);
        }
        return root;
    }
    public String searchBst(int value,Node node){
        if(node==null){
            return "not found";
        }
        if(node.val == value){
            return "value found";
        }
        if(value<node.val){
            return searchBst(value,node.lchild);
        }
        else if(value > node.val){
            return searchBst(value,node.rchild);
        }
        return "not found";
    }
    public void achadekhnaha(Node root, int level){
        if(root==null){
            return;
        }
        achadekhnaha(root.lchild,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------------->"+root.val);
        }else{
            System.out.println(root.val);
        }
        achadekhnaha(root.rchild,level+1);
    }
    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.lchild);
        int rightHeight = height(root.rchild);
        return 1+Math.max(leftHeight,rightHeight);
    }

}
public class BinarySearchTree {
    public static void main(String[] args) {
        BST bst = new BST();
        BST.Node root = bst.createRoot();
        bst.insert(12,root);
        bst.insert(15,root);
        bst.insert(11,root);
        bst.insert(10,root);
        bst.insert(85,root);
        bst.insert(122,root);
        bst.insert(56,root);
        bst.insert(87,root);

        bst.achadekhnaha(root,0);
        System.out.println("searching for element:::....");
        System.out.println(bst.searchBst(10,root));
        System.out.println(bst.height(root));
    }
}
