package Tree;

import jdk.dynalink.linker.LinkerServices;

public class BST {
    private TreeNode root;
    private int size;

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    BST(){
        root = null;
        size = 0;
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node,int val){
        if(node == null){
            size++;
            return new TreeNode(val);
        }

        if(val < node.val){
            node.left = insert(node.left, val);
        }else if(val > node.val){
            node.right = insert(node.right,val);
        }
        return node;
    }

    public void remove(){

    }

    public void display(TreeNode root){
        if(root == null){
            return;
        }

        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

    public static void main(String[] args){

        BST myTree = new BST();

        myTree.insert(10);
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(15);
        myTree.insert(12);
        myTree.insert(20);
        myTree.insert(7);
        myTree.insert(12);
        myTree.display(myTree.root);

    }
}
