package Tree;

public class Tree {
   private  TreeNode root;
   private int size;

    public static class TreeNode{
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
        root = null;
        size = 0;
    }





    public static void main(String[] args){

        Tree myTree = new Tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


    }
}
