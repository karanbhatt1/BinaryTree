package binarytree;
import java.util.Scanner;
class BinaryTree {
    static class Node{
        int val;
        Node lchild;
        Node rchild;
        Node(int value){
            this.val = value;
            this.lchild = null;
            this.rchild = null;
        }
    }
    public  Node createRoot(){
        System.out.println("enter the root node value:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        Node root = new Node(value);
        return root;
    }
     public void insert(Node root){
        Scanner sc = new Scanner(System.in);
        if(root==null){
            System.out.println("no root available for binary tree\nFirst create root node");
        }
        int isleft;
        System.out.println("Do you want to insert in left of ->" +root.val+"Y = 1\tN = 0");
        isleft = sc.nextInt();
        if(isleft==1){
            System.out.println("enter value for left child of:\t" +root.val);
            int value = sc.nextInt();
            root.lchild = new Node(value);
            insert(root.lchild);
        }
        int isRight;
        System.out.println("Do you want to insert in right of -->" + root.val +" y = 1\tN = 0");
        isRight = sc.nextInt();
        if(isRight==1){
            System.out.println("enter value for right child of:"+root.val);
            int value = sc.nextInt();
            root.rchild = new Node(value);
            insert(root.rchild);
        }
    }
    public void display(Node root){
        if(root==null){
            System.out.println("nothing to display");
        }
        System.out.println(root.val + "->");
        if(root.lchild!=null){
            display(root.lchild);
        }
        if(root.rchild!=null){
            display(root.rchild);
        }
    }
    public void achadekhnaha(Node root,int level){
        if(root==null){
            return;
        }
        achadekhnaha(root.lchild,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------------>"+root.val);
        }else{
            System.out.println(root.val);
        }
        achadekhnaha(root.rchild,level+1);

    }
}
public class BT{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root=null;
        tree.insert(root);
        tree.display(root);
        tree.achadekhnaha(root,0);
    }
}