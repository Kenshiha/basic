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

    public static void main(String[] args){

    }
}
