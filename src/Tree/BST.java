package Tree;

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
        //logic for inserting value into tree
        TreeNode newNode = new TreeNode(val);

        if(root == null){
            root = newNode;
        }
    }

    public static void main(String[] args){

        Tree myTree = new Tree();

    }
}
