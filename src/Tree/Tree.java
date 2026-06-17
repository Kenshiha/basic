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

    public void insert(int val){

        TreeNode newRoot = new TreeNode(val);

        if(root == null){
            root = newRoot;
        }

        if(root.val < newRoot.val){
            root.left = newRoot;
        }else{
            root.right = newRoot;
        }

        size++;
    }

    public static void main(String[] args){

        Tree myTree = new Tree();

        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(6);

    }
}
