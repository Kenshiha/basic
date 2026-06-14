package Tree;

public class Tree {
   private  TreeNode root;
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

    Tree(){
        root = null;
        size = 0;
    }

    public void insert(int val){

    }

    public static void main(String[] args){

    }
}
