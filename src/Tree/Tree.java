package Tree;

public class Tree {
    private int val;
    TreeNode root;

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

    Tree(){

        this.root = null;
    }
}
